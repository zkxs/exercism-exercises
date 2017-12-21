import org.scalatest.{FunSuite, Matchers}

/** @version created manually **/
class ProteinTranslationTest extends FunSuite with Matchers {
  test("Identifies methionine codon") {
    ProteinTranslation.translate("AUG") should be(Seq("Methionine"))
  }

  test("Identifies phenylalanine codons") {
    ProteinTranslation.translate("UUU") should be(Seq("Phenylalanine"))
    ProteinTranslation.translate("UUC") should be(Seq("Phenylalanine"))
  }

  test("Identifies leucine codons") {
    ProteinTranslation.translate("UUA") should be(Seq("Leucine"))
    ProteinTranslation.translate("UUG") should be(Seq("Leucine"))
  }

  test("Identifies serine codons") {
    ProteinTranslation.translate("UCU") should be(Seq("Serine"))
    ProteinTranslation.translate("UCC") should be(Seq("Serine"))
    ProteinTranslation.translate("UCA") should be(Seq("Serine"))
    ProteinTranslation.translate("UCG") should be(Seq("Serine"))
  }

  test("Identifies tyrosine codons") {
    ProteinTranslation.translate("UAU") should be(Seq("Tyrosine"))
    ProteinTranslation.translate("UAC") should be(Seq("Tyrosine"))
  }

  test("Identifies cysteine codons") {
    ProteinTranslation.translate("UGU") should be(Seq("Cysteine"))
    ProteinTranslation.translate("UGC") should be(Seq("Cysteine"))
  }

  test("Identifies tryptophan codons") {
    ProteinTranslation.translate("UGG") should be(Seq("Tryptophan"))
  }

  test("Translate RNA strand into correct protein") {
    ProteinTranslation.translate("AUGUUUUGG") should be(Seq("Methionine", "Phenylalanine", "Tryptophan"))
  }

  test("Stops translation if stop codon is present") {
    ProteinTranslation.translate("AUGUUUUAA") should be(Seq("Methionine", "Phenylalanine"))
  }

  test("Stops translation of longest strand") {
    ProteinTranslation.translate("UGGUGUUAUUAAUGGUUU") should be(Seq("Tryptophan", "Cysteine", "Tyrosine"))
  }
}
