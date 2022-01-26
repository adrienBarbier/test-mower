import scala.io.Source
import scala.util.Try

@main def start(): Unit =

  val currentDirectory = new java.io.File(".").getCanonicalPath
  val fileName = currentDirectory + "/src/main/resources/input.txt"

  val (lawn, listOfMowersAndInstructions) = MowerTextParser.readDataFromFile(fileName)

  val mowersAtLatestPositions = TheFamousAutoMowerProgram.run(lawn,listOfMowersAndInstructions)
  
  println("=" * 10)
  mowersAtLatestPositions.foreach(println)
  println("=" * 10)






