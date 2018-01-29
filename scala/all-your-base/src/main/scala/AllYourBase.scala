import scala.collection.mutable.MutableList

object AllYourBase {

    def rebase(inputBase: Int, number: List[Int], outputBase: Int): Option[List[Int]] = {
        numberToInt(inputBase, number).flatMap(n => intToNumber(n, outputBase))
    }

    def numberToInt(inputBase: Int, number: List[Int]): Option[Int] = {
        if (inputBase >= 2
            && number.nonEmpty
            && number(0) != 0
            && !number.exists(_ < 0)
            && !number.exists(_ >= inputBase)
        ) {
            Some(
                number
                    .zipWithIndex
                    .map(t => (t._1, number.size - t._2 - 1))
                    .map(t => {
                        val (n, place) = t
                        n * Math.pow(inputBase, place).toInt
                    })
                    .sum
            )
        } else {
            None
        }
    }

    def intToNumber(number: Int, outputBase: Int): Option[List[Int]] = {
        if (outputBase >= 2) {
            val list = MutableList.empty[Int]
            var r = number
            while (r != 0) {
                (r % outputBase) +=: list // prepend to list
                r /= outputBase
            }
            Some(list.toList)
        } else {
            None
        }
    }

}
