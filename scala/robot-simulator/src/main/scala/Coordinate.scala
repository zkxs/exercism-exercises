case class Coordinate(x: Int, y: Int) {
    def +(o: Coordinate): Coordinate = {
        Coordinate(x + o.x, y + o.y)
    }
}
