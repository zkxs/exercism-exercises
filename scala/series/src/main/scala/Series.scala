object Series {
  def slices(n: Int, s: String): List[List[Int]] = s.sliding(n)
    .map(
      // I could have done _.toString.toInt but I find ASCII math humorous
      w => w.map(_.toInt - '0').toList
    )
    .toList
}
