package com.plural.spring.fundamentals.parsers;

import com.plural.spring.fundamentals.constants.AppConstants;
import com.plural.spring.fundamentals.models.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CustomSAXHandler extends DefaultHandler {

    private final StringBuilder currentValue = new StringBuilder();
    private final List<Employee> employees = new ArrayList<>();
    private Employee currentEmployee;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Document started");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Document finished");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentValue.setLength(0);
        if (qName.equalsIgnoreCase(AppConstants.EMPLOYEE_TAG)) {
            currentEmployee = new Employee();
            currentEmployee.setId(Integer.parseInt(attributes.getValue(AppConstants.ID_ATT)));
        }
        if (qName.equalsIgnoreCase(AppConstants.SALARY_TAG)) {
            currentEmployee.setCurrency(attributes.getValue(AppConstants.CURRENCY_ATT));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case AppConstants.AGE_TAG:
                currentEmployee.setAge(Integer.parseInt(currentValue.toString()));
                break;
            case AppConstants.NAME_TAG:
                currentEmployee.setName(currentValue.toString());
                break;
            case AppConstants.SALARY_TAG:
                currentEmployee.setSalary(Double.parseDouble(currentValue.toString()));
                break;
            case AppConstants.ROLE_TAG:
                currentEmployee.setRole(currentValue.toString());
                break;
            case AppConstants.EMPLOYEE_TAG:
                employees.add(currentEmployee);
                break;
            default:
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(ch, start, length);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
