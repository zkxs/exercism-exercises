object ProteinTranslation {

  private val map: Map[String, Symbol] = Map(
    'Methionine -> Seq("AUG"),
    'Phenylalanine -> Seq("UUU", "UUC"),
    'Leucine -> Seq("UUA", "UUG"),
    'Serine -> Seq("UCU", "UCC", "UCA", "UCG"),
    'Tyrosine -> Seq("UAU", "UAC"),
    'Cysteine -> Seq("UGU", "UGC"),
    'Tryptophan -> Seq("UGG"),
    'STOP -> Seq("UAA", "UAG", "UGA")
  ).flatMap(t => t._2.map((_, t._1)))

  def translate(rnaSeq: String): Seq[String] = rnaSeq.grouped(3).map(map.apply).takeWhile(_ != 'STOP).map(_.name).toSeq
}
