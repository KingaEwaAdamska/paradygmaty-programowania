def priorityAB[A](a: Int, b: Int, list: List[A]): List[A] = {
  def extract(id: Int, list1: List[A], list2: List[A]): (List[A], List[A]) = {
    list1 match {
      case hd :: tl =>
        if (id < a)
          val (l1, l2) = extract(id + 1, tl, list2)
          (hd :: l1, l2)
        else if (id <= b)
          val (l1, l2) = extract(id + 1, tl, list2)
          (l1, hd :: l2)
        else
          (list1, list2)
      case Nil => (Nil, list2)
    }
  }

  val (list1, list2) = extract(0, list, Nil)
  list2 ::: list1
}

priorityAB(2,4,List(1,2,3,4,5,6,7,8,9))
