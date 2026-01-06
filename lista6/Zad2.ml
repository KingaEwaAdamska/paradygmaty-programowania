let pascalGiftI n m =
  if n < 0 || m < 1 || n >= m then failwith "Wrong values"
  else
    let arr = Array.make m 1 in
    let i = ref 0 in

    while !i < n do
      let j = ref 1 in
      while !j < Array.length arr do
        arr.(!j) <- arr.(!j) + arr.(!j - 1);
        incr j
      done;
      incr i
    done;

    arr
;;

pascalGiftI 4 5;;
pascalGiftI 0 5;;
pascalGiftI 1 5;;
pascalGiftI 2 5;;
pascalGiftI 3 5;;
pascalGiftI 0 5;;
pascalGiftI 0 1;;
pascalGiftI 1 1;;
pascalGiftI 6 5;;

