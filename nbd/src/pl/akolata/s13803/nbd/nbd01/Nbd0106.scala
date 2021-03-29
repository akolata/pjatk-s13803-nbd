package pl.akolata.s13803.nbd.nbd01

object Nbd0106 {

  def main(args: Array[String]): Unit = {
    printTuple(("Test", 1, 1.0f))
  }

  def printTuple(tuple: (String, Int, Float)): Unit = {
    println(tuple)
  }

}
