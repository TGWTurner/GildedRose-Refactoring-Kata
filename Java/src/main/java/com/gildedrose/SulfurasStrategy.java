package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class SulfurasStrategy implements ItemStrategy {
    @Override
    public Map<String, Integer> updateQuality(Item item) {
        Map<String, Integer> values = new HashMap<String, Integer>();

        values.put("quality", item.quality);
        values.put("sellIn", item.sellIn);

        return values;
    }
}
