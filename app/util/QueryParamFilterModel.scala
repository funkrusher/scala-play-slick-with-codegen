package util

import play.api.libs.json.Json

case class QueryParamFilterModel(
    tableName: String,
    filterName: String,
    filterValue: String,
    filterComparator: String,
)

object QueryParamFilterModel {
  implicit val fmt = Json.format[QueryParamFilterModel]
}
