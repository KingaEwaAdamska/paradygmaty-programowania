def splitNRec(n: Int, list: List[Any]): List[List[Any]] = {
  def setParts(n: Int): List[List[Any]] =
    if (n == 1) List(List())
    else List() :: setParts(n - 1)

  def divideList(list: List[Any], parts: List[List[Any]]): List[List[Any]] = list match {
    case Nil => parts
    case hd :: tl => parts match {
      case Nil => Nil  // nie powinno się zdarzyć
      case current :: rest_parts =>

        def add_element[A](lst: List[A], elem: A): List[A] = lst match {
          case Nil => List(elem)
          case x :: xs => x :: add_element(xs, elem)
        }

        val updated_current: List[Any] = add_element(current, hd)
        divideList(tl, add_element(rest_parts, updated_current))
    }
  }

  divideList(list, setParts(n))
}

def splitNTail(n: Int, list: List[Any]): List[List[Any]] = {
  def setParts(n: Int, listOfLists: List[List[Any]]): List[List[Any]] =
    if (n == 0) listOfLists
    else setParts(n - 1, List() :: listOfLists)

  val parts = setParts(n, Nil)

  def divideList(list: List[Any], parts: List[List[Any]], buffor: List[List[Any]]): List[List[Any]] = {
    if (list.isEmpty)
      if (parts.nonEmpty)
        divideList(Nil, parts.tail, parts.head :: buffor)
      else buffor
    else if (parts.isEmpty)
      divideList(list, buffor, Nil)
    else {
      val x = list.head :: parts.head
      divideList(list.tail, parts.tail, x :: buffor)
    }
  }

  divideList(list, parts, Nil)
}

splitNRec(3, List(1, 2, 3, 4, 5, 6))
splitNRec(3, List())
splitNRec(3, List(1))
splitNRec(3, List(1, 2))
splitNRec(3, List(1, 2, 3))
splitNRec(3, List(1, 2, 3, 4))
splitNRec(4, List('a', 'b', 'c', 'd', 'e', 'f', 'g'))

splitNTail(3, List(1, 2, 3, 4, 5, 6))
splitNTail(3, List())
splitNTail(3, List(1))
splitNTail(3, List(1, 2))
splitNTail(3, List(1, 2, 3))
splitNTail(3, List(1, 2, 3, 4))
splitNTail(4, List('a', 'b', 'c', 'd', 'e', 'f', 'g'))
