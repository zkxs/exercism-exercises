class Accumulate {

  // apparently list.map(f) is too easy and I must reinvent the wheel here
  // apparently "idiomatic" language features are ok, it's just library functions that are not
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = for (e <- list) yield f(e)
  // wow such language feature
}
