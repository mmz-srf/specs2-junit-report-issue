# Specs2 JUnit XML Report Issue Demo

When adding the Tests.Argument `exclude to the testOptions,
the generation of the name of the test cases in the JUnit XML Report is wrong.


    testOptions in Test ++= Seq(Tests.Argument(TestFrameworks.Specs2, "exclude", "io"))

## Specs2 Test

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

## Expected XML in `target/test-reports` without the option

    ...
    <testcase name="This is a test group::with section 2, which should::execute test 2A" classname="MultipleShouldBlockTest" time="0.223">
    </testcase>
    <testcase name="This should not be the prefix::of all test case names in the JUnit XML" classname="MultipleShouldBlockTest" time="0.154">
    </testcase>
    <testcase name="This is a test group::with section 1, which should::execute test 1B" classname="MultipleShouldBlockTest" time="0.202">
    </testcase>
    <testcase name="This is a test group::with section 1, which should::execute test 1A" classname="MultipleShouldBlockTest" time="0.197">
    </testcase>
    ...
    
## Actual XML in `target/test-reports` with the option

    ...
    <testcase name="This should not be the prefix::This is a test group::with section 1, which should::execute test 1A" classname="MultipleShouldBlockTest" time="0.115">        
    </testcase>
    <testcase name="This should not be the prefix::This is a test group::with section 1, which should::execute test 1B" classname="MultipleShouldBlockTest" time="0.120">
    </testcase>
    <testcase name="This should not be the prefix::This is a test group::with section 1, which should::with section 2, which should::execute test 2A" classname="MultipleShouldBlockTest" time="0.127">
    </testcase>
    <testcase name="This should not be the prefix::of all test case names in the JUnit XML" classname="MultipleShouldBlockTest" time="0.086">
    </testcase>
    ...