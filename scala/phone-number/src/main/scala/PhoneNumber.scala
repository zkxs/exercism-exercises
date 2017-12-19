object PhoneNumber {

  val validCharacters = '0' to '9'
  val validStrictNumbers = '2' to '9'

  def clean(uncleanNumber: String): Option[String] = {
    val cleanedNumber = uncleanNumber.filter(validCharacters.contains(_))
    // might still have invalid length/digits

    if (cleanedNumber.length > 11) {
      None
    } else if (cleanedNumber.length == 11) {
      if (cleanedNumber.head == '1') {
        verifyAreaCode(cleanedNumber.tail)
      } else {
        None
      }
    } else if (cleanedNumber.length == 10) {
      verifyAreaCode(cleanedNumber)
    } else {
      None
    }
  }

  // verify area code and also the exchange code
  def verifyAreaCode(number: String): Option[String] = {
    if (validStrictNumbers.contains(number(0)) && validStrictNumbers.contains(number(3))) {
      Some(number)
    } else {
      None
    }
  }
}
