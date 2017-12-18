import scala.annotation.tailrec

object CollatzConjecture {
    def steps(n: Int): Option[Int] = {
        // ensure n is a positive number
        if (n > 0) {
            collatz(n, 0)
        } else {
            None
        }
    }

    @tailrec
    def collatz(n: Int, steps: Int): Some[Int] = {
        if (n % 2 == 0) {
            // if n is even
            collatz(n / 2, steps + 1)
        } else if (n == 1) {
            return Some(steps)
        } else {
            collatz(3 * n + 1, steps + 1)
        }
    }
}
