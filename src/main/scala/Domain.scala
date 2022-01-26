  object TheFamousAutoMowerProgram{
    def run(lawn: Lawn, mowersAndInstructions: MowersAndInstructions) = {
      implicit val theLawn = lawn
      mowersAndInstructions.map { mowerWithInstructions =>
        val (mower, instructions) = mowerWithInstructions
        instructions.foldLeft(mower)((mower, instruction) => mower.move(instruction))
      }
    }
  }
  
  type MowersAndInstructions = Seq[(Mower, Seq[Instructions])]
  
  enum CardinalPoints:
    case N, E, S, W

  enum Instructions:
    case L, R, F

  case class Position(x: Int, y: Int)
  case class Lawn(x: Int, y: Int){
    def isWithinBoundaries(position: Position) = position match {
      case Position(a,_) if a < 0 || a > x => false
      case Position(_,b) if b < 0 || b > y => false
      case _ => true
    }
  }

  case class Mower(direction: CardinalPoints, position: Position){
    import CardinalPoints._
    private def spinLeft(): Mower = direction match {
      case N => copy(direction = W)
      case E => copy(direction = N)
      case S => copy(direction = E)
      case W => copy(direction = S)
    }
    private def spinRight(): Mower = direction match {
      case N => copy(direction = E)
      case E => copy(direction = S)
      case S => copy(direction = W)
      case W => copy(direction = N)
    }
    private def forward(): Mower = direction match {
      case N => copy(position = Position(position.x , position.y+1))
      case E => copy(position = Position(position.x +1  , position.y))
      case S => copy(position = Position(position.x , position.y - 1))
      case W => copy(position = Position(position.x -1 , position.y))
    }

    import Instructions._
    def move(instruction: Instructions)(implicit lawn: Lawn): Mower =
      instruction match
        case F => moveIfValid(forward())
        case L => spinLeft()
        case R => spinRight()
    
    private def moveIfValid(mowerWithNewPosition: Mower)(implicit lawn: Lawn):Mower = 
        if (lawn.isWithinBoundaries(mowerWithNewPosition.position)) mowerWithNewPosition else this
      
    override def toString = position.x + " " + position.y + " " + direction
  }



