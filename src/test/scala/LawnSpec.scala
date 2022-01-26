import org.scalatest.*
import flatspec._
import matchers.should._

class LawnSpec extends AnyFlatSpec with Matchers {

  val lawn: Lawn = Lawn(10, 10)
  import CardinalPoints.*
  import Instructions.*

    "The Position" should "be off the boundaries when x < 0" in {
      lawn.isWithinBoundaries(Position(-1,3)) should be(false)
    }

  "The Position" should "be off the boundaries when y < 0" in {
    lawn.isWithinBoundaries(Position(3,-5)) should be(false)
  }

  "The Position" should "be off the boundaries when x > lawn's x" in {
    lawn.isWithinBoundaries(Position(11,3)) should be(false)
  }

  "The Position" should "be off the boundaries when y > lawn's y" in {
    lawn.isWithinBoundaries(Position(3,11)) should be(false)
  }

  "The Position" should "be within the boundaries when x and y are at lawns limit" in {
    lawn.isWithinBoundaries(Position(10,10)) should be(true)
  }

  "The Position" should "be within the boundaries when x and y are at 0" in {
    lawn.isWithinBoundaries(Position(0,0)) should be(true)
  }

  "The Position" should "be within the boundaries when x and y are within 0 and lawn's dimension" in {
    lawn.isWithinBoundaries(Position(5,5)) should be(true)
  }

}
