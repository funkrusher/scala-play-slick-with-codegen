import com.google.inject.AbstractModule
import play.api.Configuration
import play.api.Environment

class Module(environment: Environment, configuration: Configuration) extends AbstractModule {
  override def configure(): Unit = {}
}
