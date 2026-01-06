type product_id = string;;

type product_type = 
  | Unit 
  | Kilogram
;;

type product = {
  code : product_id;
  name : string;
  price : float;
  product_type : product_type;
};;

type receipt_item = product_id * float;;

type receipt = receipt_item list;;

type receipts = receipt list;;

type product_database = product list;;


let prettyPrint (receipt : receipt) (db : product_database) : string =
  let rec find_product code db = 
    match db with
    | [] -> None
    | product :: rest -> if product.code = code then Some product else find_product code rest
  in
  
  let process_item (code, quantity) =
    match find_product code db with
    | Some product ->
        let product_type_str = match product.product_type with
          | Unit -> "unit"
          | Kilogram -> "kilogram"
        in
        let total_price = product.price *. quantity in
        Printf.sprintf "%-15s %-10s %5.1f %4.2f %5.1f" 
          product.name product_type_str quantity product.price total_price
    | None -> 
        Printf.sprintf "%-15s %-10s %5.1f %4.2f %5.1f" 
          "Unknown" "unknown" quantity 0.0 0.0
  in
  
  let header = Printf.sprintf "%-15s %-10s %5s %4s %5s\n" "Name" "Type" "Qty" "Price" "Total" ^
               Printf.sprintf "%s" "---------------------------------------------"
  in
  
  let lines = List.map process_item receipt in
  let body = String.concat "\n" lines in
  header ^ "\n" ^ body
;;

let demand (product_name : string) (receipts : receipts) (db : product_database) : (product_type * float) option =
  let rec find_product_in_db db =
    match db with
    | [] -> None
    | product :: rest ->
        if product_name = product.name then Some product else find_product_in_db rest
  in
  match find_product_in_db db with
  | None -> None
  | Some product ->
      let code = product.code in
      let rec sum_in_receipts code receipts=
        match receipts with
        | [] -> 0.0
        | r :: rs ->
          let rec sum_in_receipt receipt =
            match receipt with
            | [] -> 0.0
            | (c, qty) :: t ->
                if c = code then qty +. sum_in_receipt t
                else sum_in_receipt t
          in
          sum_in_receipt r +. sum_in_receipts code rs
      in
      let total_amount = sum_in_receipts code receipts in
      Some (product.product_type, total_amount)
;;

let example_db_1 = [
  {code = "P001"; name = "Apple"; price = 2.5; product_type = Kilogram};
  {code = "P002"; name = "Notebook"; price = 3.0; product_type = Unit};
  {code = "P003"; name = "Banana"; price = 1.8; product_type = Kilogram}
];;
let example_db_empty = [];;

let example_receipt_1 = [("P001", 2.0); ("P002", 3.0); ("P003", 1.5)];;
let example_receipt_empty = [];;

let example_receipts_1 = [
  [("P001", 2.0); ("P002", 3.0); ("P003", 1.5)];
  [];
  [("P001", 2.0)]
];;

let example_receipts_empty = [
];;

let result = prettyPrint example_receipt_1 example_db_1;;
print_endline result;;

let result = prettyPrint example_receipt_empty example_db_1;;
print_endline result;;

let result = prettyPrint example_receipt_1 example_db_empty;;
print_endline result;;

demand "Apple" example_receipts_1 example_db_1;;
demand "Notebook" example_receipts_1 example_db_1;;
demand "Banana" example_receipts_1 example_db_1;;
demand "Pen" example_receipts_1 example_db_1;;
demand "Apple" example_receipts_empty example_db_1;;
demand "Apple" example_receipts_1 example_db_empty;;
demand "Apple" example_receipts_empty example_db_empty;;
demand "Pen" example_receipts_empty example_db_1;;
