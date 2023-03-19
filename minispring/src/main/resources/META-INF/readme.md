### day One
创建ClassPathXmlApplicationContext
1. 解读 xml 元信息 生成BeanDefinition, 
2. BeanDefinition 简单定义只包含 id 和 name
3. ClassPathXmlApplicationContext 包含解读和实例化bean的私有函数
    readXml instance 方法

### day Tow
1. 拆解 ClassPathXmlApplicationContext 过于内聚的功能。
2. 定义BeanFactory 接口， 声明registerBeanDefinition 注册bean定义功能 和 getBean 实例化bean的功能
3. 定义Resource 资源抽象 描述xml 文件资源 未来可扩展
4. 定义XmlBeanDefinitionLoader 用于解耦之前在 ClassPathXmlApplicationContext 中的加载xml bean元信息的功能