type 'a llist =
  | LNil
  | LCons of 'a * 'a llist Lazy.t
;;

let rec lfrom k = LCons (k, lazy(lfrom(k+1)));;

let rec ltake (n, lxs) =
  match n, lxs with
  | 0, _ -> []
  | _, LNil -> []
  | n, LCons (x, xf) ->
      x :: ltake (n - 1, Lazy.force xf)
;;

let rec toLazyList xs =
match xs with
[] -> LNil
| h::t -> LCons(h, lazy(toLazyList t));;

let rec lcombine f xs ys =
  match xs, ys with
  | LNil, _ -> LNil
  |_, LNil -> LNil
  | LCons(xh, xt), LCons(yh, yt) ->
      LCons (f xh yh,  lazy(lcombine f (Lazy.force xt) (Lazy.force yt)))
;;

let l1 = lfrom 10;;
let l2 = lfrom 0;;
let l3 = toLazyList([1]);;
let l4 = toLazyList([1;2;3]);;

let lr = lcombine (fun a b -> a + b) l1 l2;;
let lr = lcombine (fun a b -> a + b) l2 l3;;
let lr = lcombine (fun a b -> a + b) l4 l1;;

ltake(10, lr);;
