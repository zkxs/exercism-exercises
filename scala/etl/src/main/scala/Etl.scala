object Etl {
    def transform(legacy: Map[Int, Seq[String]]): Map[String, Int] = {
        legacy.toStream.flatMap(tupleize).toMap
    }

    def tupleize(tuple: (Int, Seq[String])): Iterable[(String, Int)] = {
        val (score, letters) = tuple
        for (letter <- letters) yield {
            (letter.toLowerCase, score)
        }
    }
}
