import org.scalatest.*
import flatspec._
import matchers.should._

class TheFamousAutoMowerProgramSpec extends AnyFlatSpec with Matchers{
  import CardinalPoints._
  import Instructions._
  "The example scenario" should "pass" in {
    val lawn = Lawn(5,5)
    val mowersAndInstructions = Seq(
      (Mower(N,Position(1,2)),Seq(L,F,L,F,L,F,L,F,F)),
      (Mower(E,Position(3,3)),Seq(F,F,R,F,F,R,F,R,R,F))
    )
    val res = TheFamousAutoMowerProgram.run(lawn, mowersAndInstructions)
    res should be(Seq(
      Mower(N,Position(1,3)),
      Mower(E,Position(5,1))
    ))
  }

}
