package flyweight;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Character c : characters) {
                writer.println(c.getValue() + ","
                        + c.getProperties().getFont() + ","
                        + c.getProperties().getColor() + ","
                        + c.getProperties().getSize());
            }
        } catch (IOException e) {
            System.out.println("Error saving document: " + e.getMessage());
        }
    }

    public static Document loadFromFile(String filename, CharacterPropertiesFactory factory) {
        Document doc = new Document();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                char value = parts[0].charAt(0);
                String font = parts[1];
                String color = parts[2];
                int size = Integer.parseInt(parts[3]);

                CharacterProperties props = factory.getProperties(font, size, color);
                doc.addCharacter(new Character(value, props));
            }
        } catch (IOException e) {
            System.out.println("Error loading document: " + e.getMessage());
        }
        return doc;
    }
}
