object Isogram {
  private val range = 'a' to 'z'

  def isIsogram(word: String): Boolean = {
    if (word.isEmpty) {
      true // I honestly don't think "" should be an isogram, but whatever
    } else {
      word
        .toLowerCase // make the case consistent
        .filter(range.contains) // filter out non-letters
        .groupBy(identity) // get a mapping of letters to all of their occurrences
        .values // throw away the keys
        .view // makes the following operations computed but not stored
        .map(_.length) // how many times each letter occurs
        .max == 1 // does any letter occur more than once?
    }
  }
}
