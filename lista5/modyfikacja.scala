def layZip[A](list: LazyList[A]): LazyList[(A,A)] = {
  list match{
    case LazyList() =>
      LazyList.empty[(A,A)]
    case h1 #:: t1 =>
      t1 match{
        case LazyList() =>
          LazyList.empty[(A,A)]
        case h2 #:: t2 =>
          (h1, h2) #:: layZip(t2)
      }
  }
}

val list: LazyList[Char] = LazyList('a','b','c','d','e','f','g')
val result: LazyList[(Char, Char)] = layZip(list)


val list: LazyList[Char] = LazyList('a')
val result: LazyList[(Char, Char)] = layZip(list)

val list: LazyList[Int] = LazyList()
val result: LazyList[(Int, Int)] = layZip(list)

val list: LazyList[Int] = LazyList.from(0)
val result: LazyList[(Int, Int)] = layZip(list)
result.take(20).toList
