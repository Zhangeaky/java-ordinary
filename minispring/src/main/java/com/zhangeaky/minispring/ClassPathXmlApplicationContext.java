package com.zhangeaky.minispring;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext {

    private List<BeanDefinition> beanDefinitions = new ArrayList<>();

    private Map<String, Object> singletons = new HashMap<>();

    public ClassPathXmlApplicationContext(String fileName) {
        readXml(fileName);
        instanceBeans();
    }

    private int readXml(String fileName) {
        SAXReader saxReader = new SAXReader();

        try {
            URL xml = this.getClass().getClassLoader().getResource(fileName);
            Document parsedDom = saxReader.read(xml);
            Element rootElement = parsedDom.getRootElement();

            for (Element element : rootElement.elements()) {
                String beanId = element.attributeValue("id");
                String beanClassName = element.attributeValue("class");
                BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);
                beanDefinitions.add(beanDefinition);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    private void instanceBeans() {

        for (BeanDefinition beanDefinition : beanDefinitions) {

            String className = beanDefinition.getClassName();
            String beanName = beanDefinition.getId();
            try {
                Object bean = Class.forName(className).newInstance();
                singletons.put(beanName, bean);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }


}
