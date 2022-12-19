package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void testStandardItemQualityDecreasesAfterDay() {
        int expected = 5;
        Item[] items = new Item[] {
            new Item("item", 5, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        expected -= 1;

        assertEquals(expected, item.quality);
    }

    @Test
    void testStandardItemQualityDoesNotDecreaseBelowZero() {
        int expected = 1;
        Item[] items = new Item[] {
            new Item("item", 5, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        expected -= 1;
        assertEquals(expected, item.quality);

        app.updateQuality();

        assertEquals(expected, item.quality);
    }

    @Test
    void testStandardItemQualityDecreasesTwiceAfterSellInReducedToZero() {
        int expected = 5;
        Item[] items = new Item[] {
            new Item("item", 1, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        expected -= 1;
        assertEquals(expected, item.quality);

        app.updateQuality();

        expected -= 2;
        assertEquals(expected, item.quality);
    }

    @Test
    void testAgedBrieIncreasesInQualityAfterDay() {
        int expected = 5;
        Item[] items = new Item[] {
            new Item("Aged Brie", 5, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        expected += 1;
        assertEquals(expected, item.quality);
    }

    @Test
    void testQualityCannotIncreaseOver50() {
        int expected = 49;
        Item[] items = new Item[] {
            new Item("Aged Brie", 5, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        expected += 1;
        assertEquals(expected, item.quality);

        app.updateQuality();

        assertEquals(expected, item.quality);
    }

    @Test
    void testSulfurasQualityDoesntDecrease() {
        int expected = 80;
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 5, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        assertEquals(expected, item.quality);
    }

    @Test
    void testSulfurasQualityDoesntDecreaseAfterSellInReducedToZero() {
        int expected = 80;
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 1, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        assertEquals(expected, item.quality);

        app.updateQuality();

        assertEquals(expected, item.quality);
    }


    @Test
    void testBackstagePassesIncreaseInQualityWithMoreThan10DaysSellIn() {
        int expected = 5;
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 12, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        expected += 1;
        assertEquals(expected, item.quality);
    }

    @Test
    void testBackstagePassesChangesToIncreaseQualityByTwoWithTenDaysLeft() {
        int expected = 5;
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 11, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        expected += 1;
        assertEquals(expected, item.quality);

        app.updateQuality();

        expected += 2;
        assertEquals(expected, item.quality);
    }

    @ParameterizedTest
    @ValueSource(ints = {10,9,8,7,6})
    void testBackstagePassesIncreaseQualityByTwoBetweenSixAndTenSellInDays(int sellIn) {
        int expected = 5;
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        expected += 2;
        assertEquals(expected, item.quality);
    }

    @Test
    void testBackstagePassesChangesToIncreaseQualityByThreeWithFiveDaysLeft() {
        int expected = 5;
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        expected += 2;
        assertEquals(expected, item.quality);

        app.updateQuality();

        expected += 3;
        assertEquals(expected, item.quality);
    }

    @ParameterizedTest
    @ValueSource(ints = {5,4,3,2,1})
    void testBackstagePassesIncreaseQualityByFiveWithLessThanFiveSellInDays(int sellIn) {
        int expected = 5;
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        expected += 3;
        assertEquals(expected, item.quality);
    }

    @Test
    void testBackstagePassesQualityZeroOnZeroSellInDays() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();
        assertEquals(0, item.quality);
    }

    @Test
    void testConjuredItemDecreasesQualityTwice() {
        int expected = 5;
        Item[] items = new Item[] {
            new Item("Conjured", 5, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        expected -= 2;
        assertEquals(expected, item.quality);
    }

    @Test
    void testConjuredItemDecreasesQualityFourTimesOnZeroSellInDays() {
        int expected = 10;
        Item[] items = new Item[] {
            new Item("Conjured", 1, expected)
        };
        GildedRose app = new GildedRose(items);
        SuperItem item = app.getItems().get(0);

        app.updateQuality();

        expected -= 2;
        assertEquals(expected, item.quality);

        app.updateQuality();

        expected -= 4;
        assertEquals(expected, item.quality);
    }
}
