import scala.io.StdIn

object ITP1_1_D extends App {
  val S = StdIn.readLine().toInt
  val h = S / 3600
  val m = (S - 3600 * h)/60
  val s = (S - 3600 * h - 60 * m)
  println(s"$h:$m:$s")
}