import org.specs2.mutable.Specification

object MultipleShouldBlockTest extends Specification {

  "This should not be the prefix" >> {
    "of all test case names in the JUnit XML" in {
      ok
    }
  }

  "This is a test group" >>  {

    "with section 1, which" should {
      "execute test 1A" in {
        ok
      }

      "execute test 1B" in {
        ok
      }
    }

    "with section 2, which" should {
      "execute test 2A" in {
        ok
      }
    }

  }

}
