let pascalGiftF n m =
  if n < 0 || m < 1 || n >= m then failwith "Wrong values" 
  else
    let rec getRow prevRow n =
      if n = 0 then prevRow
      else
        let rec countVals prevVal row = 
          match row with
          | [] -> []
          | h :: t -> (h + prevVal) :: countVals (h + prevVal) t
        in
      getRow (countVals 1 prevRow) (n-1)
    in

    let rec getFirstRow m = 
      if m = 1 then []
      else 1 :: getFirstRow (m-1)
    in

    1 :: getRow (getFirstRow m) n
;;


pascalGiftF 4 5;;
pascalGiftF 0 5;;
pascalGiftF 1 5;;
pascalGiftF 2 5;;
pascalGiftF 3 5;;
pascalGiftF 0 5;;
pascalGiftF 0 1;;
pascalGiftF 1 1;;
pascalGiftF 6 5;;

