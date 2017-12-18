class Matrix(string: String) {
    val rows: Vector[Vector[Int]] = {
        string.split("\n")
            .map(line => line.split("\\s+")
                .map(_.toInt)
                .toVector)
            .toVector
    }

    val cols = rows.transpose

    override def equals(o: Any): Boolean = {
        o match {
            case matrix: Matrix => rows == matrix.rows
            case _ => false
        }
    }
}

object Matrix {
    def apply(string: String): Matrix = new Matrix(string)
}