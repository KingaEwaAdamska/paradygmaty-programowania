def insert[A](list: List[(A, Int)], element: A): List[(A, Int)] =
  if (list == Nil) List((element, 1))
  else if (list.head._1 == element) (list.head._1, list.head._2 + 1) :: list.tail
  else list.head :: insert(list.tail, element)
  
insert(List(('a', 1), ('b', 2)), 'c')
insert(List(('a', 1), ('b', 2)), 'a')
