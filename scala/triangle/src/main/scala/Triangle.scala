case class Triangle(a: Double, b: Double, c: Double) {
  def equilateral: Boolean = a == b && b == c && legal
  def isosceles: Boolean = (a == b || b == c || c == a) && legal
  def scalene: Boolean = a != b && b != c && c != a && legal

  def legal: Boolean = !illegal
  def illegal: Boolean = hasZeroSide || !tringleInequality
  def hasZeroSide: Boolean = a == 0 || b == 0 || c == 0
  def tringleInequality: Boolean = {

    // figure out which side is the longest
    val (z, x, y) = {
      if (a > b && a > c) {
        (a, b, c) // a is the longest
      } else if (b > a && b > c) {
        (b, a, c) // b is the longest
      } else {
        (c, a, b) // c is the longest
      }
    }

    z <= x + y
  }
}
