package pl.akolata.s13803.nbd.nbd01

object Nbd0108 {

  def main(args: Array[String]): Unit = {
    val numbers = List(0, 1, 2, 3, 0, 5)
    val filtered = filterOutZerosFromList(numbers)
    println(filtered)
  }

  @scala.annotation.tailrec
  def filterOutZerosFromList(list: List[Int], accumulator: List[Int] = List[Int]()): List[Int] = list match {
    case Nil => accumulator.reverse
    case headElement :: tail if (headElement == 0) => filterOutZerosFromList(tail, accumulator)
    case headElement :: tail => filterOutZerosFromList(tail, headElement :: accumulator)
  }

}
