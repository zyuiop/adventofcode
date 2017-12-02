import scala.io.Source

/**
  * @author zyuiop
  */
object day2 {
  val input: Iterable[Iterable[String]] = Source.fromFile("day2.txt").getLines.toIterable.map(_.split("\t").toIterable)

  lazy val intList: Iterable[Iterable[Int]] = input.map(_.map(_.toInt))

  lazy val checkSum: Int = intList.foldLeft(0)((acc, list) => acc + list.max - list.min)

  def main(args: Array[String]) = {
    println(checkSum)
  }
}
