package lista7.scala

import lista7.java.Visitor

abstract class KitchenUtensil(name: String) {
  def accept(visitor: Visitor): Unit
  override def toString: String = s"$name"
}

abstract class Cutlery(name: String, size: Integer) extends KitchenUtensil(name)
abstract class Dish(name: String, size: Integer) extends KitchenUtensil(name)
abstract class Cookware(name: String, size: Integer) extends KitchenUtensil(name)

class Spoon() extends Cutlery("Spoon", Config.spoonSize){
  override def accept(visitor: Visitor): Unit = visitor.visit(this)
}

class Fork() extends Cutlery("Fork", Config.forkSize){
  override def accept(visitor: Visitor): Unit = visitor.visit(this)
}

class Plate() extends Dish("Plate", Config.plateSize){
  override def accept(visitor: Visitor): Unit = visitor.visit(this)
}

class Bowl() extends Dish("Bowl", Config.bowlSize){
  override def accept(visitor: Visitor): Unit = visitor.visit(this)
}

class Pan() extends Cookware("Pan", Config.panSize){
  override def accept(visitor: Visitor): Unit = visitor.visit(this)
}

