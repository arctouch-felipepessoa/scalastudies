package repositories

import javax.inject.Singleton
import models.{Pack, Pizza}

@Singleton
class DataRepository {

  private val packs = Seq(
    Pack(1, List(1, 2), "John"),
    Pack(2, List(1, 3), "Mary"),
    Pack(3, List(1, 2, 3), "Half"),
  )

  private val pizzas = Seq(
    Pizza(1, "Mussarela"),
    Pizza(2, "Pepperoni"),
    Pizza(3, "Meat")
  )

  def getPacks(packId: Int): Option[Pack] = packs.collectFirst { case p if p.id == packId => p }

  def getPizza(pizzaId: Int): Seq[Pizza] = pizzas.collect { case p if p.id == pizzaId => p }

  def getPacksByPizzaId(pizzaId: Int) : Seq[Pack] = packs.filter(_.pizzaIds.contains(pizzaId))
}