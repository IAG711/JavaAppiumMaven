package suites;

import Tests.ArticleTests;
import Tests.SearchTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArticleTests.class,
        SearchTests.class
})

public class TestSuite {}
