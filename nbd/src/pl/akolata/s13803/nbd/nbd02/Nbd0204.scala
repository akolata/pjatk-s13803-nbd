package pl.akolata.s13803.nbd.nbd02

object Nbd0204 {

  def main(args: Array[String]): Unit = {
    println(functionAsArgumentExample(2, (i: Int) => i * 2))
  }

  def functionAsArgumentExample(value: Int, f: Int => Int): Int = {
    f(f(f(value)))
  }

}
