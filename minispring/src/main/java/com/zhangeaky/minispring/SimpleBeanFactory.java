package com.zhangeaky.minispring;

import java.util.*;

public class SimpleBeanFactory implements BeanFactory{

    private List<BeanDefinition> beanDefinitions = new ArrayList<>();

    private List<String> beanNames = new ArrayList<>();

    private Map<String, Object> singletons = new HashMap<>();

    @Override
    public Object getBean(String beanName) {

        Object bean = singletons.get(beanName);

        if (Objects.isNull(bean)) {
            int i = beanNames.indexOf(beanName);
            if (i < -1) {
                throw new BeansException("没有注册BeanDefinition信息");
            }

            BeanDefinition beanDefinition = beanDefinitions.get(i);

            try {
                bean = Class.forName(beanDefinition.getClassName()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            singletons.put(beanName, bean);
        }

        return bean;
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        beanDefinitions.add(beanDefinition);
        beanNames.add(beanDefinition.getId());
    }
}
