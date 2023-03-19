package com.zhangeaky.minispring;

public interface BeanFactory {

    Object getBean(String beanName);

    void registerBeanDefinition(BeanDefinition beanDefinition);

}
