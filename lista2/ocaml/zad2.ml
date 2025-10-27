let splitNRec (n, list) = 
  let rec setParts n = 
    if n = 1 then [[]]
    else [] :: (setParts (n - 1))
  in

  let rec divideList list parts =
    match list with
    | [] -> parts
    | hd :: tl ->
        match parts with
        | [] -> []  (* nie powinno się zdarzyć *)
        | current :: rest_parts ->

          let rec add_element lst elem =
            match lst with
            | [] -> [elem]
            | x :: xs -> x :: add_element xs elem
          in

          let updated_current = add_element current hd in
          divideList tl (add_element rest_parts updated_current)
  in
  divideList list (setParts n)
;;

let splitNTail (n, list) = 
  let rec setParts (n, listOfLists) = 
    if n == 0 then listOfLists
    else setParts (n - 1, [] :: listOfLists)
  in

  let parts = setParts (n, []) in

  let rec divideList (list, parts, buffor) = 
    if list = [] then 
      if parts != [] then divideList([], List.tl parts, List.hd parts :: buffor)
      else buffor
    else
      if parts = [] then divideList (list, buffor, [])
      else 
        let x = List.hd list :: (List.hd parts) in
        divideList (List.tl list, List.tl parts, x :: buffor)
  in

  divideList (list, parts, [])
;;

splitNRec (3, [1;2;3;4;5;6]);;
splitNRec (3, []);;
splitNRec (3, [1]);;
splitNRec (3, [1;2]);;
splitNRec (3, [1;2;3]);;
splitNRec (3, [1;2;3;4]);;
splitNRec (4, ['a';'b';'c';'d';'e';'f';'g']);;

splitNTail (3, [1;2;3;4;5;6]);;
splitNTail (3, []);;
splitNTail (3, [1]);;
splitNTail (3, [1;2]);;
splitNTail (3, [1;2;3]);;
splitNTail (3, [1;2;3;4]);;
splitNTail (4, ['a';'b';'c';'d';'e';'f';'g']);;
