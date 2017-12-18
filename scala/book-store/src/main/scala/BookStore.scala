object BookStore {
    // prices for 1,2,3,4,5 books precomputed as cents
    val prices = Vector(800, 760, 720, 640, 600)

    def total(cart: List[Int]): Double = {
        if (cart.isEmpty) {
            0
        } else {

            // get counts of each book
            val bookCounts = cart.groupBy(identity).values.map(_.length).toSeq
            val max = bookCounts.max
            val nonMaxBooks = bookCounts.filter(_ != max)

            if (nonMaxBooks.isEmpty) {
                prices(bookCounts.length - 1) * max / 100.0
            } else {
                -1
                //TODO
            }
        }
    }
}