type 'a lltree =
  | Leaf of 'a  (* liść ma tylko własną wartość *)
  | Node of 'a * 'a lltree * 'a option (* node ma wartość własną, lewe poddrzewo oraz liścia lub nic jako prawe poddrzewo *)
;;

let rec mapLLTree f t =
  match t with
  | Leaf x -> Leaf (f x)
  | Node (value, left, right_opt) ->
      let new_value = f value in
      let new_left = mapLLTree f left in
      let new_right =
        match right_opt with
        | None -> None
        | Some r -> Some (f r)
      in
      Node (new_value, new_left, new_right)
;;

let tree1 = Leaf 5;;
let tree2 = Node (1, Leaf 2, None);;
let tree3 = Node (1, Leaf 2, Some 3);;
let tree4 = Node (1, Node (2, Leaf 3, Some 4), Some 5);;
let tree5 = Node (10, Node (20, Leaf 30, None), Some 40);;

let tree1d = mapLLTree(fun x -> x * 2) tree1;;
let tree2d = mapLLTree(fun x -> x * 2) tree2;;
let tree3d = mapLLTree(fun x -> x * 2) tree3;;
let tree4d = mapLLTree(fun x -> x * 2) tree4;;
let tree5d = mapLLTree(fun x -> x * 2) tree5;;

let treeS = Node ('a', Node ('b', Leaf 'c', None), Some 'd');;
