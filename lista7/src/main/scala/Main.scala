package lista7.scala

import lista7.java.KitchenVisitor
import scala.jdk.CollectionConverters._

object Main extends App {
  val sorter = new KitchenVisitor()
  
  val dirtyListScala = List(
    new Spoon(), 
    new Fork(), 
    new Fork(), 
    new Spoon(), 
    new Plate(), 
    new Bowl(),
    new Pan(),
    new Bowl(),
    new Spoon(), 
    new Fork(), 
    new Plate(), 
    new Plate(), 
    new Bowl(),
    new Pan(),
    new Fork(), 
    new Spoon(), 
    new Plate(), 
    new Fork(), 
    new Spoon(), 
    new Spoon()
  )
  
  val dirtyListJava = dirtyListScala.asJava

  println("--- Elf wrzuca brudy do sortowni ---")
  sorter.sort(dirtyListJava)

  val dishwasher = new Dishwasher(maxCutlerySpace = 5, maxDishSpace = 10, maxCookwareSpace = 10)

  sorter.displayCount()
  println("--- Pierwsze ładowanie (limit sztućców: 2) ---")
  dishwasher.fillAndRun(sorter)
  
  sorter.displayCount()
  println(s"Pozostałe widelce w sorterze: ${sorter.getForks.size()}")
  
  dishwasher.unlock()
  
  println("--- Drugie ładowanie (teraz weźmie resztę) ---")
  dishwasher.fillAndRun(sorter)
  sorter.displayCount()
}
