package JVM.classLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: jiegege
 * @Date: 2022/1/10 6:33 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class CustomizedClassLoader extends ClassLoader {

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
}
