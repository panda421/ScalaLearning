import scala.beans.BeanProperty
import scala.collection.mutable.ArrayBuffer

class Counter {
  private var value = 0

  def increment(): Unit = {
    value += 1
  }

  def current() = {
    value
  }

  def current2 = value // 通过不带括号的声明强制调用不使用括号
}

class Person {
  var age = 0
}

class Person2 {
  private var privateAge = 0

  def age = privateAge

  def age_=(newAge: Int): Unit = {
    if (privateAge < newAge) privateAge = newAge
  }
}

class Message {
  private var time = new java.util.Date

  def getTime = time // private变量，自定义getter函数
}

class Counter3 {
  private var value = 0

  // private[this] var value = 0 // 如private[this]只能访问当前对象的变量，不可以other.value
  def increment() = {
    value += 1
  }

  def idLess(other: Counter3): Unit = {
    value < other.value
  }
}

class Person3 {
  @BeanProperty
  var name: String = _ // JavaBean注解
}

class Person4 {
  @BeanProperty var name = ""
  @BeanProperty var age = 0

  // 辅助构造器
  def this(name: String) = {
    this()
    this.name = name
  }

  def this(name: String, age: Int) = {
    this()
    this.name = name
    this.age = age
  }
}

class Person5(val name: String, val age: Int) { // 主构造器的参数直接放在类名之后
  println("Person5") // 主构造器会执行类中的所有语句
}

class Person6 private(var name: String, var age: Int) { // 主构造器成为私有必须通过辅助构造器构造
  println("Person6")

  def this(name: String, age: Int) = {
    this(name, age)
  }
}

class Network {
  class Member(val name:String) { //每个Network中的Member不一样
    val contacts = new ArrayBuffer[Member]()
    // val contacts = new ArrayBuffer[Network#Member]() // 投影类型任何
  }
  private val members = new ArrayBuffer[Member]()

  def join(name:String) = {
    val m = new Member(name:String)
    members += m
    m
  }
}

object Chapter5_Class {

  def main(args: Array[String]): Unit = {
    val myCounter = new Counter()
    myCounter.increment()
    myCounter.increment
    println(myCounter.current())
    println(myCounter.current) // 调用无参方法可不写括号

    val person = new Person()
    person.age_=(1) // age.getter: age, age.setter: age_=()
    println(person.age)
    person.age = 2
    println(person.age)

    val fred = new Person2
    fred.age_=(10)
    fred.age = 9
    println(fred.age) // 仍是10
    fred.age_=(1)
    println(fred.age) // 仍是10

    // 只带getter的属性,只读
    val message = new Message
    println(message.getTime)

    val person4 = new Person4("tom", 1)
    println(person4.name)
    person4.setName("bill")
    println(person4.getName)

    val person5 = new Person5("word", 100)
    val person6 = new Person6("scala", 999)

    val chatter = new Network
    val myFace = new Network
    val tom = chatter.join("tom")
    val will = chatter.join("will")
    tom.contacts += will
    // val bill = myFace.join("bill")
    // tom.contacts += bill 不可以

  }
}
