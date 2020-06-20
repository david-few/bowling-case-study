package code

sealed trait Frame
final case class Strike() extends Frame
final case class Spare(rollOne: Int) extends Frame
final case class Regular(rollOne: Int, rollTwo: Int) extends Frame
final case class Bonus(rollOne: Int, rollTwo: Int) extends Frame

sealed trait State
final case class NormalState() extends State
final case class SpareState() extends State
final case class StrikeState() extends State
final case class StrikeStrikeState() extends State

object Main extends App {

  def calculate(frames: List[Frame]): Int = {
    return allScore(frames, NormalState(), 0, 0)
  }

  def allScore(frames: List[Frame], state: State, i: Int, acc: Int) : Int = {
    if (i == frames.size) return acc
    println(i, acc)
    val (score, newState) = frameScore(frames(i), state)
    return allScore(frames, newState, i+1, acc+score)
  }

//  def nextState(frameIndex: Int, state: State): State =
//    frameIndex match {
//      case 0                        => NormalState()
//      case i if 1 to 9 contains i   => state
//      case _                        => EndState()
//    }

  def frameScore(frame: Frame, state: State): (Int, State) =
    frame match {
      case Bonus(rollOne, rollTwo) =>
        state match {
          case NormalState()        => (0, state)
          case SpareState()         => (rollOne, state)
          case StrikeStrikeState()  => (rollOne * 2 + rollTwo, state)
          case StrikeState()        => (rollOne + rollTwo, state)
        }
      case Strike() =>
        state match {
          case NormalState()        => (10, StrikeState())
          case SpareState()         => (20, StrikeState())
          case StrikeStrikeState()  => (30, StrikeStrikeState())
          case StrikeState()        => (20, StrikeStrikeState())
        }
      case Spare(rollOne) =>
        state match {
          case NormalState()        => (10, SpareState())
          case SpareState()         => (rollOne + 10, SpareState())
          case StrikeStrikeState()  => (rollOne + 20, SpareState())
          case StrikeState()        => (20, SpareState())
        }
      case Regular(rollOne, rollTwo) =>
        state match {
          case NormalState()        => (rollOne + rollTwo, NormalState())
          case SpareState()         => (rollOne * 2 + rollTwo, NormalState())
          case StrikeStrikeState()  => ((rollOne * 3) + (rollTwo * 2), NormalState())
          case StrikeState()        => ((rollOne + rollTwo) * 2, NormalState())
        }
    }

}