package flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesFactoryTest {

    @Test
    public void testGetProperties() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        CharacterProperties props = factory.getProperties("Arial", 12, "Red");

        assertEquals("Arial", props.getFont());
        assertEquals("Red", props.getColor());
        assertEquals(12, props.getSize());
    }

    @Test
    public void testSamePropertiesReturnsSameObject() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        CharacterProperties props1 = factory.getProperties("Arial", 12, "Red");
        CharacterProperties props2 = factory.getProperties("Arial", 12, "Red");

        assertSame(props1, props2, "Same properties should return the exact same flyweight object");
    }

    @Test
    public void testDifferentPropertiesReturnsDifferentObject() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        CharacterProperties props1 = factory.getProperties("Arial", 12, "Red");
        CharacterProperties props2 = factory.getProperties("Calibri", 14, "Blue");

        assertNotSame(props1, props2, "Different properties should return different objects");
    }

    @Test
    public void testCacheSize() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        factory.getProperties("Arial", 12, "Red");
        factory.getProperties("Calibri", 14, "Blue");
        factory.getProperties("Verdana", 16, "Black");

        assertEquals(3, factory.getCacheSize());
    }

    @Test
    public void testCacheSizeWithDuplicates() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        factory.getProperties("Arial", 12, "Red");
        factory.getProperties("Arial", 12, "Red");
        factory.getProperties("Arial", 12, "Red");

        assertEquals(1, factory.getCacheSize(), "Duplicate properties should not increase cache size");
    }
}
