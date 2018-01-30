import scala.annotation.tailrec

@tailrec
object PascalsTriangle {
    def rows(n: Int): List[List[Int]] = {
        if (n < 1) {
            List()
        } else if (n == 1) {
            List(List(1))
        } else {
            val restOfTriangle = rows(n - 1)
            val previousRow = 0 +: restOfTriangle.last :+ 0 // previous row, but wrapped in zeros to make our math easier
            val newRow = previousRow.sliding(2).map(_.sum)
            restOfTriangle :+ newRow.toList
        }
    }
}
