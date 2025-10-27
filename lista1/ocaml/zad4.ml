(* Stałe *)
let monthsWith30Days = [4; 6; 9; 11];;
let monthsWith31Days = [1; 3; 5; 7; 8; 10; 12];;

let days31 = 31;;
let days30 = 30;;
let days28 = 28;;
let days29 = 29;;

let leapDivisibleBy400 = 400;;
let leapDivisibleBy4 = 4;;
let leapDivisibleBy100 = 100;;

let monthsInYear = 12;;

(* Funkcje *)
let isLeapYear year =
  (year mod leapDivisibleBy400 = 0) || ((year mod leapDivisibleBy4 = 0) && (year mod leapDivisibleBy4 <> 0))
;;

let daysInMonth month year =
  if List.mem month monthsWith31Days then days31
  else if List.mem month monthsWith30Days then days30
  else if isLeapYear year then days29
  else days28
;;

let theVeryNextDay (day, month, year) =
  if month <= 0 || month > monthsInYear then failwith "Błąd: podano błędną datę!"
  else 
    let dim = daysInMonth month year in
    if day <= 0 || day > dim then failwith "Błąd: podano błędną datę!"
    else if day < dim then (day + 1, month, year)
    else if month < monthsInYear then (1, month + 1, year)
    else (1, 1, year + 1)
;;
 
theVeryNextDay (21, 10, 2025);;
theVeryNextDay (31, 12, 2025);;

