import scala.math._

object Chapter1_Base {
  def main(args: Array[String]): Unit = {
    println(1.toString)

    println(1.to(10))

    // 首先转成 RichDouble类
    println(10.toDouble)

    println(pow(10, 2))
    println(math.pow(10, 2))

    // apply,()的重载
    val s: String = "hello"
    println(s(4))
    println(s.apply(4))
    println(BigInt("111111"))
    println(BigInt.apply("111111"))


  }
}
