package com.gildedrose

class GildedRose(var items: Array<Item>, var ruleSet: RuleSet) {

    fun ageItems() {
        items.forEach { item ->
            val rule = ruleSet.getRule(item.name)
            item.sellIn = rule.age(item)
            item.quality = rule.quality(item)
        }
    }

}

