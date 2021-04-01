package pl.akolata.s13803.nbd.nbd01

object Nbd0109 {

  def main(args: Array[String]): Unit = {
    val numbers = List(0, 1, 2, 3, 0, 5)
    println(numbers)
    println(mapListIncrementValues(numbers))
  }

  def mapListIncrementValues(originalList: List[Int]): List[Int] = {
    originalList.map(i => i + 1)
  }

}
