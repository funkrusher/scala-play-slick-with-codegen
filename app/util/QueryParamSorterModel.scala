package util

import play.api.libs.json.Json

case class QueryParamSorterModel(
    sortOrder: String,
    sortName: String,
)

object QueryParamSorterModel {
  implicit val fmt = Json.format[QueryParamSorterModel]
}
