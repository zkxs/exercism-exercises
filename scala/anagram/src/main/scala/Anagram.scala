object Anagram {
  def anagrams(input: String, list: List[String]): List[String] = {
    val inputCounts = letterCount(input)

    list
      .filter(item => letterCount(item) == inputCounts)
      .filter(item => !(item equalsIgnoreCase input))
  }

  def letterCount(input: String): Map[Char, Int] = {
    input.toLowerCase.groupBy(identity).mapValues(_.length)
  }
}
