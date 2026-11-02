package flyweight;

public class Driver {
    public static void main(String[] args) {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();
        Document doc = new Document();

        CharacterProperties arialRed12 = factory.getProperties("Arial", 12, "Red");
        CharacterProperties calibriBlue14 = factory.getProperties("Calibri", 14, "Blue");
        CharacterProperties verdanaBlack16 = factory.getProperties("Verdana", 16, "Black");
        CharacterProperties verdanaRed14 = factory.getProperties("Verdana", 14, "Red");
        CharacterProperties arialBlue16 = factory.getProperties("Arial", 16, "Blue");
        CharacterProperties calibriBlack12 = factory.getProperties("Calibri", 12, "Black");

        doc.addCharacter(new Character('H', arialRed12));
        doc.addCharacter(new Character('e', arialRed12));
        doc.addCharacter(new Character('l', arialRed12));
        doc.addCharacter(new Character('l', calibriBlue14));
        doc.addCharacter(new Character('o', calibriBlue14));
        doc.addCharacter(new Character('W', calibriBlue14));
        doc.addCharacter(new Character('o', verdanaBlack16));
        doc.addCharacter(new Character('r', verdanaBlack16));
        doc.addCharacter(new Character('l', verdanaRed14));
        doc.addCharacter(new Character('d', verdanaRed14));
        doc.addCharacter(new Character('C', verdanaRed14));
        doc.addCharacter(new Character('S', arialBlue16));
        doc.addCharacter(new Character('5', arialBlue16));
        doc.addCharacter(new Character('8', calibriBlack12));
        doc.addCharacter(new Character('0', calibriBlack12));
        doc.addCharacter(new Character('0', calibriBlack12));

        System.out.println("contents:");
        for (Character c : doc.getCharacters()) {
            System.out.println(c);
        }

        String filename = "flyweight.txt";
        doc.saveToFile(filename);
        System.out.println("\nsaved file: " + filename);

        CharacterPropertiesFactory loadFactory = new CharacterPropertiesFactory();
        Document loaded = Document.loadFromFile(filename, loadFactory);
        System.out.println("\nloaded document contents:");
        for (Character c : loaded.getCharacters()) {
            System.out.println(c);
        }
        System.out.println("\ncache size: " + loadFactory.getCacheSize());
        System.out.println("total characters: " + loaded.getCharacters().size());
    }
}
