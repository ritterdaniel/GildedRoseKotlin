package com.gildedrose

class Rule(var age: ((Item) -> Int), var qualityFunction: ((Item) -> Int), var allowedQualityRange: ClosedRange<Int>) {

    fun ensureQualityLimits(quality: Int) : Int {
        return if (quality in allowedQualityRange) {
            quality
        } else if (quality < allowedQualityRange.start) {
            allowedQualityRange.start
        } else {
            allowedQualityRange.endInclusive
        }
    }

    fun quality(item: Item) : Int {
        return ensureQualityLimits(qualityFunction(item))
    }
}