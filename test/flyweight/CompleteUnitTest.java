package flyweight;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CharacterPropertiesFactoryTest.class, DocumentTest.class })
public class CompleteUnitTest {

}
