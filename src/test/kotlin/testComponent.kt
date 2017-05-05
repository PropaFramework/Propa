import com.gbsol.propa.PropaComponent
import com.gbsol.propa.PropaTemplate
import kotlinx.html.HTML

/**
 * Created by gbaldeck on 5/5/2017.
 */
class TestComponent: PropaComponent{
  override fun template(): PropaTemplate  {
    return "todo" as PropaTemplate
  }

}