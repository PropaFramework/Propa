import io.propa.framework.component.PropaComponent
import io.propa.framework.component.PropaComponentBuilder
import io.propa.framework.component.invoke
import io.propa.framework.di.PropaInject
import io.propa.framework.di.PropaService
import io.propa.framework.dom.PropaTemplate
import io.propa.framework.dom.div
import io.propa.framework.external.require
import io.propa.framework.snabbdom.plusAssign

/**
 * Created by gbaldeck on 5/5/2017.
 */
class LastComponent: PropaComponent(){
  companion object: PropaComponentBuilder<LastComponent>

  val service: TestService by PropaInject()

//  var detect by PropaDetect<String?>(null)

  override fun template(): PropaTemplate = {
    div {
//      detect = ""
      +"NO styles"
      div {
        +"styles"
        div {
          +service.test
        }
      }
    }
  }
}

class TestComponent: PropaComponent() {
  companion object: PropaComponentBuilder<TestComponent>

  var setMe: String? = null
  
  val jsConstructor = this::class.js

  override var stylesheet: String? = require("resources/styles/test.css")

  init {
    classes += "red"
  }

  override fun template():PropaTemplate = {
    div {
      +"Hells to the yeah"
    }
    setMe?.let { div { +it } }
    LastComponent { inheritStyle = true }
  }
}

class EntryComponent: PropaComponent() {
  companion object: PropaComponentBuilder<EntryComponent>

  override var stylesheet: String? = require("resources/styles/test.css")

  override fun template(): PropaTemplate = {
      TestComponent{ classes += "test";
        inheritStyle = false}
      TestComponent {
        classes += "test"
        setMe = "Other test component"
        inheritStyle = true
      }
  }

}

class TestService: PropaService {
  val test = "It works!"
}