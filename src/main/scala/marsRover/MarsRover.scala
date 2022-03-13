package marsRover

class MarsRover(coordinatesPar: Coordinates, directionPar: Direction)
{
  var coordinates:Coordinates =coordinatesPar;
  var direction:Direction =directionPar;

  def turnLeft(): Unit =
  {
    direction.turnLeft()
  }

  def turnRight(): Unit =
  {
    direction.turnRight()
  }

  def moveNorth(): Unit =
  {
    coordinates.moveNorth()
  }

  def moveEast(): Unit =
  {
    coordinates.moveEast()
  }

  def moveSouth(): Unit =
  {
    coordinates.moveSouth()
  }

  def moveWest(): Unit =
  {
    coordinates.moveWest()
  }

  def currentStatus():String=
  {
    coordinates.currentStatus() + ',' + direction.currentStatus()
  }

  def printCurrentStatus()=
  {
    println(coordinates.currentStatusBlankSeperator() + ' ' + direction.currentStatus())
  }
  
  def setObstacle(x:Int, y:Int): Unit =
  {
    coordinates.setObstacle(x,y)
  }

  def moveTo(directionString:String)=
  {
    directionString.foreach(command =>
    {
      if ('R' == command)
      {
        direction.turnRight()
      }
      else if ('L' == command)
      {
        direction.turnLeft()
      }
      else if ('M' == command)
      {
        if ('N' == direction.currentStatus())
        {
          coordinates.moveNorth()
        }
        else if ('W' == direction.currentStatus())
        {
          coordinates.moveWest()
        }
        else if ('E' == direction.currentStatus())
        {
          coordinates.moveEast()
        }
        else if ('S' == direction.currentStatus())
        {
          coordinates.moveSouth()
        }
      }
    })
  }
}
