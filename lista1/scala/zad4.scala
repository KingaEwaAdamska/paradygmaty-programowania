// Stałe
val monthsWith30Days = List(4, 6, 9, 11)
val monthsWith31Days = List(1, 3, 5, 7, 8, 10, 12)

val days31 = 31
val days30 = 30
val days29 = 29
val days28 = 28

val leapDivisibleBy400 = 400
val leapDivisibleBy100 = 100
val leapDivisibleBy4 = 4

val monthsInYear = 12

// Funkcje
def isLeapYear(year: Int): Boolean =
  (year % leapDivisibleBy400 == 0) || ((year % leapDivisibleBy4 == 0) && (year % leapDivisibleBy100 != 0))

def daysInMonth(month: Int, year: Int): Int =
  if (monthsWith31Days.contains(month)) days31
  else if (monthsWith30Days.contains(month)) days30
  else if (isLeapYear(year)) days29
  else days28

def theVeryNextDay(day: Int, month: Int, year: Int): (Int, Int, Int) = {
  if (month <= 0 || month > monthsInYear) throw new IllegalArgumentException("Błąd: podano błędną datę!")
  else {
    val dim = daysInMonth(month, year)
    if (day <= 0 || day > dim) throw new IllegalArgumentException("Błąd: podano błędną datę!")
    else if (day < dim) (day + 1, month, year)
    else if (month < monthsInYear) (1, month + 1, year)
    else (1, 1, year + 1)
  }
}
