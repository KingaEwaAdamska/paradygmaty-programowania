package lista7.scala

import lista7.java.KitchenVisitor
import scala.jdk.CollectionConverters._

class Dishwasher(
  id: Integer,
  maxCutlerySpace: Integer,
  maxDishSpace: Integer,
  maxCookwareSpace: Integer
) {
  @volatile var isLocked: Boolean = false
  private var cutleryUsed: Integer = 0
  private var dishesUsed: Integer = 0
  private var cookwareUsed: Integer = 0

  def fillAndRun(sorter: KitchenVisitor): Unit = {
    if (isLocked) {
      println("Dishwasher is locked - it works!")
      return
    }

    val spoonsToTake = (maxCutlerySpace - cutleryUsed) / Config.spoonSize
    val takenSpoons = sorter.extract(sorter.getSpoons, spoonsToTake).asScala
    cutleryUsed += takenSpoons.size * Config.spoonSize
    val forksToTake = (maxCutlerySpace - cutleryUsed) / Config.forkSize
    val takenForks = sorter.extract(sorter.getForks, forksToTake).asScala
    cutleryUsed += takenForks.size * Config.forkSize

    val bowlsToTake = (maxDishSpace - dishesUsed) / Config.bowlSize
    val takenBowls = sorter.extract(sorter.getBowls, bowlsToTake).asScala
    dishesUsed += takenBowls.size * Config.bowlSize
    val platesToTake = (maxDishSpace - dishesUsed) / Config.plateSize
    val takenPlates = sorter.extract(sorter.getPlates, platesToTake).asScala
    dishesUsed += takenPlates.size * Config.plateSize

    val pansToTake = (maxCookwareSpace - cookwareUsed) / Config.panSize
    val takenPans = sorter.extract(sorter.getPans, pansToTake).asScala
    cookwareUsed += takenPans.size * Config.panSize

    isLocked = true
    println(s"Dishwasher $id: started.")
    new Thread(new Runnable {
      override def run(): Unit = {
        Thread.sleep(Config.washDuration)
        unlock()
        println(s"Dishwasher$id: ended.")
      }
    }).start()
  }

  def unlock() {
    isLocked = false;
    cutleryUsed = 0
    dishesUsed = 0
    cookwareUsed = 0
  }
}


