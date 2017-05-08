import com.gbsol.propa.core.*
import kotlinx.html.div

/**
 * Created by gbaldeck on 5/5/2017.
 */
class TestComponent: PropaComponent() {
  companion object: PropaComponentRenderer<TestComponent>

  var setMe: String? = null
  
  val jsConstructor = this::class.js

  override fun template(): PropaTemplate =  {
    console.log("js constructor: ", jsConstructor)
    div {
      +"Hells to the yeah"
    }
    setMe?.let { div { +it } }
  }
}

class OtherTestComponent: PropaComponent() {
  companion object: PropaComponentRenderer<OtherTestComponent>

  override fun template(): PropaTemplate =  {
      TestComponent{}
      TestComponent {
        setMe = "Other test component"
      }
  }

}