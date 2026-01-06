{
  sealed trait LLTree[A]
  case class Leaf[A](value: A) extends LLTree[A]
  case class Node[A](value: A, left: LLTree[A], right: Option[A]) extends LLTree[A]
}

val tree1: LLTree[Int] = Leaf(5)
val tree2: LLTree[Int] = Node(1, Leaf(2), None)
val tree3: LLTree[Int] = Node(1, Leaf(2), Some(3))
val tree4: LLTree[Int] = Node(1, Node(2, Leaf(3), Some(4)), Some(5))
val tree5: LLTree[Int] = Node(10, Node(20, Leaf(30), None), Some(40))
val treeS: LLTree[Int] = Node('a', Node('b', Leaf('c'), None), Some('d'))
