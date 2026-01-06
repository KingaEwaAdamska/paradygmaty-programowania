def permutationsL[A](list: LazyList[A]): LazyList[LazyList[A]] = {
  if (list.isEmpty) LazyList(LazyList.empty[A])
  else {
    val head: A = list.head
    val tail: LazyList[A] = list.tail

    val permutationsOfTail: LazyList[LazyList[A]] = permutationsL(tail)
    def interleave(elem: A, p: LazyList[A]): LazyList[LazyList[A]] =
      p match {
        case LazyList() =>
          LazyList(LazyList(elem))
        case headP #:: tailP =>
          (elem #:: p) #:: interleave(elem, tailP).map(headP #:: _)
      }

    permutationsOfTail.flatMap { p =>
      interleave(head, p)
    }
  }
}

val list: LazyList[Int] = LazyList(1,2,3)
val result: LazyList[LazyList[Int]] = permutationsL(list)
result.map(_.toList).toList


val list: LazyList[Int] = LazyList(1)
val result: LazyList[LazyList[Int]] = permutationsL(list)
result.map(_.toList).toList


val list: LazyList[Int] = LazyList()
val result: LazyList[LazyList[Int]] = permutationsL(list)
result.map(_.toList).toList

val list: LazyList[Char] = LazyList('a','b','c','d')
val result: LazyList[LazyList[Char]] = permutationsL(list)
result.map(_.toList).toList
