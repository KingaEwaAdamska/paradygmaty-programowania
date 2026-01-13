package lista7.scala

import lista7.java.KitchenVisitor
import scala.jdk.CollectionConverters._

object CleaningKitchen {
  def main(args: Array[String]): Unit = {
    val sorter = new KitchenVisitor()
    
    val dirtyListScala = List(
      new Spoon(), new Fork(), new Fork(), new Spoon(), new Plate(), 
      new Bowl(), new Pan(), new Bowl(), new Spoon(), new Fork(), 
      new Spoon(), new Fork(), new Fork(), new Spoon(), new Plate(), 
      new Bowl(), new Pan(), new Bowl(), new Spoon(), new Fork(), 
      new Plate(), new Plate(), new Bowl(), new Pan(), new Fork(), 
      new Spoon(), new Plate(), new Fork(), new Spoon(), new Spoon(),
      new Plate(), new Plate(), new Bowl(), new Pan(), new Fork()
    )
    
    sorter.sort(dirtyListScala.asJava)
    println("--- Sorter started ---")
    sorter.displayCount()

    val dishwashers = List(
      new Dishwasher(1, 5, 10, 10),
      new Dishwasher(2, 5, 10, 10),
      new Dishwasher(3, 5, 10, 10)
    )

    println("--- Washing start ---")

    while (!sorter.isEmpty()) {
      val freeDishwasher = dishwashers.find(d => !d.isLocked)
      
      freeDishwasher match {
        case Some(dw) => 
          dw.fillAndRun(sorter)
          sorter.displayCount()
        case None => 
          Thread.sleep(500)
      }
    }

    println("--- All cleaned! ---")
    
    Thread.sleep(4000) 
  }
}
