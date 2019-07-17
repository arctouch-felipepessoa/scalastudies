package models

import play.api.libs.json.{Json, OFormat}

case class Pizza(id: Int, name: String)

object Pizza {

  implicit val format: OFormat[Pizza] = Json.format[Pizza]
}