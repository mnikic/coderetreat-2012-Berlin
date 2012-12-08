package gol

import Game._

class Game(val state: List[Pos]) {

  private def toActiveNeighbours(list: List[Pos]) = list.map(a => (a, lookupNeighbours(a).filter(state.contains(_))))

  private def pickByRule(list: List[(Pos, List[Pos])])(rule: Rule) = list.filter(ap => rule(ap._2)).map(_._1)
  
  private val neighboursOfActive = state.flatMap(a => lookupNeighbours(a)).distinct

  def step() = {
    val activeByFirstThreeRules = pickByRule(toActiveNeighbours(state))(stayAlive _)
    val activeByFourthRule = pickByRule(toActiveNeighbours(neighboursOfActive.filterNot(activeByFirstThreeRules.contains(_))))(becomeAlive _)

    Game(activeByFirstThreeRules ::: activeByFourthRule)
  }

  def isActive(pos: Pos) = {
    state.contains(pos)
  }
}

object Game {
  type Pos = (Int, Int)
  type Rule = List[Pos] => Boolean
  
  val neighBouringPositions = List((-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1))
  val allowedActiveNeighbourSize = List(2, 3)

  def apply(state: List[Pos]) = new Game(state)

  def lookupNeighbours(cell: Pos) = neighBouringPositions.map(pos => (pos._1 + cell._1, pos._2 + cell._2))

  def stayAlive(activeNeighbours: List[Pos]) = allowedActiveNeighbourSize.contains(activeNeighbours.size)

  def becomeAlive(activeNeighbours: List[(Int, Int)]) = activeNeighbours.size == 3
}