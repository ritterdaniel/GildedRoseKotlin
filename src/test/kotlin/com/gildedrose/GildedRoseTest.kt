package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class GildedRoseTest {

    @ParameterizedTest
    @MethodSource("itemSellin")
    fun `Expected Sellin of item`(expected: Number, item: Item) {
        val app = GildedRose(arrayOf(item), RuleSet())
        app.ageItems()
        assertEquals(expected, item.sellIn)
    }

    @ParameterizedTest
    @MethodSource("itemQualities")
    fun `Expected Quality of item`(expected: Number, item: Item) {
        val app = GildedRose(arrayOf(item), RuleSet())
        app.ageItems()
        assertEquals(expected, item.quality)
    }

    companion object {
        @JvmStatic
        fun itemQualities(): Stream<Arguments> = Stream.of(
            Arguments.of(1, Item(ItemName.GENERIC.value, 1, 2)),
            Arguments.of(2, Item(ItemName.GENERIC.value, 0, 4)),
            Arguments.of(2, Item(ItemName.AGED_BRIE.value, 1, 1)),
            Arguments.of(4, Item(ItemName.AGED_BRIE.value, 0, 2)),
            Arguments.of(50, Item(ItemName.AGED_BRIE.value, 1, 50)),
            Arguments.of(50, Item(ItemName.AGED_BRIE.value, 0, 50)),
            Arguments.of(80, Item(ItemName.SULFURAS.value, 1, 80)),
            Arguments.of(80, Item(ItemName.SULFURAS.value, 0, 80)),
            Arguments.of(50, Item(ItemName.BACKSTAGE_PASSES.value, 15, 50)),
            Arguments.of(16, Item(ItemName.BACKSTAGE_PASSES.value, 15, 15)),
            Arguments.of(17, Item(ItemName.BACKSTAGE_PASSES.value, 10, 15)),
            Arguments.of(18, Item(ItemName.BACKSTAGE_PASSES.value, 5, 15)),
            Arguments.of(0, Item(ItemName.BACKSTAGE_PASSES.value, 0, 15)),
            Arguments.of(13, Item(ItemName.CONJURED.value, 1, 15)),
            Arguments.of(11, Item(ItemName.CONJURED.value, 0, 15)),
            Arguments.of(0, Item(ItemName.CONJURED.value, 1, 1)),
            Arguments.of(0, Item(ItemName.CONJURED.value, 0, 1)),
        )

        @JvmStatic
        fun itemSellin(): Stream<Arguments> = Stream.of(
            Arguments.of(0, Item(ItemName.GENERIC.value, 1, 1)),
            Arguments.of(-1, Item(ItemName.GENERIC.value, 0, 2)),
            Arguments.of(1, Item(ItemName.SULFURAS.value, 1, 80)),
            Arguments.of(0, Item(ItemName.SULFURAS.value, 0, 80)),
        )

    }
}


