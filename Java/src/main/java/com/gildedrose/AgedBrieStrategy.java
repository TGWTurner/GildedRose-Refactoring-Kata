package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class AgedBrieStrategy implements ItemStrategy {
    @Override
    public Map<String, Integer> updateQuality(Item item) {
        Map<String, Integer> values = new HashMap<String, Integer>();
        int quality = item.quality;
        int sellIn = item.sellIn;

        if (quality < 50) {
            quality = quality + 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            if (quality < 50) {
                quality = quality + 1;
            }
        }

        values.put("quality", quality);
        values.put("sellIn", sellIn);

        return values;
    }
}
