object Leap {
  def leapYear(year: Int): Boolean = {
    if (year % 4 == 0) {
      if (year % 100 == 0) {
        if (year % 400 == 0) {
          true // divisible by 400
        } else {
          false // divisible by 100
        }
      } else {
        true // divisible by 4
      }
    } else {
      false // not divisible by 4
    }
  }
}
