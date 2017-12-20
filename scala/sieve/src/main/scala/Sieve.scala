/* So I made one decision that made this unnecessarily complicated:
 * I decided not to store 0 or 1 in my array. This means the values
 * of the array are 2 greater than their index.
 */

object Sieve {

  private val firstPrime = 2

  def primes(n: Int): List[Int] = {
    // n is the last number, therefore n + 1 is the length
    val arr = Array.fill(primeToIndex(n) + 1)(true)

    var index = 0

    do {
      val prime = indexToPrime(index)

      for (i <- prime * prime to n by prime) {
        arr(primeToIndex(i)) = false
      }

      index = arr.indexWhere(identity, index + 1)
    } while (index != -1)

    arr.zipWithIndex.withFilter(_._1).map(idx => indexToPrime(idx._2)).toList
  }

  private def primeToIndex(prime: Int) = prime - firstPrime
  private def indexToPrime(index: Int) = index + firstPrime
}
