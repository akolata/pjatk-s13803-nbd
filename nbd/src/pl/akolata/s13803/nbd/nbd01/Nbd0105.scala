package pl.akolata.s13803.nbd.nbd01

object Nbd0105 {
  def main(args: Array[String]): Unit = {
    val productsPricesMap = Map[String, BigDecimal](
      "MacBook Pro" -> 10_000,
      "iPhone" -> 5_000,
      "Logitech Mx 2s" -> 300
    )
    println(productsPricesMap)

    val productsReducedPricesMap: Map[String, BigDecimal] = productsPricesMap.mapValues(price => price * 0.9).toMap
    println(productsReducedPricesMap)
  }
}
