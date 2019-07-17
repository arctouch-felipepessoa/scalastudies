package models

import play.api.libs.json.{Json, OFormat}

case class Pack(id: Int, pizzaIds: List[Int], driverName: String)


object Pack {

  implicit val format: OFormat[Pack] = Json.format[Pack]
}
