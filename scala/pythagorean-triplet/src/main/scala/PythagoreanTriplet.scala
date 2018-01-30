object PythagoreanTriplet {
    type Triplet = (Int, Int, Int)

    def isPythagorean(triplet: Triplet): Boolean = {
        val (a, b, c) = triplet
        val list = List(a, b, c).sorted
        list match {
            case List(a, b, c) => a * a + b * b == c * c
        }
    }

    def pythagoreanTriplets(min: Int, max: Int): Seq[Triplet] = {
        
        // determine a value of r that I'm pretty sure will include all triples in the given bounds
        val minR = min - 1 // r must be this large for the smallest number in the triplet to include values up to min
        val maxR = (Math.sqrt(2 * max - 1) - 1).toInt + 1 // r must be this large for the largest number in the triplet to include values up to max
        // the maxR expression is the result of solving `max == r^2 / 2 + r + 1` for r, then rounding up to the nearest int

        // make sure both constraints are satisfied
        val r = Math.max(minR, maxR)

        val triplets = (2 to r by 2).map(dickson).flatten // probably way more triplets than are needed
        triplets
            .filter(triplet => { // filter to triplets that are in our bounds
                val (a, _, c) = triplet
                min <= a && c <= max
            })
            .sortBy(_._1) // sort the triplets because the unit tests require it

        // that's numberwang!
    }

    // https://en.wikipedia.org/wiki/Formulas_for_generating_Pythagorean_triples#Dickson's_method
    def dickson(r: Int) = {
        factor((r * r) / 2)
            .map(factors => {
                val (s, t) = factors
                val x = r + s
                val y = r + t
                val z = r + s + t
                (x, y, z)
            })
            .filter(isPythagorean)
    }

    // find factor-pair of a number
    def factor(n: Int): Seq[(Int, Int)] = {
        (1 to Math.sqrt(n).toInt).filter(x => n % x == 0).map(x => (x, n / x))
    }
}
