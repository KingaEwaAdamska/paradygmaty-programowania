let rec loop (i,l1, l2) =
    if l1 = [] then []
    else if (List.hd l1) = (List.hd l2) then (i :: loop ((i+1), (List.tl l1), (List.tl l2)))
    else loop ((i+1), (List.tl l1), (List.tl l2))
;;

let hits (l1, l2) = loop (0, l1, l2);;

hits ([1;2;3;4;5], [1;0;3;0;5]);;
