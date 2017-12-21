object House {

  private val newLine = "\r\n" // wtf... why?

  case class Item(verb: String, item: String)

  private val items = Vector(
    Item(null, "horse and the hound and the horn"), // first line's verb is never used
    Item("belonged to", "farmer sowing his corn"),
    Item("kept", "rooster that crowed in the morn"),
    Item("woke", "priest all shaven and shorn"),
    Item("married", "man all tattered and torn"),
    Item("kissed", "maiden all forlorn"),
    Item("milked", "cow with the crumpled horn"),
    Item("tossed", "dog"),
    Item("worried", "cat"),
    Item("killed", "rat"),
    Item("ate", "malt"),
    Item("lay in", "house that Jack built.")
  )

  def verses(begin: Int, end: Int): String = (begin to end).map(verse).mkString

  def verse(n: Int): String = {
    val startIdx = items.length - n
    firstLine(startIdx) + Range(startIdx + 1, items.length).map(genericLine).mkString + newLine
  }

  def firstLine(n: Int): String = s"This is the ${items(n).item}$newLine"

  def genericLine(n: Int): String = s"that ${items(n).verb} the ${items(n).item}$newLine"
}
