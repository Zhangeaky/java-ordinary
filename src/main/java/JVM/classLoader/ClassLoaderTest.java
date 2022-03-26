package JVM.classLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 双亲委派机制 为了安全
 * 启动类加载器： JAVA_HOME/jre                       /lib/rt.jar (父)
 * 扩展类加载器： JAVA_HOME/jre/lib/ext/*.jar (母)
 * Application类加载器： 加载classpath中的
 */
class classLoaderDemo {
    public static void main(String[] args) {
        String classpath = System.getProperty("classpath");
        System.out.println(classpath);
    }
}

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{

        ClassLoader loader = new ClassLoader() {

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String token = ".class";
                    String filename = name.substring(name.lastIndexOf(".")+1)
                            + token;
                    InputStream inputStream = getClass().getResourceAsStream(filename);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[inputStream.available()];
                    inputStream.read(b);
                    return defineClass(name, b, 0, b.length);


                }catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };

        tool too = new tool();
        Object ob = loader.loadClass("JVM.classLoader.tool").newInstance();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(ob.getClass().getClassLoader());
        System.out.println(ob.getClass().getClassLoader().getParent().getParent());
        System.out.println(ob);
        System.out.println(ob instanceof tool);

        System.out.println("------");

        System.out.println(too);
    }

    static class test {
        public static void main(String[] args) throws ClassNotFoundException {

            Class<?> aClass = Class.forName("java.lang.String");
            System.out.println(aClass);
            Class<?> aClass1 = Thread.currentThread().getContextClassLoader().loadClass("java.lang.String");
            System.out.println("是否相等：" + (aClass1 == aClass));

            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            System.out.println(systemClassLoader);
            System.out.println("两个类加载器是否相等： " + (systemClassLoader == Thread.currentThread().getContextClassLoader()));
        }
    }



}
