import com.gbsol.propa.core.*
import com.gbsol.propa.external.require
import kotlinx.html.div

/**
 * Created by gbaldeck on 5/5/2017.
 */
class TestComponent: PropaComponent() {
  companion object: PropaComponentRenderer<TestComponent>

  var setMe: String? = null
  
  val jsConstructor = this::class.js

  override var classes: String? = "red"

  override fun template(): PropaTemplate =  {
    div {
      +"Hells to the yeah"
    }
    setMe?.let { div { +it } }
  }
}

class OtherTestComponent: PropaComponent() {
  companion object: PropaComponentRenderer<OtherTestComponent>

  override var style: String? = require("resources/styles/test.css")

  override fun template(): PropaTemplate =  {
      TestComponent{ classes = "test"; inheritStyle = true}
      TestComponent {
        setMe = "Other test component"
        inheritStyle = true
      }
  }

}