import scala.io.StdIn
import java.io._
import java.util.StringTokenizer

object Main extends App {
  val in = new InputReader(System.in)
  val H = in.next().toInt
  val W = in.next().toInt
  val n = in.next().toInt
  val s = new Array[String](n)

  var player = new Player(W, H)

  for (i <- 0 until n) {
    s(i) = in.next()
    player.changeState(s(i))
    player.printState()
  }
}

class Player(W: Int, H: Int) {
  var x: Int = 1
  var y: Int = 1

  var direction: Direction = Right

  def changeState(command: String) {
    command match {
      case "F" => forword()
      case "B" => back()
      case "L" => left()
      case "R" => right()
      case "TL" => turnLeft()
      case "TR" => turnRight()
    }
  }

  def forword(): Unit = {
    direction match {
      case Top => if(canMove(x, y - 1)) y = y - 1
      case Down => if(canMove(x, y + 1)) y = y + 1
      case Left => if(canMove(x - 1, y)) x = x - 1
      case Right => if(canMove(x + 1, y)) x = x + 1
    }
  }

  def back(): Unit = {
    direction match {
      case Top => if(canMove(x, y + 1)) y = y + 1
      case Down => if(canMove(x, y - 1)) y = y - 1
      case Left => if(canMove(x + 1, y)) x = x + 1
      case Right => if(canMove(x - 1, y)) x = x - 1
    }
  }

  def left(): Unit = {
    direction match {
      case Top => if(canMove(x - 1, y)) x = x - 1
      case Down => if(canMove(x + 1, y)) x = x + 1
      case Left => if(canMove(x, y + 1)) y = y + 1
      case Right => if(canMove(x, y - 1)) y = y - 1
    }
  }

  def right(): Unit = {
    direction match {
      case Top => if(canMove(x + 1, y)) x = x + 1
      case Down => if(canMove(x - 1, y)) x = x - 1
      case Left => if(canMove(x, y - 1)) y = y - 1
      case Right => if(canMove(x, y + 1)) y = y + 1
    }
  }

  def turnLeft() = {
    direction = direction match {
      case Top => Left
      case Down => Right
      case Left => Down
      case Right => Top
    }
  }

  def turnRight(): Unit = {
    direction = direction match {
      case Top => Right
      case Down => Left
      case Left => Top
      case Right => Down
    }
  }

  def canMove(x: Int, y: Int): Boolean = {
    if (1 <= x && x <= H && 1 <= y && y <= H) {
      true
    } else {
      false
    }
  }

  def printState(): Unit = {
    val pw = new PrintWriter(System.out)
    pw.println(s"$x $y")
    pw.flush()
  }
}

sealed trait Direction
case object Top extends Direction
case object Down extends Direction
case object Left extends Direction
case object Right extends Direction

class InputReader(stream: InputStream) {
  private val reader = new BufferedReader(new InputStreamReader(stream))
  private var tokenizer: StringTokenizer = new StringTokenizer(reader.readLine())
  def next(): String = {
    while (!tokenizer.hasMoreTokens()) {
      tokenizer = new StringTokenizer(reader.readLine())
    }
    tokenizer.nextToken()
  }
}
