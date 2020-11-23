object Chapter6_Object {
  // Object的构造器在第一次使用时调用，如从未使用构造器不会执行
  // 不能提供构造器参数
  // 用处：单例，共享不可变变量，存放工具函数

  // 伴生对象
  // 适用既有实例方法，又有静态方法的类
  // 它们必须存在于同一个源文件中
  object Accounts {
    private var lastNumber = 0
    def newUniqueNumber() = {
      lastNumber += 1
      lastNumber
    }
  }
  class Accounts {
    val id = Accounts.newUniqueNumber()
    private var balance:Double = 0
    def deposit(amount:Double) = {
      balance += amount
    }
  }

  // 拓展类或特质的对象
  abstract class UndoableAction(val description: String) {
    def undo(): Unit
    def redo(): Unit
  }
  object DoNothingAction extends UndoableAction("Do nothing") {
    override def undo(): Unit = {}

    override def redo(): Unit = {}
  }

  class Account private (val id: Int, initialBalance: Double) {
    private var balance = initialBalance
  }
  object Account {
    var balance = 0
    def newUniqueNumber() = {
      balance += 1
      balance
    }
    def apply (initialBalance: Double) = new Account(newUniqueNumber(), initialBalance)
  }

  // 枚举
  object TrafficLightColor extends Enumeration {
    val Red = Value(-1)
    val Yellow = Value(0)
    val Green = Value(1)
  }

  object LightColor extends Enumeration {
    type LightColor = Value
    val Red = Value(-1)
    val Yellow = Value(0)
    val Green = Value(1)
  }

  def main(args: Array[String]): Unit = {
    val actions = Map("open" -> DoNothingAction, "save" -> DoNothingAction)

    // apply方法
    // Object(p1,p2,...)调用apply方法
    Array(100) // apply方法，一个单元素的Array[Int]
    new Array(100) // 构造器，Array[Nothing]，100个null
    Account(100)

    println(TrafficLightColor.Green)
    println(TrafficLightColor.Green.getClass)
    println(TrafficLightColor.Green.id) // 返回ID
    println(TrafficLightColor.Green.toString) // 返回名称

    println(TrafficLightColor(0)) // apply
    println(TrafficLightColor.withName("Yellow"))
  }
}
