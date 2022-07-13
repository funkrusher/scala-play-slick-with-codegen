package controllers

import mapper.LangMapper
import mapper.QuestionMapper
import play.api.i18n.I18nSupport
import play.api.libs.json.JsSuccess
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.mvc.AbstractController
import play.api.mvc.Action
import play.api.mvc.AnyContent
import play.api.mvc.ControllerComponents
import util.QueryParamModel

import javax.inject.Inject
import javax.inject.Singleton
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class QuestionController @Inject() (cc: ControllerComponents, questionMapper: QuestionMapper, langMapper: LangMapper)
    extends AbstractController(cc)
    with I18nSupport {

  /**
   * Fetches all questions
   *
   * @return questions as json
   */
  def fetchAll: Action[JsValue] =
    Action(parse.json).async { implicit request =>
      val test = request.body.validate[QueryParamModel] match {
        case JsSuccess(qParam, _) =>
          val result = for {
            langDTO <- langMapper.fetchOne(request.lang)
            count   <- questionMapper.countQuestionVersion(qParam)
            data    <- questionMapper.fetchQuestionVersion(qParam, langDTO)
          } yield (count, data)
          result.map({
            case (count, data) =>
              Ok(
                Json.obj(
                  "count" -> count,
                  "data"  -> data,
                )
              )
          })

        case _ => Future.successful(BadRequest(""))
      }
      test
    }

  /**
   * Fetches all questions
   *
   * @return questions as json
   */
  def fetchAllDropTake(drop: Int, take: Int): Action[AnyContent] =
    Action.async { implicit request =>
      val qParam = QueryParamModel(drop = Some(drop), take = Some(take), sorter = None, filters = None)
      val result = for {
        langDTO <- langMapper.fetchOne(request.lang)
        count   <- questionMapper.countQuestionVersion(qParam)
        data    <- questionMapper.fetchQuestionVersion(qParam, langDTO)
      } yield (count, data)
      result.map({
        case (count, data) =>
          Ok(
            Json.obj(
              "count" -> count,
              "data"  -> data,
            )
          )
      })
    }
}
