import scala.util.Random

class Robot() {
  var name: String = NameGenerator.nextName
  def reset(): Unit = name = NameGenerator.nextName
}

object NameGenerator {

  val letterRange = 'A' to 'Z'
  val digitRange = '0' to '9'

  def nameSeries: IndexedSeq[String] = {
    val series = for (l1 <- letterRange; l2 <- letterRange; d1 <- digitRange; d2 <- digitRange; d3 <- digitRange) yield {
      "" + l1 + l2 + d1 + d2 + d3
    }

    Random.shuffle(series)
  }

  lazy val randomSource: IndexedSeq[String] = nameSeries
  var index: Int = 0

  def nextName: String = {
    val toReturn = randomSource(index)

    index += 1
    if (index >= randomSource.length) {
      index = 0
    }

    toReturn
  }
}
