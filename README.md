JerseyWTF
=========

JerseyTestNg.ContainerPerClassTest doesn't work if its part of a TestNG Group @Test(groups = {"integration"}).

The Gradle Wrapper is installed so to build simply...

    $ ./gradlew
    :clean UP-TO-DATE
    :compileJava UP-TO-DATE
    :processResources UP-TO-DATE
    :classes UP-TO-DATE
    :war
    :assemble
    :compileTestJava
    :processTestResources UP-TO-DATE
    :testClasses
    :test
    :check
    :build
    
    BUILD SUCCESSFUL
    
    Total time: 11.279 secs

Note how gradle test works without issue, it runs any test annotated @Test...

    $ ./gradlew test
    :compileJava UP-TO-DATE
    :processResources UP-TO-DATE
    :classes UP-TO-DATE
    :compileTestJava UP-TO-DATE
    :processTestResources UP-TO-DATE
    :testClasses UP-TO-DATE
    :test
    
    BUILD SUCCESSFUL
    
    Total time: 4.661 secs

But gradle integrationTest doesn't.  It runs tests annotated @Test(groups = {"integration"}).
Its only the Jersey Tests that fail, though...

    $ ./gradlew integrationTest
    :compileJava UP-TO-DATE
    :processResources UP-TO-DATE
    :classes UP-TO-DATE
    :compileTestJava UP-TO-DATE
    :processTestResources UP-TO-DATE
    :testClasses UP-TO-DATE
    :test UP-TO-DATE
    :integrationTest
    
    Gradle test > jerseywtf.JerseyTestNGTest.integrationTest FAILED
        java.lang.NullPointerException at JerseyTestNGTest.java:41
    
    2 tests completed, 1 failed
    :integrationTest FAILED
    
    FAILURE: Build failed with an exception.
    
    * What went wrong:
    Execution failed for task ':integrationTest'.
    > There were failing tests. See the report at: file:///Users/robertkuhar/work/JerseyWTF/build/reports/tests/index.html
    
    * Try:
    Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output.
    
    BUILD FAILED
    
    Total time: 8.082 secs

What's up with that?
