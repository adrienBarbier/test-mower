import org.scalatest._
import flatspec._
import matchers.should._

class MowerSpec extends AnyFlatSpec with Matchers {

  implicit val lawn: Lawn = Lawn(10, 10)
  import CardinalPoints._
  import Instructions._

  //test Instruction F on move method
    "The Mower" should "move +1 on Y axis when facing North and receiving a F instruction" in {
      val mower = Mower(N, Position(0, 0)).move(F)

      mower should equal(Mower(N, Position(0, 1)))
    }

    "The Mower" should "move -1 on Y axis when facing South and receiving a F instruction" in {
      val mower = Mower(S, Position(2, 5)).move(F)

      mower should equal(Mower(S, Position(2, 4)))
    }

    "The Mower" should "move +1 on X axis when facing East and receiving a F instruction" in {
      val mower = Mower(E, Position(3, 7)).move(F)

      mower should equal(Mower(E, Position(4, 7)))
    }

    "The Mower" should "move -1 on X axis when facing West and receiving a F instruction" in {
      val mower = Mower(W, Position(4, 4)).move(F)

      mower should equal(Mower(W, Position(3, 4)))
    }

  //test L instruction on move method
  "The Mower" should "face West  when facing North and receiving a L instruction" in {
    val mower = Mower(N, Position(0, 0)).move(L)

    mower should equal(Mower(W, Position(0,0)))
  }
  "The Mower" should "face North when facing East and receiving a L instruction" in {
    val mower = Mower(E, Position(3, 3)).move(L)

    mower should equal(Mower(N, Position(3,3)))
  }
  "The Mower" should "face East when facing South and receiving a L instruction" in {
    val mower = Mower(S, Position(0, 0)).move(L)

    mower should equal(Mower(E, Position(0,0)))
  }
  "The Mower" should "face South when facing West and receiving a L instruction" in {
    val mower = Mower(W, Position(0, 0)).move(L)

    mower should equal(Mower(S, Position(0,0)))
  }

  //test R instruction on move method
  "The Mower" should "face East  when facing North and receiving a R instruction" in {
    val mower = Mower(N, Position(0, 0)).move(R)

    mower should equal(Mower(E, Position(0,0)))
  }
  "The Mower" should "face South when facing East and receiving a R instruction" in {
    val mower = Mower(E, Position(3, 3)).move(R)

    mower should equal(Mower(S, Position(3,3)))
  }
  "The Mower" should "face West when facing South and receiving a R instruction" in {
    val mower = Mower(S, Position(0, 0)).move(R)

    mower should equal(Mower(W, Position(0,0)))
  }
  "The Mower" should "face North when facing West and receiving a R instruction" in {
    val mower = Mower(W, Position(4, 6)).move(R)

    mower should equal(Mower(N, Position(4,6)))
  }

  "The Mower" should "not move when going out of the lawn boundaries" in {
    object TheImpossibleLawn extends Lawn(20,20) {
      override def isWithinBoundaries(position: Position): Boolean = false
    }
    val mower = Mower(W, Position(4, 6)).move(F)(TheImpossibleLawn)
    mower should equal(Mower(W, Position(4, 6)))
  }
}
