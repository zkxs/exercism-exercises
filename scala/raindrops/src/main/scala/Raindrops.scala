import scala.collection.mutable.MutableList

// this reminds me of FizzBuzz... https://gist.github.com/zkxs/5265f9571d692291cf2e2f84302760f5
object Raindrops {

  sealed case class Test(val test: Int => Boolean, val flag: String)

  val tests = List(
    Test(_ % 3 == 0, "Pling"),
    Test(_ % 5 == 0, "Plang"),
    Test(_ % 7 == 0, "Plong")
  )

  def convert(n: Int): String = {

    val output = MutableList.empty[String]
    
    for (test <- tests) {
      if (test.test(n)) {
        output += test.flag
      }
    }
    
    if (output.isEmpty) { // if no conditions are met, just print the input
      n.toString
    } else {
      output.mkString
    }

  }

}

