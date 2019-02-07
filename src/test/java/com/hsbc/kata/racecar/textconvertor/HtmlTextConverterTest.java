package com.hsbc.kata.racecar.textconvertor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HtmlTextConverterTest {
    @Test
    public void foo() {
        HtmlTextConverter converter = new HtmlTextConverter("foo");
        assertEquals("fixme", converter.getFilename());
    }
}
