package com.plural.spring.fundamentals.parsers;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.PrintStream;

public class CustomSAXErrorHandler implements ErrorHandler {

    private PrintStream out;

    public CustomSAXErrorHandler(PrintStream out) {
        this.out = out;
    }

    private String getExceptionId(SAXParseException es) {
        return String.format("URI: %s, Line: %d, Description: %s", es.getSystemId(), es.getLineNumber(), es.getMessage());
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        out.println("WARNING: " + getExceptionId(exception));
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        out.println("ERROR: " + getExceptionId(exception));
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        out.println("FATAL ERROR: " + getExceptionId(exception));
    }
}
