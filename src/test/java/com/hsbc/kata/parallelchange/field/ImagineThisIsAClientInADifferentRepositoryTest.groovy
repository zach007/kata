package com.hsbc.kata.parallelchange.field

import spock.lang.Specification

class ImagineThisIsAClientInADifferentRepositoryTest extends Specification {
    def "singleItem_numberOfProductsInTheCart"() {
        def client = new ImagineThisIsAClientInADifferentRepository()
        expect:
        "Total price is 50 euro" == client.formattedTotalPrice(50)
    }
}
