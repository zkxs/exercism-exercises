object RnaTranscription {
  val map = Map(
    'G' -> 'C',
    'C' -> 'G',
    'T' -> 'A',
    'A' -> 'U'
  )

  def toRna(dna: String): Option[String] = {
    // using exceptions is an easy way to fail fast instead of inspecting
    // the output after the entire mapping is done
    try {
      Some(dna.map(map.apply))
    } catch {
      case e: NoSuchElementException => None
    }
  }
}
