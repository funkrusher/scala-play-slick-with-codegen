package dao

import play.api.db.slick.DatabaseConfigProvider
import tables.Tables.Lang
import tables.Tables.LangRow
import util.DbAccess

import javax.inject.Inject
import javax.inject.Singleton
import scala.concurrent.ExecutionContext

/**
 * LangDAO
 *
 * @param ec
 */
@Singleton
class QuestionDAO @Inject() (dbcp: DatabaseConfigProvider)(implicit ec: ExecutionContext) extends DbAccess(dbcp) {
  import api._

  def fetchAll(): DBIO[Seq[LangRow]] =
    Lang.result
}
