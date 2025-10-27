let rec insert (list, element) = 
  if list = [] then [(element, 1)]
  else
    let head = List.hd list in
    let tail = List.tl list in
    if fst head = element then (fst head, snd head + 1) :: tail
    else head :: insert (tail, element)
;;

insert [('a', 1); ('b', 2)] 'c';;
insert [('a', 1); ('b', 2)] 'b';;
