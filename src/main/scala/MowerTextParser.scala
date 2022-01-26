import scala.io.Source
import scala.util.Try

object MowerTextParser {
  def readDataFromFile(filename: String): (Lawn, MowersAndInstructions) = {
    val src = Source.fromFile(filename)
    val lines = src.getLines.toList
    val res = if (lines.length < 3) {
      (Lawn(0, 0), Seq.empty)
    } else {
      val firstLine = lines.head.split(" ")
      val xMax = firstLine.headOption.map(_.toInt).getOrElse(0)
      val yMax = firstLine.lift(1).map(_.toInt).getOrElse(0)

      val listOfMowerAndInstructions = lines
        .drop(1)
        .grouped(2)
        .toSeq
        .flatMap { d =>
          Try {
            val r = d.head.split(" ")
            val direction = CardinalPoints.valueOf(r(2).head.toString)
            val mowerPosition = Position(r(0).toInt, r(1).toInt)
            (Mower(direction, mowerPosition), d.last.toList.map( x => Instructions.valueOf(x.toString)))
          }.toOption
        }
      (Lawn(xMax,yMax), listOfMowerAndInstructions)
    }
    src.close()
    res
  }
}
