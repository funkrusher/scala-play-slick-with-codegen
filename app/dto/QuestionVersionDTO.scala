package dto

import play.api.libs.json.Json
import play.api.libs.json.OFormat

import java.sql.Timestamp

case class QuestionVersionDTO(
    questionId: Long,
    questionVersionId: Long,
    latest: Boolean,
    createdAt: String,
    content: String,
    answers: Seq[AnswerDTO],
    versions: Option[Seq[QuestionVersionDTO]],
)

object QuestionVersionDTO {
  implicit val fmt: OFormat[QuestionVersionDTO] = Json.format[QuestionVersionDTO]
}
