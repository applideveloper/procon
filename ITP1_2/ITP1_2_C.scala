import scala.io.StdIn

object ITP1_2_C extends App {
  val sortedArray = StdIn.readLine().split(" ").map(_.toInt).sorted
  println(sortedArray.mkString(" "))
}