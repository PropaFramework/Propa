import io.propa.framework.core.*
import io.propa.framework.di.PropaInject
import io.propa.framework.di.PropaService
import io.propa.framework.external.require
import kotlinx.html.div

/**
 * Created by gbaldeck on 5/5/2017.
 */
class LastComponent: PropaComponent(){
  companion object: PropaComponentRenderer<LastComponent>

  val service by PropaInject<TestService>()

  var detect by PropaDetect<String?>(null)

  override fun template(): PropaTemplate = {
    div("") {
      detect = ""
      +"NO styles"
      div("test") {
        +"styles"
        div {
          +service.test
        }
      }
    }
  }
}

class TestComponent: PropaComponent() {
  companion object: PropaComponentRenderer<TestComponent>

  var setMe: String? = null
  
  val jsConstructor = this::class.js

  override var style: String? = require("resources/styles/test.css")

  override var classes: String? = "red"

  override fun template(): PropaTemplate =  {
    div {
      +"Hells to the yeah"
    }
    setMe?.let { div { +it } }
    LastComponent { inheritStyle = true }
  }
}

class OtherTestComponent: PropaComponent() {
  companion object: PropaComponentRenderer<OtherTestComponent>

  override var style: String? = require("resources/styles/test.css")

  override fun template(): PropaTemplate =  {
      TestComponent{ classes = "test"; inheritStyle = false}
      TestComponent {
        classes = "test"
        setMe = "Other test component"
        inheritStyle = true
      }
  }

}

class TestService: PropaService {
  val test = "It works!"
}