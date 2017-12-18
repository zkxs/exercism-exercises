import scala.collection.mutable
import scala.collection.mutable.MutableList

class School {
  type DB = Map[Int, Seq[String]]

  val map: mutable.SortedMap[Int, MutableList[String]] = mutable.TreeMap.empty
  
  // Add a student's name to the roster for a grade
  def add(name: String, g: Int): Unit = {
    val grade = map.getOrElseUpdate(g, MutableList.empty[String])
    grade += name
  }

  //Get all students in all grades.
  def db: DB = {
    map.toMap
  }

  // Get a list of all students enrolled in a grade
  def grade(g: Int): Seq[String] = {
    map.get(g).getOrElse(Seq.empty)
  }

  // Get a sorted list of all students in all grades.
  // Grades should sort as 1, 2, 3, etc.
  // students within a grade should be sorted alphabetically by name.
  def sorted: DB = {
    map.toMap.mapValues(_.toArray.sorted.toSeq)
  }
}
