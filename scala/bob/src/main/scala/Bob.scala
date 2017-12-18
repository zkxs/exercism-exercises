object Bob {
  def response(input: String): String = {
    
    val statement = input.trim

    if (statement.isEmpty) {
      "Fine. Be that way!"
    } else if (statement == statement.toUpperCase && statement != statement.toLowerCase) {
      "Whoa, chill out!"
    } else if (statement.endsWith("?")) {
      "Sure."
    } else {
      "Whatever."
    }
  }
}
