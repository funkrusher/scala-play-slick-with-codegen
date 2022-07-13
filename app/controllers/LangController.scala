package controllers

import mapper.LangMapper
import play.api.i18n.I18nSupport
import play.api.libs.json.Json
import play.api.mvc.AbstractController
import play.api.mvc.Action
import play.api.mvc.AnyContent
import play.api.mvc.ControllerComponents

import javax.inject.Inject
import javax.inject.Singleton
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class LangController @Inject() (cc: ControllerComponents, langMapper: LangMapper)
    extends AbstractController(cc)
    with I18nSupport {

  /**
   * add a new author to the list
   *
   * @return author-data as json
   */
  def fetchAll: Action[AnyContent] =
    Action.async { implicit request =>
      val result = for {
        langs <- langMapper.fetchAll
      } yield langs

      val test = result.map({
        case (langs) =>
          Ok(Json.obj("langs" -> langs))
      })
      test
    }
}
