object Grains {
  // number of squares on a chessboard
  val maxSquare: Int = 64
  val two: BigInt = BigInt(2)

  // input may be out of bounds
  def square(n: Int): Option[BigInt] = {
    if (n < 1 || n > maxSquare) {
      // handle invalid input
      None
    } else {
      Some(two.pow(n - 1))
    }
  }

  def total: BigInt = (1 to maxSquare).map(square).map(_.get).sum

}
