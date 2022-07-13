package dto

import play.api.libs.json.Json
import tables.Tables._

case class LangDTO(
    langid: Int,
    isolang: String
)

object LangDTO {
  implicit val fmt = Json.format[LangDTO]

  def fromRow(row: LangRow): LangDTO = {
    LangDTO(
      langid = row.langid,
      isolang = row.isolang
    )
  }

  def toRow(lang: LangDTO): LangRow = {
    LangRow(
      langid = lang.langid,
      isolang = lang.isolang
    )
  }
}
