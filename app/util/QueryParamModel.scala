package util

import play.api.libs.json.Json

case class QueryParamModel(
    drop: Option[Int],
    take: Option[Int],
    sorter: Option[QueryParamSorterModel],
    filters: Option[Seq[QueryParamFilterModel]],
) {

  def findFilterByName(tableName: String, filterName: String): Option[QueryParamFilterModel] =
    filters match {
      case Some(list) => list.find(x => x.tableName == tableName && x.filterName == filterName)
      case _          => None
    }

}

object QueryParamModel {
  implicit val fmt = Json.format[QueryParamModel]
}
