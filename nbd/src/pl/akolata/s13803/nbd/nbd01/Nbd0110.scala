package pl.akolata.s13803.nbd.nbd01

object Nbd0110 {

  def main(args: Array[String]): Unit = {
    val originalList: List[Double] = List(-8, -6, -5.1, -5, -4.99, -4, -2, 0, 2, 4, 6, 8, 10, 11.99, 12, 12.001, 13, 14, 16)
    println(originalList)

    val filteredList = mapToAbsoluteValuesInRange(originalList)
    println(filteredList)
  }

  def mapToAbsoluteValuesInRange(list: List[Double]): List[Double] = {
    list
      .filter(elem => elem >= -5)
      .filter(elem => elem <= 12)
      .map(elem => elem.abs)
  }
}
