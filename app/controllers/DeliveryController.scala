package controllers

import javax.inject._
import play.api.libs.json.Json
import play.api.mvc._
import repositories.DataRepository

@Singleton
class DeliveryController @Inject()(cc: ControllerComponents, dataRepository: DataRepository) extends AbstractController(cc) {

  def index = Action {
    Ok("Delivery App")
  }

  def getPacks(packId: Int) = Action {
    dataRepository.getPacks(packId) map { pack => Ok(Json.toJson(pack)) } getOrElse NotFound
  }

  def getPizza(pizzaId: Int) = Action {
    Ok(Json.toJson(dataRepository.getPizza(pizzaId)))
  }

  def getPacksByPizzaId(pizzaId: Int) = Action {
    Ok(Json.toJson(dataRepository.getPacksByPizzaId(pizzaId)))
  }

}
