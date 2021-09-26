package com.gildedrose

class RuleSet {

    val itemRules = hashMapOf(
        ItemName.SULFURAS.value to Rule({item : Item -> item.sellIn}, {_: Item -> 80}, 80..80),
        ItemName.AGED_BRIE.value to Rule({item : Item -> item.sellIn - 1},
            {item : Item -> if (item.sellIn >= 0) {
                item.quality + 1
            } else {
                item.quality + 2
            }},
            0..50
        ),
        ItemName.BACKSTAGE_PASSES.value to Rule({item : Item -> item.sellIn - 1},
            {item : Item -> if (item.sellIn < 0) {
                0
            } else if (item.sellIn <= 5) {
                item.quality + 3
            } else if (item.sellIn <= 10) {
                item.quality + 2
            } else {
                item.quality + 1
            }},
            0..50
        ),
        ItemName.CONJURED.value to Rule({item : Item -> item.sellIn - 1},
            {item : Item -> if (item.sellIn >= 0) {
                item.quality - 2
            } else {
                item.quality - 4
            }},
            0..50
        ),        ItemName.GENERIC.value to Rule({item : Item -> item.sellIn - 1},
            {item : Item -> if (item.sellIn >= 0) {
                item.quality - 1
            } else {
                item.quality - 2
            }},
            0..50
        ),

    )

    fun getRule(itemName: String) : Rule {
        return if (itemRules.containsKey(itemName)) itemRules[itemName]!! else itemRules[ItemName.GENERIC.value]!!
    }
}