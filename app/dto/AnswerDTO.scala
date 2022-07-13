package dto

import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class AnswerDTO(
    questionVersionId: Long,
    answerId: Long,
    content: String,
)

object AnswerDTO {
  implicit val fmt: OFormat[AnswerDTO] = Json.format[AnswerDTO]
}
