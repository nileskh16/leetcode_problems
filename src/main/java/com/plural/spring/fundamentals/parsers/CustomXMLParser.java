package com.plural.spring.fundamentals.parsers;

import com.plural.spring.fundamentals.models.Employee;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CustomXMLParser {
    public static void parseDocument() {
        try (InputStream is = getXmlFileInputStream()) {
            CustomSAXHandler contentHandler = new CustomSAXHandler();
            SAXParserFactory factory = SAXParserFactory.newDefaultInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(contentHandler);
            reader.setErrorHandler(new CustomSAXErrorHandler(System.out));
            reader.parse(new InputSource(is));
            List<Employee> employees = contentHandler.getEmployees();
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static InputStream getXmlFileInputStream() {
        return CustomXMLParser.class.getClassLoader().getResourceAsStream("employees.xml");
    }
}
