object DifferenceOfSquares {

  def sumOfSquares(n: Int): Int = (1 to n).map(x => x * x).sum

  def squareOfSum(n: Int): Int = {
    val sum = n * (n + 1) / 2
    sum * sum
  }

  def differenceOfSquares(n: Int): Int = squareOfSum(n) - sumOfSquares(n)
}
