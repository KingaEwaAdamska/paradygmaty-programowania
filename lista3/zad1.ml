let ( !? ) a =
  match a with
  | [] -> (fun _ -> 0.0)
  | _ ->
      fun x ->
        let rec loop list last =
          match list with
          | [] -> 0.0
          | h :: t -> 
              let next = last /. x in
              h *. last +. loop t next
        in
        loop a 1.0
;;

let f = !? [1.0;2.0;4.0;8.0];;
f 2.0;;
f 1.0;;

let g = !? [];;
g 1.0;;
g 2.0;;

let h = !? [2.5];;
h 1.0;;
h 2.0;;

