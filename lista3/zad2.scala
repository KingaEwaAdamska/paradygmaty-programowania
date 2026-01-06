def coprimes(a: Int, n: Int): List[Int] = {
  def isCoprime(x: Int, y: Int): Boolean = {
    val minValue = if (x < y) x else y
    val dividors = for (i <- List.range(2, minValue + 1); if (x % i == 0 && y % i == 0)) yield i
    dividors == Nil
  }
  
  for (b <- List.range(1, n + 1) if isCoprime(a, b)) yield b
}

coprimes(10,20)
coprimes(7,15)
coprimes(1,10)
coprimes(0,10)
coprimes(6,0)
coprimes(30,20)
coprimes(2,2)
