case class WordCount(input: String) {

  import WordCount._

  def countwords: Map[String, Int] = {
    val cleanedInput = removeRegex.replaceAllIn(input, "").toLowerCase
    val splitInput = splitRegex.split(cleanedInput)
    val dequotedInput = splitInput.map(word => quoteRegex.replaceAllIn(word, _ match {
      case quoteRegex(unquotedWord, null) => unquotedWord
      case quoteRegex(null, unquotedWord) => unquotedWord
      case _ => word
    }))

    dequotedInput
      .groupBy(identity)
      .mapValues(_.length)
  }
}

object WordCount {
  private val splitRegex = """[\s,]+""".r
  private val removeRegex = """[^A-Za-z0-9 ,'"]""".r
  private val quoteRegex = """^"(.*)"|'(.*)'$""".r
}
