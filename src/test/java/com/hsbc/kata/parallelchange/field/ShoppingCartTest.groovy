package com.hsbc.kata.parallelchange.field

import spock.lang.Specification

class ShoppingCartTest extends Specification {
    def shoppingCart = new ShoppingCart()

    def "singleItem_numberOfProductsInTheCart"() {
        shoppingCart.add(10)
        expect:
        shoppingCart.numberOfProducts() == 1
    }


    def "singleItem_totalPrice"() {
        shoppingCart.add(10)
        expect:
        shoppingCart.calculateTotalPrice() == 10
    }

    def "singleItem_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100"() {
        shoppingCart.add(100)
        except:
        shoppingCart.hasDiscount() == true
    }

    def "singleItem_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100"() {
        shoppingCart.add(99)
        expect:
        shoppingCart.hasDiscount() == false
    }

}
