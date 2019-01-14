package com.hsbc.kata.ElephantCarpaccio

import spock.lang.Specification
import spock.lang.Unroll

class PriceTest extends Specification {
    def price = new Price()

    //todo try to understand more about the business to create test case
    def "return return total price after given a discount rate and tax rate"() {
        when: "total items"
        and: "price per items"
        and: "given state code"
        then: "should return finalPrice after all kind of tax"
        price.getTotalPrice(totalItems, pricePerItem, stateSode) == finalPrice
        where:
        totalItems | pricePerItem | stateSode || finalPrice
        0          | 0            | "UT"      || 0
        1000       | 2.19         | "UT"      || 1978.78545
    }

    //todo refactor code
    @Unroll
    def "will return #discoutPrice when match the #orderValue"() {
        expect:
        price.getDiscountValue(orderValue) == discoutPrice
        where:
        orderValue || discoutPrice
        -1         || 0
        0          || 0
        1.23       || 1.23
        1000       || 1000 - (1000 * 0.03)
        2000       || 2000 - (2000 * 0.03)
        5000       || 5000 - (5000 * 0.05)
    }

    @Unroll
    def "will return #statePrice when give a #discountPrice and #stateRate"() {
        expect:
        price.getStatePrice(discountPrice, stateRate) == statePrice
        where:
        discountPrice | stateRate || statePrice
        1000          | "UT"      || 1000 - (1000 * 0.0685)
        1000          | "NV"      || 1000 - (1000 * 0.0800)
        1000          | "TX"      || 1000 - (1000 * 0.0625)
        1000          | "AL"      || 1000 - (1000 * 0.0400)
        1000          | "CA"      || 1000 - (1000 * 0.0825)
        1000          | "NONE"    || 1000
    }

    @Unroll
    def "should return #itemTotalPrice when buy #itemCount of item per #itemPrice"() {
        expect:
        price.getInitPrice(itemCount, itemPrice) == itemTotalPrice
        where:
        itemCount | itemPrice || itemTotalPrice
        10        | 20.12     || 10 * 20.12
    }
}
