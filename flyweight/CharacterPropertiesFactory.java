package flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterPropertiesFactory {
    private Map<String, CharacterProperties> cache = new HashMap<>();

    public CharacterProperties getProperties(String font, int size, String color) {
        // create a hash key then put in a hash table
        String key = font + "+" + color + "+" + size + "TTP15";

        if (!cache.containsKey(key)) {
            cache.put(key, new CharacterProperties(font, color, size));
        }

        return cache.get(key);
    }

    public int getCacheSize() {
        return cache.size();
    }
}
