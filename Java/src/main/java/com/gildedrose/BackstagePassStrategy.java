package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

public class BackstagePassStrategy implements ItemStrategy {
    @Override
    public Map<String, Integer> updateQuality(Item item) {
        Map<String, Integer> values = new HashMap<String, Integer>();
        int quality = item.quality;
        int sellIn = item.sellIn;

        if (quality < 50) {
            if (quality < 50) {
                quality = quality + 1;
            }

            if (sellIn < 11) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }

            if (sellIn < 6) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }

        sellIn = sellIn - 1;

        if (sellIn < 0) {
            quality = 0;
        }

        values.put("quality", quality);
        values.put("sellIn", sellIn);

        return values;
    }
}
