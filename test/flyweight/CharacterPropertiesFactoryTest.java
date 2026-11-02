package flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesFactoryTest {

    @Test
    public void testGetProperties() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        CharacterProperties props = factory.getProperties("Arial", "Red", 12);

        assertEquals("Arial", props.getFont());
        assertEquals("Red", props.getColor());
        assertEquals(12, props.getSize());
    }

    @Test
    public void testSamePropertiesReturnsSameObject() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        CharacterProperties props1 = factory.getProperties("Arial", "Red", 12);
        CharacterProperties props2 = factory.getProperties("Arial", "Red", 12);

        assertSame(props1, props2, "Same properties should return the exact same flyweight object");
    }

    @Test
    public void testDifferentPropertiesReturnsDifferentObject() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        CharacterProperties props1 = factory.getProperties("Arial", "Red", 12);
        CharacterProperties props2 = factory.getProperties("Calibri", "Blue", 14);

        assertNotSame(props1, props2, "Different properties should return different objects");
    }

    @Test
    public void testCacheSize() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        factory.getProperties("Arial", "Red", 12);
        factory.getProperties("Calibri", "Blue", 14);
        factory.getProperties("Verdana", "Black", 16);

        assertEquals(3, factory.getCacheSize());
    }

    @Test
    public void testCacheSizeWithDuplicates() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        factory.getProperties("Arial", "Red", 12);
        factory.getProperties("Arial", "Red", 12);
        factory.getProperties("Arial", "Red", 12);

        assertEquals(1, factory.getCacheSize(), "Duplicate properties should not increase cache size");
    }
}
