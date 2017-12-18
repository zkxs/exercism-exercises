import Bearing._

case class Robot(bearing: Bearing, coordinate: Coordinate) {
    def coordinates = (coordinate.x, coordinate.y)
    def turnLeft: Robot = Robot(bearing.left, coordinate)
    def turnRight: Robot = Robot(bearing.right, coordinate)
    def advance: Robot = Robot(bearing, coordinate + bearing.transform)
    def simulate(commands: String): Robot = simulate(commands.toList)
    def simulate(commands: List[Char]): Robot = {
        commands.foldLeft(this)((robot, char) => robot.charToCommand(char).apply)
    }

    def charToCommand(char: Char): () => Robot = {
        char match {
            case 'L' => turnLeft _
            case 'R' => turnRight _
            case 'A' => advance _
        }
    }
}

// shim to convert coordinate tuples to the actual parameters I use
object Robot {
    def apply(bearing: Bearing, coordinate: (Int, Int)): Robot = {
        Robot(bearing, Coordinate(coordinate._1, coordinate._2))
    }
}
