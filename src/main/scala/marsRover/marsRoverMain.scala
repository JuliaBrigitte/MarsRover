package marsRover

object marsRoverMain
{
  def main(args: Array[String]): Unit = {
    var input=""
    while (!input.matches("[0-9]* [0-9]*"))
    {
      println("Please enter Grid values for x and y (e.g. 5 5)")
      input=scala.io.StdIn.readLine()
    }
    val Array(xGrid, yGrid) = input.split(" ").map(_.toInt)

    var inputRover1=""
    while (!inputRover1.matches("[0-9]* [0-9]* [NSEW]+"))
    {
      println("Please enter Coordinates for first rover (e.g. 1 2 N)")
      inputRover1=scala.io.StdIn.readLine()
    }
    val Array(coordX1, coordY1, direction1)=inputRover1.split(" ")

    var roverMovement1=""
    while (!roverMovement1.matches("[LRM]+"))
    {
      println("Please enter moving pattern for first rover (e.g. LMLMLMLMM)")
      roverMovement1=scala.io.StdIn.readLine()
    }

    var inputRover2=""
    while (!inputRover2.matches("[0-9]* [0-9]* [NSEW]+"))
    {
      println("Please enter Coordinates for second rover (e.g. 3 3 E)")
      inputRover2=scala.io.StdIn.readLine()
    }
    val Array(coordX2, coordY2, direction2)=inputRover2.split(" ")

    var roverMovement2=""
    while (!roverMovement2.matches("[RLM]+"))
    {
      println("Please enter moving pattern for second rover (e.g. MMRMMRMRRM)")
      roverMovement2=scala.io.StdIn.readLine()
    }
    println("---------------------------------")
    println("Result:")

    var coordinatesMarsRover1=new Coordinates(coordX1.toInt,coordY1.toInt)
    var directionMarsRover1=new Direction(direction1.charAt(0))
    var marsRover1=new MarsRover(coordinatesMarsRover1,directionMarsRover1)
    marsRover1.setObstacle(coordX2.toInt,coordY2.toInt)
    marsRover1.moveTo(roverMovement1)
    marsRover1.printCurrentStatus()

    var coordinatesMarsRover2=new Coordinates(coordX2.toInt,coordY2.toInt)
    var directionMarsRover2=new Direction(direction2.charAt(0))
    var marsRover2=new MarsRover(coordinatesMarsRover2,directionMarsRover2)
    marsRover1.setObstacle(coordX1.toInt,coordY1.toInt)
    marsRover2.moveTo(roverMovement2)
    marsRover2.printCurrentStatus()
  }
}
