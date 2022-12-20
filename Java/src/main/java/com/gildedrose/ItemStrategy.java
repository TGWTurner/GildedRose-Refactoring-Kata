package com.gildedrose;

import java.util.Map;

public interface ItemStrategy {
    Map<String, Integer> updateQuality(Item item);
}
