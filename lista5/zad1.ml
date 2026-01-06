type 'a llist =
  | LNil
  | LCons of 'a * (unit -> 'a llist)
;;

let rec lsplit lxs =
  let rec evenHelper ls n = 
    match ls with
    | LNil -> LNil
    | LCons(h, t) -> 
        if n mod 2 == 0 then 
          LCons(h, fun () -> evenHelper (t()) (n + 1))
        else
          evenHelper (t()) (n + 1)
  in
  let rec oddHelper ls n = 
    match ls with
    | LNil -> LNil
    | LCons(h, t) -> 
        if n mod 2 == 1 then 
          LCons(h, fun () -> oddHelper (t()) (n + 1))
        else
          oddHelper (t()) (n + 1)
  in
  (evenHelper lxs 0, oddHelper lxs 0)
;;

let rec ltake (n, lxs) =
match (n, lxs) with
(0, _) -> []
| (_, LNil) -> []
| (n, LCons(x,xf)) -> x::ltake(n-1, xf())
;;

let rec lfrom k = LCons (k, fun () -> lfrom (k+1));;

let rec toLazyList xs =
match xs with
[] -> LNil
| h::t -> LCons(h, function () -> toLazyList t);;

let lz = lfrom 0;;
let lz1 = toLazyList([]);;
let lz2 = toLazyList([1]);;
let lz3 = toLazyList([2,3]);;
let (even, odd) = lsplit lz;;


