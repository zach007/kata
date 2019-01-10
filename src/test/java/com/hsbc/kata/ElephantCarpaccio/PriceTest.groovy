package com.hsbc.kata.ElephantCarpaccio

import spock.lang.Specification
import spock.lang.Unroll

class PriceTest extends Specification {
    def price = new Price()

    def "return return total price after given a discount rate and tax rate"() {
        when: "total items"
        and: "price per items"
        and: "given state code"
        then: "should return finalPrice after all kind of tax"
        price.getTotalPrice(1, 12.32, "UT") == finalPrice
        where:
        _ || finalPrice
        _ || 0
    }

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
        5000       || 5000 - (5000 * 0.05)
    }
}
