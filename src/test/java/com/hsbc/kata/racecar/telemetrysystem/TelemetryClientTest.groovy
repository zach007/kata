package com.hsbc.kata.racecar.telemetrysystem

import spock.lang.Specification

/*
todo write test case for the telemetryClient first
todo and then write test case for TelemetryDiagnosticControls , mock telemetryClient.
* */

class TelemetryClientTest extends Specification {
    def telemetryClient = new TelemetryClient()

    def "should throw error when connectionString is null or empty"() {
        when:
        telemetryClient.connect(connectionString)
        then:
        thrown IllegalArgumentException
        where:
        connectionString | _
        null             | _
        ""               | _
    }

    //todo how to test a random number generation
    def "should return boolean when connectionString is not null or empty"() {
        when:
        telemetryClient.connect("why this happen")
        then:
        telemetryClient.onlineStatus == true
    }

    def "should return false when disconnect"() {
        when:
        telemetryClient.disconnect()
        then:
        telemetryClient.onlineStatus == false
    }

    def "should throw exception when message is null or empty"() {
        when:
        telemetryClient.send(message)
        then:
        thrown IllegalArgumentException
        where:
        message | _
        null    | _
        ""      | _
    }

    def "should return message when send 'AT#UD' "() {
        when:
        telemetryClient.send("AT#UD")
        then:
        telemetryClient.diagnosticMessageResult.length() > 0
    }

    def "should return empty message when not send 'AT#UD'"() {
        when:
        telemetryClient.send("other parameter")
        then:
        telemetryClient.diagnosticMessageResult == ""
    }

    def "should return number when diagnosticMessageResult is null or empty"() {
        when:
        def result = telemetryClient.receive(diagnosticMessageResult)
        then:
        result.matches("[0-9]+")
        and:
        result.length() > 0
        where:
        diagnosticMessageResult | _
        null                    | _
        ""                      | _
    }

    def "should return finalMessage when diagnosticMessageResult is not null or empty"() {
        when:
        def diagnosticMessageResult = "test case"
        def result = telemetryClient.receive(diagnosticMessageResult)
        then:
        result == diagnosticMessageResult
        and:
        telemetryClient.diagnosticMessageResult == ""
    }

}
