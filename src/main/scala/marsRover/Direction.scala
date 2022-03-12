package marsRover

class Direction(directionVar: Char)
{
//    N
//    O=E
//    S
//    W
  var direction:Char=directionVar

  def turnLeft(): Unit =
  {
    rotate("left")
  }

  def turnRight(): Unit =
  {
    rotate("right")
  }

  def currentStatus(): Char =
  {
    direction
  }

  def rotate(leftOrRight:String): Unit =
  {
    val directionsArrayRight=Iterator('N','E','S','W','N')
    val directionsArrayLeft=Iterator('N','W','S','E','N')
    if ("left" == leftOrRight)
    {
      while (directionsArrayLeft.hasNext && (direction != directionsArrayLeft.next())  )
      {
        //check for current direction
      }
      if (directionsArrayLeft.hasNext)
      {
        direction=directionsArrayLeft.next()
      }
    }
    if ("right" == leftOrRight)
    {
      while (directionsArrayRight.hasNext && (direction != directionsArrayRight.next())  )
      {
        //check for current direction
      }
      if (directionsArrayRight.hasNext)
      {
        direction=directionsArrayRight.next()
      }
    }
  }
}
