import scala.collection.mutable.MutableList

// flatten a list without .flatten or .flatMap
object FlattenArray {

    // this exercise seems purpose-built to kill my type-safety
    def flatten(list: List[_]): List[Any] = {
        val accumulator = MutableList.empty[Any]

        for (item <- list) {
            item match {
                case subList: List[_] => accumulator ++= flatten(subList) // if it looks like a list, flatten it (this is NOT tail-recursive)
                case null => // remove nulls
                case _ => accumulator += item
            }
        }

        accumulator.toList
    }
}
