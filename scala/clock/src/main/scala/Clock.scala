class Clock(val hours: Int, val minutes: Int) {
  def +(o: Clock): Clock = Clock.fix((hours + o.hours) * 60 + (minutes + o.minutes))
  def -(o: Clock): Clock = Clock.fix((hours - o.hours) * 60 + (minutes - o.minutes))
  override def toString: String = s"Clock($hours, $minutes)"

  def canEqual(other: Any): Boolean = other.isInstanceOf[Clock]

  override def equals(other: Any): Boolean = other match {
    case that: Clock =>
      (that canEqual this) &&
        hours == that.hours &&
        minutes == that.minutes
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(hours, minutes)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

// make hours optional with a default of 0
object Clock {
  def apply(hours: Int, minutes:Int): Clock = fix(hours * 60 + minutes)
  def apply(minutes:Int): Clock = fix(minutes)

  private def fix(m: Int):Clock = {
    val hours = Math.floorMod(Math.floorDiv(m, 60), 24)
    val minutes = Math.floorMod(m, 60)
    new Clock(hours, minutes)
  }
}
