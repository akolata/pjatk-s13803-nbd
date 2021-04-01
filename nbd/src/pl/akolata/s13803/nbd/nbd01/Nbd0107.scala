package pl.akolata.s13803.nbd.nbd01

object Nbd0107 {

  def main(args: Array[String]): Unit = {
    val productsPricesMap = Map[String, BigDecimal](
      "MacBook Pro" -> 10_000
    )

    val maybeMacBookPro: Option[BigDecimal] = productsPricesMap.get("MacBook Pro")
    println(maybeMacBookPro)
    println(maybeMacBookPro.isDefined)
    println(maybeMacBookPro.get)

    val maybeDecimal: Option[BigDecimal] = productsPricesMap.get("Microsoft Surface")
    println(maybeDecimal)
    println(maybeDecimal.isDefined)
    println(maybeDecimal.getOrElse(0))
  }

}
