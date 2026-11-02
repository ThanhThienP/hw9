package proxy;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ SongTest.class, SongServiceProxyTest.class })
public class CompleteUnitTest {

}
