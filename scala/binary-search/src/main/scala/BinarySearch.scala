import scala.annotation.tailrec

object BinarySearch {
  /* doing a binary search on a linked-list backed data structure is foolish,
   * the exercise author should change this exercise to use an indexed data
   * structure, such as Vector
   */
  def find[T : Ordering](list: List[T], item: T): Option[Int] = findReal(list.toIndexedSeq, item)

  /* This overload is fine, because an IndexedSeq is not a List and
   * a List is not an IndexedSeq
   */
  def findReal[T : Ordering](seq: IndexedSeq[T], item: T): Option[Int] = binarySearch(seq, item, 0, seq.size - 1, implicitly[Ordering[T]])

  @tailrec
  private def binarySearch[T](seq: IndexedSeq[T], item: T, begin: Int, end: Int, ord: Ordering[T]): Option[Int] = {

    if (begin > end) {
      None
    } else {
      val index = (begin + end) / 2
      val checkItem: T = seq(index)

      if (ord.compare(item, checkItem) > 0) { // item > checkItem
        binarySearch(seq, item, index + 1, end, ord)
      } else if (ord.compare(item, checkItem) < 0) {
        binarySearch(seq, item, begin, index - 1, ord) // item < checkItem
      } else { // item == checkItem
        Some(index)
      }
    }
  }
}
