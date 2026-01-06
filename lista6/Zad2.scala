def pascalGiftI(n: Int, m: Int): Array[Int] = {
  if (n < 0 || m < 1 || n >= m)
    throw new IllegalArgumentException("Wrong values")

  val arr = Array.fill(m)(1)
  var i = 0

  while (i < n) {
    var j = 1
    while (j < arr.length) {
      arr(j) = arr(j) + arr(j - 1)
      j += 1
    }
    i += 1
  }

  arr
}

pascalGiftI(4, 5)
pascalGiftI(0, 5)
pascalGiftI(1, 5)
pascalGiftI(2, 5)
pascalGiftI(3, 5)
pascalGiftI(0, 5)
pascalGiftI(0, 1)
pascalGiftI(1, 1)
pascalGiftI(6, 5)
