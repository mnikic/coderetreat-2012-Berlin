package gol
import org.scalatest.FunSuite
import scala.collection.mutable.Stack
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExampleSuite extends FunSuite {

  test("lookup neighbours on 0,0") {
    assert(Game.lookupNeighbours((0, 0)) === Game.neighBouringPositions)
  }

  test("active should be active") {
    val pos = (0, 0)
    val active = List(pos)
    val game = Game(active)

    assert(game.isActive(pos) === true)
  }

  test("dead should stay dead if less then 3 active neighbours") {
    val pos = (0, 0)
    val active = List(pos)
    val game = Game(active)
 
    assert(game.isActive((1, 0)) === false)
    assert(game.step.isActive((1, 0)) === false)
  }

  test("alone active should die after a step") {
    val active = List((0, 0))
    val game = Game(active)

    assert(game.step.isActive((0, 0)) === false)
  }

  test("horizontal 3 rotate 90 degrees after a step") {
    val active = List((0, 0), (-1, 0), (1, 0))
    val game = Game(active)
    val nextStep = game.step
    
    assert(nextStep.isActive((0, 0)) === true)
    assert(nextStep.isActive((0, -1)) === true)
    assert(nextStep.isActive((0, 1)) === true)
    assert(nextStep.isActive((-1, 0)) === false)
    assert(nextStep.isActive((1, 0)) === false)
  }
  
  test("vertical 3 rotate 90 degrees after a step") {
    val active = List((0, 0), (0, 1), (0, -1))
    val game = Game(active)
    val nextStep = game.step
    
    assert(nextStep.isActive((0, 0)) === true)
    assert(nextStep.isActive((0, -1)) === false)
    assert(nextStep.isActive((0, 1)) === false)
    assert(nextStep.isActive((-1, 0)) === true)
    assert(nextStep.isActive((1, 0)) === true)
  }

}