object Plant extends Enumeration {
    type Plant = Value
    val Grass, Clover, Radishes, Violets = Value
}

import Plant._

object Garden {
    private val plantMap = Map(
        'G' -> Grass,
        'C' -> Clover,
        'R' -> Radishes,
        'V' -> Violets
    )

    private val defaultChildren = List(
        "Alice",
        "Bob",
        "Charlie",
        "David",
        "Eve",
        "Fred",
        "Ginny",
        "Harriet",
        "Ileana",
        "Joseph",
        "Kincaid",
        "Larry"
    )

    def apply(children: List[String], diagram: String) = new Garden(children, diagram)
    def defaultGarden(diagram: String) = new Garden(defaultChildren, diagram)
}

import Garden._

class Garden(unsortedChildren: List[String], diagram: String) {

    // sort the children
    private val children = unsortedChildren.sorted

    // compute the plant groups
    private val plantGroups: IndexedSeq[List[Plant]] = {
        (diagram.split("\n") match {
            case Array(a, b) => a.grouped(2) zip b.grouped(2) // zip the first and second lines together
        })
            .map(t => t._1 ++ t._2) // merge the tuples into one iterable
            .map(_.map(plantMap.apply).toList)
            .toIndexedSeq
    }

    def plants(name: String): List[Plant] = {
        plantGroups(children.indexOf(name))
    }
}
