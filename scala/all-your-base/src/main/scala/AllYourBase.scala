object AllYourBase {
    def rebase(inputBase: Int, number: List[Int], outputBase: Int): Option[List[Int]] = {
        try {
            number.zipWithIndex.map(t => (t._1, number.size - t._2 - 1))
        } catch {
            case e: IllegalArgumentException => None
        }
    }
}
