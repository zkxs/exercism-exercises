object BeerSong {
  def verse(n: Int): String = {
    verse1(n) + verse2(n)
  }

  def verses(begin: Int, end: Int): String = (begin to end by -1).map(verse).mkString("\n")

  private def verse1(n: Int): String = {
    if (n == 0) {
      "No more bottles of beer on the wall, no more bottles of beer.\n"
    } else if (n == 1) {
      "1 bottle of beer on the wall, 1 bottle of beer.\n"
    } else {
      val b = bottle(n)
      s"$b of beer on the wall, $b of beer.\n"
    }
  }

  private def verse2(n: Int): String = {
    if (n == 0) {
      "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
    } else if (n == 1) {
      "Take it down and pass it around, no more bottles of beer on the wall.\n"
    } else {
      s"Take one down and pass it around, ${bottle(n - 1)} of beer on the wall.\n"
    }
  }

  private def bottle(n: Int): String = {
    if (n == 1) {
      "1 bottle"
    } else {
      s"$n bottles"
    }
  }

}
