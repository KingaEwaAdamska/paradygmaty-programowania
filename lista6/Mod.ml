let sieve n = 
  if n <= 3 then [||]
  else 
    let primeNums = Array.make (n/2) 0 in
    let primeNumsId = ref 2 in
    primeNums.(0) <- 2;
    primeNums.(1) <- 3;

    let nums = Array.make (n - 3) 0 in
    let numsId = ref 0 in

    let i = ref 4 in
    while !i <= n do
      let j = ref 0 in
      let ifprime = ref true in
      while !j < !primeNumsId do
        if  !i mod (primeNums).(!j) = 0 then
          ifprime := false; 
        incr j
      done;

      if !ifprime then begin
        primeNums.(!primeNumsId) <- !i;
        incr primeNumsId 
      end else begin
        nums.(!numsId) <- !i;
        incr numsId 
      end;
      incr i
    done;
    Array.sub nums 0 !numsId
;;

sieve 20;;
sieve 2;;
sieve 0;;
sieve 1;;
sieve 3;;
sieve 4;;
