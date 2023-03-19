package com.zhangeaky.minispring;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

public class ClassPathXmlResource implements Resource{

    Document document;

    Element rootElement;

    Iterator<Element> elementIterator;

    public ClassPathXmlResource(String fileName) {

        SAXReader reader = new SAXReader();
        URL resource = this.getClass().getClassLoader().getResource(fileName);

        try {
            this.document = reader.read(resource);
            this.rootElement = document.getRootElement();
            this.elementIterator = rootElement.elementIterator();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasNext() {
        return elementIterator.hasNext();
    }

    @Override
    public Object next() {
        return elementIterator.next();
    }
}
