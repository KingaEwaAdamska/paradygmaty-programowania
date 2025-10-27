def find[A](value: A, list: List[A]): List[Int] = {
  def loop(index: Int, list: List[A]): List[Int] = list match {
    case Nil => Nil
    case h :: t => 
      if (h == value) index :: loop(index + 1, t)
      else loop(index + 1, t)
  }
  loop(0, list)
}

def makeFinder[A](list: List[A]): A => List[Int] = {
  fun value => find(value, list)
}

// Test cases
find(1, List())
find(1, List(1))
find(2, List(1))
find(2, List(1, 2, 3))
find(3, List(1, 2, 3, 3))
find(0, List(1, 1, 1))
find(5, List(5, 5, 5, 5))
find('a', List('a', 'b', 'a', 'c'))

val find123 = makeFinder(List(1, 2, 3))

find123(4)
find123(1)
find123(2)
find123(3)
