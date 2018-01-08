import java.time.{DayOfWeek, LocalDate, YearMonth}

import Schedule.Schedule

case class Meetup(month: Int, year: Int) {
  val yearMonth = YearMonth.of(year, month)

  def day(dayIndex: Int, schedule: Schedule): LocalDate = {
    val dayOfWeek = DayOfWeek.of(dayIndex)

    def findDayInRange(range: Range): LocalDate = {
      range.map(yearMonth.atDay).find(_.getDayOfWeek == dayOfWeek).get
    }

    def findDayInMonth(index: Int): LocalDate = {
      val lastDay = yearMonth.atEndOfMonth.getDayOfMonth
      (1 to lastDay).map(yearMonth.atDay).filter(_.getDayOfWeek == dayOfWeek)(index) // filter entire month to day of week, then take index
    }

    schedule match {
      case Schedule.Teenth => findDayInRange(13 to 19)
      case Schedule.First => findDayInRange(1 to 7)
      case Schedule.Second => findDayInMonth(1)
      case Schedule.Third  => findDayInMonth(2)
      case Schedule.Fourth => findDayInMonth(3)
      case Schedule.Last => {
        val last = yearMonth.atEndOfMonth
        val first = last.minusDays(6)
        findDayInRange(first.getDayOfMonth to last.getDayOfMonth)
      }
    }
  }
}

object Schedule extends Enumeration {
  type Schedule = Value
  val Teenth, First, Second, Third, Fourth, Last = Value
}

object Meetup {
  val Mon = DayOfWeek.MONDAY.getValue
  val Tue = DayOfWeek.TUESDAY.getValue
  val Wed = DayOfWeek.WEDNESDAY.getValue
  val Thu = DayOfWeek.THURSDAY.getValue
  val Fri = DayOfWeek.FRIDAY.getValue
  val Sat = DayOfWeek.SATURDAY.getValue
  val Sun = DayOfWeek.SUNDAY.getValue
}
