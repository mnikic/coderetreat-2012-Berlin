package gol
import org.scalatest.FunSuite

import scala.collection.mutable.Stack
 
class ExampleSuite extends FunSuite {
 
  test("pop is invoked on a non-empty stack") {
     val active = List((0,0))
     val game = new Game(active)
     game.step()
     
     assert(game.isActive((0,0)) === false)
  }

}