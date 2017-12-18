object BookStore {
    // prices for 0,1,2,3,4,5 book-groups precomputed as cents
    val prices = Array(0, 800, 1520, 2160, 2560, 3000)

    val numBooks = 5

    def total(cart: List[Int]): Double = {
        intTotal(cart) / 100.0
    }

    def intTotal(cart: List[Int]): Int = {
        if (cart.isEmpty) {
            0 // List().max does not return 0, so we have to explicitly check for an empty cart
        } else {
            // get counts of each book
            val bookCounts = cart.groupBy(identity).values.map(_.length).toSeq
            val max = bookCounts.max // the book with the most duplicates has this many duplicates
            val nonMaxBookCounts = bookCounts.filter(_ != max)

            if (nonMaxBookCounts.isEmpty) {
                calculateDiscount(bookCounts.length) * max
            } else {
                // how many books have the maximal number of books in this dataset?
                val maxBookCountLength = bookCounts.length - nonMaxBookCounts.length

                // number of groups = max
                // initial number of books in each group = maxBookCountLength
                val groups = new GroupedCart(max, maxBookCountLength)
                // now we need to distribute the nonMaxBookCounts amongst the groups

                permuteGroups(groups, nonMaxBookCounts, maxBookCountLength, max)
            }
        }
    }

    def permuteGroups(groups: GroupedCart, bank: Seq[Int], bookIndex: Int, numGroups: Int): Int = {
        
        // we have already distributed the first bookIndex books.
        // distribute bank(bankIndex) amongst groups(bookIndex)

        val bankedBooks = bank.head
        val nextBank = bank.tail

        val permutations = (0 until numGroups).map(_ < bankedBooks).permutations.map(p => groups.set(bookIndex, p))

        if (nextBank.isEmpty) {
            // we just did the last book placement
            permutations.map(_.discount).min
        } else {
            // we need to do the next book placement
            permutations.map(permutation => permuteGroups(permutation, nextBank, bookIndex + 1, numGroups)).min
        }
    }

    // calculate discount for a single group of books
    def calculateDiscount(groupSize: Int): Int = {
        prices(groupSize)
    }
}

// list of book placements, where each "book placement" is a list of booleans corresponding to group numbers
// outer Vector index is the book number, 0-4 (assuming a 5-book series)
// inner Vector index is the group number, 0-n
// value is true if that group contains that book
class GroupedCart(val groups: IndexedSeq[IndexedSeq[Boolean]]) {

    // auxiliary constructor that's actually usable by people
    def this(numGroups: Int, numMaxBooks: Int) = this(
        (0 until BookStore.numBooks)
            .map(i => IndexedSeq.fill(numGroups)(i < numMaxBooks))
    )

    def set(book: Int, bookPlacements: IndexedSeq[Boolean]): GroupedCart = {
        val updatedGroups = groups.updated(book, bookPlacements)
        new GroupedCart(updatedGroups)
    }

    def discount: Int = {
        groups
            .transpose // make this into a list of groups (it was a list of book placements)
            .map(group => BookStore.calculateDiscount(group.filter(_ == true).length)) // count things in the group, then pass that to calculateDiscount()
            .sum // sum the group prices
    }

}
