import com.gbsol.propa.*
import kotlinx.html.div

/**
 * Created by gbaldeck on 5/5/2017.
 */
class TestComponent: PropaComponent{
  companion object: PropaComponentRenderer<TestComponent>

  var setMe: String = ""

  override fun template(): PropaTemplate =  {
    div {
      +"Hells to the yeah"
    }
    when {
      setMe != "" -> div{ +setMe }
    }
  }
}

class OtherTestComponent: PropaComponent{
  companion object: PropaComponentRenderer<OtherTestComponent>

  override fun template(): PropaTemplate =  {
      TestComponent{}
      TestComponent {
        setMe = "Other test component"
      }
  }

}