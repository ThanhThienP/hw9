package flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterPropertiesFactory {
    private Map<String, CharacterProperties> cache = new HashMap<>();

    public CharacterProperties getProperties(String font, String color, int size) {
        return null;
    }

    public int getCacheSize() {
        return cache.size();
    }
}
