import scala.annotation.tailrec

object PrimeFactors {

  // bootstrap our recursive function
  def factors(n: Long): List[Int] = {
    if (n < 2) {
      List.empty[Int]
    } else {
      factors(n, List.empty[Int])
    }
  }

  // recursively find all prime factors
  @tailrec
  def factors(n: Long, factorList: List[Int]): List[Int] = {
    val factor = getFactor(n)
    val newFactorList = factorList :+ factor
    val remaining = n / factor

    if (remaining == 1) { // check for end-condition
      newFactorList
    } else {
      factors(remaining, newFactorList)
    }
  }

  /**
    * Get the lowest prime factor of a number
    * @param n A number
    * @return the number's lowest prime factor
    */
  def getFactor(n: Long): Int = {
    // We could do a time-memory trade-off here by keeping a cache of prime numbers
    Stream.from(2).find(n % _ == 0).get
  }
}
