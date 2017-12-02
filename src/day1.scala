import scala.io.StdIn

/**
  * @author zyuiop
  */
object day1 {
  def main(args: Array[String]) = {
    val input = StdIn.readLine("Enter captcha: ")
    println(calculateSum(adjustList(computeList(input))))
  }

  /**
    * Computes a list of digits from an input string
    * @param input the input string
    * @param acc the list accumulator
    * @return a list of digits built from the input string
    */
  def computeList(input: String, acc: List[Integer] = Nil): List[Integer] = {
    if (input.isEmpty) acc.reverse
    else computeList(input.tail, input.head.toString.toInt :: acc)
  }

  /**
    * Adds the first element at the end of the list, because the first element follows the last one
    * @param input the list
    * @return a new list where it's last element is the same as its first
    */
  def adjustList(input: List[Integer]): List[Integer] = {
    input :+ input.head
  }

  /**
    * Computes the sum as described in the problem
    * @param list the list of digits
    * @param acc the sum accumulator
    * @return the sum of digits that are followed by themselves
    */
  def calculateSum(list: List[Integer], acc: Integer = 0): Integer = list match {
    case head :: (next :: tail) =>
      println("[" + acc + "] " + head + " " + next + " ... " + tail)
      if (head == next) calculateSum(next :: tail, acc + head)
      else calculateSum(next :: tail, acc)
    case _ => acc
  }
}
