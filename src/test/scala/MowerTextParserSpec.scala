import org.scalatest.*
import flatspec._
import matchers.should._

class MowerTextParserSpec extends AnyFlatSpec with Matchers{
  import CardinalPoints.*
  import Instructions.*

  "The example input file" should "be well parsed" in {
    val currentDirectory = new java.io.File(".").getCanonicalPath
    val fileName = currentDirectory + "/src/main/resources/input.txt"
    val (lawnFromParser, mowersAndInstructionsFromParser) = MowerTextParser.readDataFromFile(fileName)

    lawnFromParser should be(Lawn(5,5))
    mowersAndInstructionsFromParser should be(Seq(
      (Mower(N,Position(1,2)),Seq(L,F,L,F,L,F,L,F,F)),
      (Mower(E,Position(3,3)),Seq(F,F,R,F,F,R,F,R,R,F))
    ))
  }

}
