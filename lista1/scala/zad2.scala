def loop[A](l1: List[A], l2: List[A], i: Int): List[Int] =
  if (l1 == Nil) Nil
  else if (l1.head == l2.head) i :: loop(l1.tail, l2.tail, i+1)
  else loop(l1.tail, l2.tail, i+1)
  
def hits[A](l1: List[A], l2: List[A]): List[Int] = 
  loop(l1, l2, 0)

hits (List(1,2,3,4,5), List(1,0,3,0,5))
