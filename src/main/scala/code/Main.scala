package code


sealed trait Frame
final case class Strike()
final case class Spare(one: int,implicit two: int)
final case class Regular(one: int, two: int)
}