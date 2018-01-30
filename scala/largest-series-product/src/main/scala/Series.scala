object Series {
    def largestProduct(windowLength: Int, digits: String): Option[Int] = {
        if (windowLength > digits.length || windowLength < 0) {
            None
        } else if (windowLength == 0) {
            Some(1) // I do not know why the unit tests think this program should have this behavior.
        } else {
            try {
                Some(
                    digits
                        .sliding(windowLength) // sliding window along digits
                        .map(_.map(_.toString.toInt).product) // find product of digits
                        .max // find the max product
                )
            } catch {
                case _: NumberFormatException => None
            }
        }
    }
}
