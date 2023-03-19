package com.zhangeaky.ee.spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class SpringBean {

    static class yidaBeforeInstantiationBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

            System.out.println("[Before Instantiation] : " + beanName + " " + beanClass.getSimpleName());
            return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
        }

        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

            System.out.println("[After Instantiation] : " + beanName + " " + bean.getClass().getSimpleName());

            return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
        }
    }

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        beanFactory.addBeanPostProcessor(new yidaBeforeInstantiationBeanPostProcessor());

        reader.loadBeanDefinitions("classpath:/META-INF/com.zhangeaky.ee.ee.spring/com.zhangeaky.ee.ee.spring-service.xml");
        beanFactory.getBean(com.zhangeaky.se.javaBeans.person.class);

        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();


    }


}
