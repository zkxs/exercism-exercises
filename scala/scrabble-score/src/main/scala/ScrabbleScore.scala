object ScrabbleScore {

  val scores: Map[Char, Int] = Map(
    1 -> Seq('A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'),
    2 -> Seq('D', 'G'),
    3 -> Seq('B', 'C', 'M', 'P'),
    4 -> Seq('F', 'H', 'V', 'W', 'Y'),
    5 -> Seq('K'), // K is very lonely
    8 -> Seq('J', 'X'),
    10 -> Seq('Q', 'Z')
  ).flatMap(t => t._2.map((_, t._1)))

  def score(word: String): Int = word.toUpperCase.map(scores(_)).sum

}
