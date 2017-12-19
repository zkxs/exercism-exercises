object Pangrams {

  val letters = ('a' to 'z').toSet

  def isPangram(input: String): Boolean = {
    val inputSet = input.toLowerCase.groupBy(identity).keySet
    val difference = (letters &~ inputSet)
    difference.isEmpty
  }
}

