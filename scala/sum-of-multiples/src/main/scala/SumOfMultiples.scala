object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    factors
      .map(factor => factor until limit by factor)
      .flatten
      .sum
  }
}

