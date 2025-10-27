let find (value, list) =
  let rec loop (list, indexes, actIndex) =
    match list with
    | [] -> List.rev indexes
    | x :: xs ->
        if x = value then
          loop (xs, actIndex :: indexes, actIndex + 1)
        else
          loop (xs, indexes, actIndex + 1)
  in
  loop (list, [], 0)
;;

let make_finder list =
  fun value -> find (value, list)
;;

let find123 = make_finder [1;2;3];;

if find (1, []) = [] then print_endline "Passed" else print_endline "Not passed";;
if find (1, [1]) = [0] then print_endline "Passed" else print_endline "Not passed";;
if find (2, [1]) = []then print_endline "Passed" else print_endline "Not passed";;
if find (2, [1;2;3]) = [1] then print_endline "Passed" else print_endline "Not passed";;
if find (3, [1;2;3;3]) = [2;3] then print_endline "Passed" else print_endline "Not passed";;
if find (0, [1;1;1]) = [] then print_endline "Passed" else print_endline "Not passed";;
if find (5, [5;5;5;5]) = [0;1;2;3] then print_endline "Passed" else print_endline "Not passed";;
if find ('a', ['a';'b';'a';'c']) = [0;2] then print_endline "Passed" else print_endline "Not passed";;

if find123 4 = [] then print_endline "Passed" else print_endline "Not passed";;
if find123 1 = [0] then print_endline "Passed" else print_endline "Not passed";;
if find123 2 = [1] then print_endline "Passed" else print_endline "Not passed";;
if find123 3 = [2] then print_endline "Passed" else print_endline "Not passed";;
