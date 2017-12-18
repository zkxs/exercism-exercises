
import NumberType._

object PerfectNumbers {
    def classify(n: Int): Either[String, NumberType] = {
        if (n > 0) {
            val aliquot = aliquotSum(n)
            if (aliquot == n) {
                Right(NumberType.Perfect)
            } else if (aliquot > n) {
                Right(NumberType.Abundant)
            } else {
                Right(NumberType.Deficient)
            }
        } else {
            Left("Classification is only possible for natural numbers.")
        }
    }

    // sum the factors that Nicomachus approves of
    def aliquotSum(n: Int): Int = {
        factor(n).sum
    }

    def factor(n: Int): Iterable[Int] = (1 until n).filter(n % _ == 0)
}
