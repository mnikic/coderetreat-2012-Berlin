package gol
import org.scalatest.FunSuite
import scala.collection.mutable.Stack
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
 
@RunWith(classOf[JUnitRunner])
class ExampleSuite extends FunSuite {
 
  test("dies") {
     val active = List((0,0))
     val game = new Game(active)
     
     assert(game.step().isActive((0,0)) === false)
  }
  
  test("stays alive") {
     val active = List((0,0),(-1,0),(1,0))
     val game = new Game(active)
   
     assert(game.step().isActive((0,0)) === true)
  }

}