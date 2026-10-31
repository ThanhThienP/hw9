package flyweight;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<Character> characters;

    public Document() {
        characters = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void saveToFile(String filename) {
    }

    public static Document loadFromFile(String filename, CharacterPropertiesFactory factory) {
        return new Document();
    }
}
