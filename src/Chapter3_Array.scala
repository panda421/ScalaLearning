import scala.collection.mutable.ArrayBuffer

object Chapter3_Array {

  def main(args: Array[String]): Unit = {

    // 定长数组
    val nums = new Array[Int](10)
    val s = Array("hello", "world")
    println(s.mkString(","))
    println(s.mkString("<",",",">"))
    println(s.apply(0))
    s(0) = "haha"
    println(s(0))

    // 变长数组
    val b = ArrayBuffer[Int]()
    b += 1
    println(b)
    b += (2,3,4)
    println(b)
    b ++= Array(1,2,3)
    println(b)
    b.trimEnd(5)
    println(b)
    b.insert(2,6)
    println(b)
    b.insert(2,7,8,9) // 第一个是位置，后面是值
    println(b)
    b.remove(2,2) //第一个是位置，后面是个数
    println(b)
    b.toArray

    // 遍历数组和数组缓冲
    for (i <- b) print(i)
    for (i <- 0 until b.length) print(b(i))
    println()
    for (i <- 0 until (b.length, 2)) print(b(i)) // 每两个元素跳一下
    println()
    for (i <- (0 until b.length ).reverse) print(b(i))
    println()

    val c = b.filter(_%2==0).map(2*_)
    println(c)
    val d = b.filter{_%2==0}.map(2*_)
    println(d)

    // 常用算法
    val x = ArrayBuffer(1,8,3,9,6)
    val y = x.sum
    println(y)

    // 多维数组
    val matrix = Array.ofDim[Int](3,4)

  }
}
