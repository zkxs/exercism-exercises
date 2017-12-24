import scala.collection.mutable

class DNA(val input: String) {
  def nucleotideCounts: Either[Boolean, Map[Char, Int]] = {
    val map = input.groupBy(identity).mapValues(_.length)
    val mutableMap = mutable.Map(map.toSeq: _*)

    mutableMap.getOrElseUpdate('G', 0)
    mutableMap.getOrElseUpdate('C', 0)
    mutableMap.getOrElseUpdate('A', 0)
    mutableMap.getOrElseUpdate('T', 0)

    if (mutableMap.size > 4) {
      Left(true)
    } else {
      Right(mutableMap.toMap)
    }
  }
}
