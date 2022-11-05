package ee.spring.resource;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class demo1 {

    public static void main(String[] args) throws Exception{

        System.out.println("Resource 资源抽象测试");
        ResourceLoader loader = new DefaultResourceLoader();
        //ResourceLoader classPathLoader = new ClassPathResource()

        Resource resource = loader.getResource("classpath:/example.properties");
        System.out.println(resource);
        System.out.println("Resource#isExists()" + resource.exists());
        System.out.println("desc: " + resource.getDescription());
        System.out.println(" " + resource.getFilename());
        File file = resource.getFile();
        file.exists();
        String path = file.getPath();
        System.out.println("PATH: " + path);


        InputStream inputStream = resource.getInputStream();

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }




    }
}
