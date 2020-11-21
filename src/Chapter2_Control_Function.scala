import scala.math._

object Chapter2_Control_Function {
  def abs(x:Double) = if (x >= 0) x else -x

  def fun1(n:Int) = {
    var r = 1
    for (i <- 1 to n) {
      r = r * i
    }
    r //最后返回r的值
  }
  def fac(n:Int):Int = if ( n<= 0) 1 else n * fac(n-1) //递归函数必须指定返回类型

  def decorate(string: String, left: String = "[", right: String = "]") = left + string + right
  def decorate2(left: String = "[", string: String, right: String = "]") = {
    left + string + right
  } // 未命名参数在前面

  def sum(args:Int*) = {
    var result = 0
    for (arg <- args)
      result += arg
    result
  }
  def resursiveSum(args:Int*):Int = {
    if (args.isEmpty) 0
    else args.head + resursiveSum(args.tail:_*)
  }

  def printHello()  {
    println("hello")
  }

  def main(args: Array[String]): Unit = {
    // if/else有返回值，混合类型表达式返回公共超类型，如Any、Unit(void表示没有值，Unit表示无值的值)
    val s1 = if (10 > 1) 1 else -1
    println(s1)
    val s2 = if (10 > 1) 1 else "111"
    println(s2.getClass)
    val s3 = if (10 < 1) 1
    println(s3.getClass)

    // 语句终止，分号可同Java
    val n: Int = 10
    if (n > 0) {
      println(n);println(n) // 单行多句，用分号隔开
      var x = 1 + 3 +
      2
      println(x) // 长语句分行，以一个不能用作语句结尾的符号结尾
    }

    // 块表达式和赋值，取最后一个表达式的值
    val x: Double= 1; val x0: Double= 4; val y: Double= 1; val y0: Double= 6
    val distance = {
      val dx = x - x0; val dy = y - y0
      sqrt(pow(dx, 2) + pow(dy, 2))
    }
    println(distance)
    var r: Int = 1; var t: Int = 2
    println({r += 1; t = r}) // 块中最后一个是赋值语句，块结果为()，即Unit

    //输入输出
    printf("hello,%s! I am %d years old!\n", "hh", 2)
    val line = scala.io.StdIn.readLine()
    println(line)
    val int = scala.io.StdIn.readInt()
    println(int)

    // 循环，没有for(;;)
    var loop: Int= 5
    while(loop > 0){
      println("hello")
      loop -= 1
    }
    for (i <- 1 to 10){ // [1,10]
      print(i)
    }
    for (i <- 1 until 10){ // [1,10)
      print(i)
    }
    for (i <- "hello"){
      print(i)
    }
    println()

    // 高级for循环 for推导式
    for (i <- 1 to 3; j <- 10 to 30 if j % 10 ==0) {
      print(i*j+"\n")
    }
    for (i <- 1 to 3; from = 4 - i; j <- from to 3){
      printf("%d * %d = %d\n",i, j, i*j)
    }
    val vec = for (i <- 1 to 10) yield i % 3
    println(vec)
    println(for (c <- "hello"; i <- 1 to 1) yield (c + i).toChar) // 推导式和第一个生成器类型兼容
    println(for (c <- 1 to 1; i <- "hello") yield (c + i).toChar)

    // 函数
    println(abs(1.22))

    // 默认参数和带名参数
    println(decorate("123"))
    println(decorate("123", right = "}"))

    // 变长参数
    val s = sum(1,3,4,5,6,7,10) //类型是Seq
    println(s)
    // sum(1 to 8)
    sum(1 to 8:_*)
    println(resursiveSum(1,2,3,4,5))

    // 过程，没有返回值的函数，可略去括号，建议写
    printHello()

    // 懒值，首次使用时取值，用处：验证循环依赖
    lazy val word = scala.io.Source.fromFile("./1.txt")

    // 异常
    val w = 10
    val ty = if (w >= 0) sqrt(w) else throw new IllegalArgumentException("< 0 !")
    println(ty)

    try {
      if (w >= 0)  throw new IllegalArgumentException("> 0 !")
    } catch {
      case ex:IllegalArgumentException => printHello()
      case _:Throwable => println("Throwable")
    } finally {
      println("finally")
    }
  }
}
