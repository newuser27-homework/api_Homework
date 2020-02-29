package TestSuite;


import APITests.APITestCases;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    APITestCases.class,
    //UseCase2Test.class,
})
public class AllAPITests {
}

