def fiddle22[A](input: ((A, A), (A, A))): ((A, A), (A, A)) =  
  val ((a, b),(c, d)) = input
  ((d, a), (b, c))

fiddle22(((1.3, 2.0), (3.1, 4.2)))
