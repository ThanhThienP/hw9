package flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

public class DocumentTest {

    @Test
    public void testAddCharacter() {
        Document doc = new Document();
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        CharacterProperties props = factory.getProperties("Arial", "Red", 12);

        doc.addCharacter(new Character('H', props));
        assertEquals(1, doc.getCharacters().size());
    }

    @Test
    public void testGetCharacters() {
        Document doc = new Document();
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        CharacterProperties props = factory.getProperties("Arial", "Red", 12);

        doc.addCharacter(new Character('H', props));
        doc.addCharacter(new Character('i', props));

        assertEquals('H', doc.getCharacters().get(0).getValue());
        assertEquals('i', doc.getCharacters().get(1).getValue());
    }

    @Test
    public void testSaveAndLoadFromFile() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        Document doc = new Document();

        CharacterProperties arial12Red = factory.getProperties("Arial", "Red", 12);
        CharacterProperties calibri14Blue = factory.getProperties("Calibri", "Blue", 14);

        doc.addCharacter(new Character('A', arial12Red));
        doc.addCharacter(new Character('B', calibri14Blue));
        doc.addCharacter(new Character('C', arial12Red));

        String filename = "test_document.txt";
        doc.saveToFile(filename);

        CharacterPropertiesFactory loadFactory = new CharacterPropertiesFactory();
        Document loaded = Document.loadFromFile(filename, loadFactory);

        assertEquals(3, loaded.getCharacters().size());
        assertEquals('A', loaded.getCharacters().get(0).getValue());
        assertEquals('B', loaded.getCharacters().get(1).getValue());
        assertEquals('C', loaded.getCharacters().get(2).getValue());

        assertEquals("Arial", loaded.getCharacters().get(0).getProperties().getFont());
        assertEquals("Blue", loaded.getCharacters().get(1).getProperties().getColor());

        // cleanup
        new File(filename).delete();
    }

    @Test
    public void testFlyweightSharingAfterLoad() {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        Document doc = new Document();

        CharacterProperties props = factory.getProperties("Arial", "Red", 12);
        doc.addCharacter(new Character('X', props));
        doc.addCharacter(new Character('Y', props));

        String filename = "test_sharing.txt";
        doc.saveToFile(filename);

        CharacterPropertiesFactory loadFactory = new CharacterPropertiesFactory();
        Document loaded = Document.loadFromFile(filename, loadFactory);

        assertSame(
                loaded.getCharacters().get(0).getProperties(),
                loaded.getCharacters().get(1).getProperties(),
                "Characters with same properties should share the same flyweight object after loading");

        // cleanup
        new File(filename).delete();
    }

    @Test
    public void testDriverMainExecution() {
        assertDoesNotThrow(() -> Driver.main(new String[] {}));
    }
}
