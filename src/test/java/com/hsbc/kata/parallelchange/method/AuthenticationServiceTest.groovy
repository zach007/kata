package com.hsbc.kata.parallelchange.method

import spock.lang.Specification

class AuthenticationServiceTest extends Specification {
    def service = new AuthenticationService()

    def "administratorIsAlwaysAuthenticated"() {
        given:
        def adminId = 12345
        when:
        def isAuthenticated = service.isAuthenticated(adminId)
        then:
        isAuthenticated == true
    }

    def "normalUserIsNotAuthenticatedInitially"() {
        def normalUserId = 111111
        expect:
        service.isAuthenticated(normalUserId) == false
    }
}
