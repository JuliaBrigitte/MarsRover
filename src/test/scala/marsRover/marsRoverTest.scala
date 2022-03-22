package marsRover

import org.scalatest.flatspec.AnyFlatSpec

class marsRoverTest extends AnyFlatSpec
{
//    Test cases
//    single turns left and right and move to test turn and move
  var direction=new Direction('N')
  
  "Direction facing north" should "turn left to W then N then W" in
  {
    direction.turnLeft()
    assert(direction.currentStatus() == 'W')
    direction.turnRight()
    assert(direction.currentStatus() == 'N')
    direction.turnLeft()
    assert(direction.currentStatus() == 'W')
    direction.turnRight()
    assert(direction.currentStatus() == 'N')
  }
  "Direction facing north" should "turn left to W then S then E" in
  {
    direction.turnLeft()
    assert(direction.currentStatus() == 'W')
    direction.turnLeft()
    assert(direction.currentStatus() == 'S')
    direction.turnLeft()
    assert(direction.currentStatus() == 'E')
  }
  "Direction east" should "turn right to S then W then N" in
  {
    direction.turnRight()
    assert(direction.currentStatus() == 'S')
    direction.turnRight()
    assert(direction.currentStatus() == 'W')
    direction.turnRight()
    assert(direction.currentStatus() == 'N')
  }
  var coordinates=new Coordinates(1,1)

  "Move along the grid" should "move by one and stop at edges" in
  {
    coordinates.moveWest()
    assert(coordinates.currentStatus() == "0,1")
    coordinates.moveSouth()
    assert(coordinates.currentStatus() == "0,0")
    coordinates.moveSouth()
    assert(coordinates.currentStatus() == "0,0")
    coordinates.moveEast()
    assert(coordinates.currentStatus() == "1,0")
    coordinates.moveEast()
    assert(coordinates.currentStatus() == "2,0")
    coordinates.moveEast()
    assert(coordinates.currentStatus() == "3,0")
    coordinates.moveEast()
    assert(coordinates.currentStatus() == "4,0")
    coordinates.moveEast()
    assert(coordinates.currentStatus() == "5,0")
    coordinates.moveEast()
    assert(coordinates.currentStatus() == "5,0")
    coordinates.moveWest()
    assert(coordinates.currentStatus() == "4,0")
    coordinates.moveNorth()
    assert(coordinates.currentStatus() == "4,1")
    coordinates.moveNorth()
    assert(coordinates.currentStatus() == "4,2")
    coordinates.moveNorth()
    assert(coordinates.currentStatus() == "4,3")
    coordinates.moveNorth()
    assert(coordinates.currentStatus() == "4,4")
    coordinates.moveNorth()
    assert(coordinates.currentStatus() == "4,5")
    coordinates.moveNorth()
    assert(coordinates.currentStatus() == "4,5")

  }

  var coordinatesMarsRover=new Coordinates(2,3)
  var directionMarsRover=new Direction('N')
  var marsRover=new MarsRover(coordinatesMarsRover,directionMarsRover)

"Mars Rover facing north" should "turn left to W then S then E" in
{
  marsRover.turnLeft()
  assert(marsRover.currentStatus() == "2,3,W")
  marsRover.turnLeft()
  assert(marsRover.currentStatus() == "2,3,S")
  marsRover.turnLeft()
  assert(marsRover.currentStatus() == "2,3,E")
}
"Mars Rover facing east" should "turn left to S then W then N" in
{
  marsRover.turnRight()
  assert(marsRover.currentStatus() == "2,3,S")
  marsRover.turnRight()
  assert(marsRover.currentStatus() == "2,3,W")
  marsRover.turnRight()
  assert(marsRover.currentStatus() == "2,3,N")
  marsRover.turnRight()
  assert(marsRover.currentStatus() == "2,3,E")
}
  "Mars Rover facing east" should "walk to end of grid and not fall off" in
  {
    marsRover.moveTo("M")
    assert(marsRover.currentStatus() == "3,3,E")
    marsRover.moveTo("M")
    assert(marsRover.currentStatus() == "4,3,E")
    marsRover.moveTo("M")
    assert(marsRover.currentStatus() == "5,3,E")
    marsRover.moveTo("M")
    assert(marsRover.currentStatus() == "5,3,E")
  }

var coordinatesMarsRover1=new Coordinates(1,2)
var directionMarsRover1=new Direction('N')
var marsRover1=new MarsRover(coordinatesMarsRover1,directionMarsRover1)
"Original Test Case 12N" should "walk to 13N" in
{
  marsRover1.moveTo("LMLMLMLMM")
  assert(marsRover1.currentStatus() == "1,3,N")
}

var coordinatesMarsRover2=new Coordinates(3,3)
var directionMarsRover2=new Direction('E')
var marsRover2=new MarsRover(coordinatesMarsRover2,directionMarsRover2)
"Original Test Case 33E" should "walk to 51E" in
{
  marsRover2.moveTo("MMRMMRMRRM")
  assert(marsRover2.currentStatus() == "5,1,E")
}

// Test with Obstocle
var coordinatesMarsRover3=new Coordinates(0,0)
  var directionMarsRover3=new Direction('E')
  var marsRover3=new MarsRover(coordinatesMarsRover3,directionMarsRover3)
  marsRover3.setObstacle(1,0)
  "Obstacle at 1 0" should "stop rover at 0 0" in
  {
    marsRover3.moveTo("MMMMMM")
    assert(marsRover3.currentStatus() == "0,0,E")
  }
}
