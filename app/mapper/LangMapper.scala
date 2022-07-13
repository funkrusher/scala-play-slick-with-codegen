package mapper

import dao.LangDAO
import dto.LangDTO
import play.api.db.slick.DatabaseConfigProvider
import util.DbAccess

import javax.inject.Inject
import javax.inject.Singleton
import scala.concurrent.ExecutionContext
import scala.concurrent.Future

@Singleton
class LangMapper @Inject() (dbcp: DatabaseConfigProvider, langDAO: LangDAO)(implicit ec: ExecutionContext)
    extends DbAccess(dbcp) {

  def fetchAll(): Future[Seq[LangDTO]] =
    db.run(langDAO.fetchAll())
      .map(langRows => langRows.map(langRow => LangDTO.fromRow(langRow)))

  def fetchOne(i18Lang: play.api.i18n.Lang): Future[LangDTO] =
    db.run(langDAO.fetchOneByIsoLang(i18Lang.code))
      .map(langRow => LangDTO.fromRow(langRow))
}
