package mapper

import dao.LangDAO
import dto.AnswerDTO
import dto.LangDTO
import dto.QuestionVersionDTO
import play.api.db.slick.DatabaseConfigProvider
import tables.Tables.Question
import tables.Tables.QuestionRow
import util.DbAccess
import util.QueryParamModel
import util.SlickImplictHelpers._

import javax.inject.Inject
import javax.inject.Singleton
import scala.concurrent.ExecutionContext
import scala.concurrent.Future

@Singleton
class QuestionMapper @Inject() (dbcp: DatabaseConfigProvider, langDAO: LangDAO)(implicit ec: ExecutionContext)
    extends DbAccess(dbcp) {
  import api._

  private def getQuestionVersionQuery(qParam: QueryParamModel): Query[Question, QuestionRow, Seq] = {
    // query-params:
    // - we filter and sort on the question-table
    // - we paginate on the join of the related tables (inner-join)
    // - no 1:n joins are allowed here, because we must calculate a count, which would be wrong if 1:n joins are
    // made.
    var query = for {
      a <- Question
    } yield a
    query;
  }

  /**
   * Returns the total count for the pagination
   *
   * @param qParam            qParam
   * @param filteredAuthorIds filteredAuthorIds
   * @return count
   */
  def countQuestionVersion(qParam: QueryParamModel): Future[Int] = {
    val query = getQuestionVersionQuery(qParam);
    // return the count (no 1:n joins are allowed, because we need to count)
    db.run(query.size.result)
  }

  /**
   * Returns all authors in a specific pagination-window (starting with offset)
   *
   * @param qParam            qParam
   * @return questions of the pagination-window
   */
  def fetchQuestionVersion(qParam: QueryParamModel, langDTO: LangDTO): Future[Seq[QuestionVersionDTO]] = {

    // paginate the filtered and sorted result now.
    val query = getQuestionVersionQuery(qParam)
      .drop(qParam.drop.getOrElse(-1))
      .take(qParam.take.getOrElse(-1))

    // note: i must use our own custom "groupByOrdered" function, because scala "groupBy"
    // would loose our already sorted insertion-order otherwise.
    db.run(query.result)
      .map(questions =>
        questions.map(question =>
          QuestionVersionDTO(
            questionId = questionversion.questionid,
            questionVersionId = questionversion.questionversionid,
            latest = questionversion.latest,
            createdAt = questionversion.createdat.toString,
            content = maybe_X_Lang.map(_.content).getOrElse(""),
            answers = answers,
            versions = None,
          )
        )
      )
  }

}
