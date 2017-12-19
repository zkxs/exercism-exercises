import scala.annotation.tailrec

object Strain {
  def keep[T](seq: Seq[T], predicate: T => Boolean): Seq[T] = {
    // technically for/yield is not a part of the standard library
    // I suppose I could have done something with iteration and mutable lists, but that's gross
    for (elem <- seq if predicate(elem)) yield {
      elem
    }
  }

  // I feel that I need more swag, so let's swag this one up (I could have just done keep(seq, predicate.andThen(x => !x)))
  def discard[T](seq: Seq[T], predicate: T => Boolean): Seq[T] = discardResursive(seq, Seq.empty[T], predicate)

  @tailrec
  def discardResursive[T](in: Seq[T], out: Seq[T], predicate: T => Boolean): Seq[T] = {
    if (in.isEmpty) {
      out
    } else {
      val head = in.head
      if (predicate(head)) {
        // disard
        discardResursive(in.tail, out, predicate)
      } else {
        // keep
        discardResursive(in.tail, out :+ head, predicate)
      }
    }
  }
}