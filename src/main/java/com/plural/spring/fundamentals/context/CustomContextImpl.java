package com.plural.spring.fundamentals.context;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomContextImpl implements CustomContext {

    private final Map<String, Object> container;
    private final String filePath;
    private static final String APACHE_XML_NAMESPACE = "http://apache.org/xml/features/disallow-doctype-decl";

    public CustomContextImpl(String filePath) {
        this.filePath = filePath;
        this.container = new HashMap<>();
    }

    @Override
    public Object getBean(String beanName) {
        if (container.containsKey(beanName)) {
            return container.get(beanName);
        }
        return null;
    }

    @Override
    public void loadContext() throws Exception {
        SAXReader saxReader = new SAXReader();
        saxReader.setFeature(APACHE_XML_NAMESPACE, true);
        Document document = saxReader.read(new FileInputStream(filePath));
        if (null != document) {
            Element parentBeans = (Element) document.content().get(0);
            registerBeans(parentBeans.elements());
        }
    }

    private void registerBeans(List<Object> beanElements) throws Exception {
        for (Object beanObject : beanElements) {
            Element bean = (Element) beanObject;
            String beanName = bean.attributeValue("name");
            String beanClassName = bean.attributeValue("class");
            Figure figure = (Figure) ReflectionUtils.createInstance(beanClassName);
            if (null != figure) {
                parseProperties(figure, bean.element("properties"));
                container.put(beanName, figure);
            }
        }
    }

    private void parseProperties(Figure figure, Element properties) throws Exception {
        if (properties != null) {
            for (Object property : properties.elements()) {
                Element propElement = (Element) property;
                String propName = propElement.attributeValue("name");
                String propType = propElement.attributeValue("type");
                Object propValue = propElement.attributeValue("value");
                setProperty(figure, propName, propType, propValue);
            }
        }
    }

    private void setProperty(Figure bean, String name, String type, Object value) throws IllegalAccessException, InvocationTargetException {
        BeanUtils.setProperty(bean, name, value);
    }
}