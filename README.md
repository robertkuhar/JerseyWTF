JerseyWTF
=========

JerseyTestNg.ContainerPerClassTest doesn't work if its part of a TestNG Group @Test(groups = {"integration"}).
It works fine if its not part of any specific group.  What's up with that?

    $ gradle test integrationTest
    :compileJava UP-TO-DATE
    :processResources UP-TO-DATE
    :classes UP-TO-DATE
    :compileTestJava UP-TO-DATE
    :processTestResources UP-TO-DATE
    :testClasses UP-TO-DATE
    :test UP-TO-DATE
    :integrationTest
    
    Gradle test > jerseywtf.JerseyTestNGTest.integrationTest FAILED
        java.lang.NullPointerException at JerseyTestNGTest.java:29
    
    2 tests completed, 1 failed
    :integrationTest FAILED
    
    FAILURE: Build failed with an exception.
    
    * What went wrong:
    Execution failed for task ':integrationTest'.
    > There were failing tests. See the report at: file:///Users/robert.kuhar/work/jerseywtf/build/reports/tests/index.html
    
    * Try:
    Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.
    
    BUILD FAILED
    
    Total time: 4.696 secs

