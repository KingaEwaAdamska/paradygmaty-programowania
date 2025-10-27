let find (value, list) =
  let rec loop (index, list) =
    match list with
    | [] -> []
    | h::t -> if h = value then index :: loop (index + 1, t) else loop (index + 1, t)
  in
  loop (0, list)
;;

let make_finder list =
  fun value -> find (value, list)
;;

find (1, [])
find (1, [1])
find (2, [1])
find (2, [1;2;3])
find (3, [1;2;3;3])
find (0, [1;1;1])
find (5, [5;5;5;5])
find ('a', ['a';'b';'a';'c'])

let find123 = make_finder [1;2;3];;

find123 4;;
find123 1;;
find123 2;;
find123 3;;
