object Hamming {
    def distance(a: String, b: String): Option[Int] = {
        if (a.length != b.length) {
            None // Hamming distance is undefined for strings of unequal length
        } else {
            Some((a zip b).map(t => if (t._1 != t._2) 1 else 0).sum)
        }
    }
}
