import java.util

import scala.collection.mutable

object Chapter4_Map {
  def main(args: Array[String]): Unit = {
    // 不可变
    val score1 = Map("A" -> 10, "B" -> 0)
    // 可变
    val score2 = scala.collection.mutable.Map("A" -> 10, "B" -> 0)
    // 空
    val score3 = new scala.collection.mutable.HashMap[String, Int]
    score2+=(("h", 3))
    score2+=("a" -> 4)
    println(score2.mkString("|"))
    // 获取值
    val A = score2.get("A")
    println(A)
    val C = score2.getOrElse("C", -1)
    println(C)
    // 更新
    score2("A") = 6
    score2 += (("B", 12), ("C", 999))
    println(score2.mkString("|"))
    score2 -= "A"
    println(score2.mkString("|"))
    // 利用不可变map中的值
    val newScore = score1 + (("A", 100))
    println(newScore.mkString("|"))
    // 迭代
    val score2Rev = for ((key, value) <- score2) yield (value, key)
    println(score2Rev.mkString("|"))
    for (i <- score2.keySet) {
      println(score2(i))
    }
    // 元组
    val t = ("tom", 3.14, 6)
    println(t._2)
    println(t _2)
    val (first, second, third) = t
    println(first)
    val (one, two, _) = t // 不需要的位置上用_
    println(one)
    // zip
    val symbols = Array("<","_",">")
    val counts= Array(2,10,2)
    val pairs = symbols.zip(counts)
    println(pairs.mkString(","))
    for ((s,n)<-pairs) Console.print(s*n)

  }
}
