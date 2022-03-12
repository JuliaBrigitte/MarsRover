package marsRover

class Coordinates(xVar: Int, yVar: Int)
{
  var x:Int =xVar;
  var y:Int =yVar;

  val maxGrid=5

  def move(dx: Int, dy: Int): Unit =
  {
    x=x+dx;
    y=y+dy;
  }

  def currentStatus(): String =
  {
    var result=x.toString + "," + y.toString
    result
  }

  def moveNorth(): Unit =
  {
    if (maxGrid > y)
    {
      move(0,1)
    }
  }

  def moveEast(): Unit =
  {
    if (maxGrid > x)
    {
      move(1,0)
    }
  }

  def moveSouth(): Unit =
  {
    if (0 < y)
    {
      move(0,-1)
    }
  }

  def moveWest(): Unit =
  {
    if (0 < x)
    {
      move(-1,0)
    }
  }
}
