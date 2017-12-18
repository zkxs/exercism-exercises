// pass-by-name magic for left and right
sealed class Bearing(_left: => Bearing, _right: => Bearing, val transform: Coordinate, name: String) {
    lazy val left = _left
    lazy val right = _right
    override def toString: String = s"Bearing($name)"
}

object Bearing {
    // lazy magic to make an immutable ring
    lazy val North: Bearing = new Bearing(West,  East,  Coordinate( 0,  1), "North")
    lazy val East:  Bearing = new Bearing(North, South, Coordinate( 1,  0), "East")
    lazy val South: Bearing = new Bearing(East,  West,  Coordinate( 0, -1), "South")
    lazy val West:  Bearing = new Bearing(South, North, Coordinate(-1,  0), "West")
}
