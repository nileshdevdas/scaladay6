package samples

import org.junit._
import Assert._

@Test
class AppTest {


    // test
    @Test
    def testAppAdd()  = assertTrue(cg.samp2.App.add(100,100) == 200)

}


