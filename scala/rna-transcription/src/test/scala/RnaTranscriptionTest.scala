import org.scalatest.{Matchers, FunSuite}

/** @version 1.0.1 */
class RnaTranscriptionTest extends FunSuite with Matchers {
  
  test("RNA complement of cytosine is guanine") {
    RnaTranscription.toRna("C") should be (Some("G"))
  }

  test("RNA complement of guanine is cytosine") {
    RnaTranscription.toRna("G") should be (Some("C"))
  }

  test("RNA complement of thymine is adenine") {
    RnaTranscription.toRna("T") should be (Some("A"))
  }

  test("RNA complement of adenine is uracil") {
    RnaTranscription.toRna("A") should be (Some("U"))
  }

  test("RNA complement") {
    RnaTranscription.toRna("ACGTGGTCTTAA") should be (Some("UGCACCAGAAUU"))
  }

  test("correctly handles invalid input (RNA instead of DNA)") {
    RnaTranscription.toRna("U") should be (None)
  }

  test("correctly handles completely invalid DNA input") {
    RnaTranscription.toRna("XXX") should be (None)
  }

  test("correctly handles partially invalid DNA input") {
    RnaTranscription.toRna("ACGTXXXCTTAA") should be (None)
  }
}
