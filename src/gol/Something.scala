package gol
import org.scalatest.FunSuite
import scala.collection.mutable.Stack
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
 
@RunWith(classOf[JUnitRunner])
class ExampleSuite extends FunSuite {
 
  test("pop is invoked on a non-empty stack") {
     val active = List((0,0))
     val game = new Game(active)
     
     assert(game.step().isActive((0,0)) === false)
  }

}