import scala.annotation.tailrec

object BinarySearch {
    /* doing a binary search on a linked-list backed data structure is foolish,
     * the exercise author should change this exercise to use an indexed data
     * structure, such as Vector
     */
    def find[T <: Ordered[T]](list: List[T], item: T): Option[Int] = find(list.toIndexedSeq, item)

    /* This overload is fine, because an IndexedSeq is not a List and
     * a List is not an IndexedSeq
     */
    def find[T <: Ordered[T]](seq: IndexedSeq[T], item: T): Option[Int] = findRecursive(seq, item, 0, seq.size - 1)

    //@tailrec
    def findRecursive[T <: Ordered[T]](seq: IndexedSeq[T], item: T, begin: Int, end: Int): Option[Int] = {
        ???
    }
}