package standardEdition.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Author: jiegege
 * @Date: 2022/1/31 3:46 下午
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class PathAndFilesTest {

    static public final String workPath = "/Users/kimchang/temp/one";


    static class PathTest {


        public static void main(String[] args) {

            String workPath = PathAndFilesTest.workPath;

            Path path = Paths.get(workPath);

            Path parentPath = path.getParent();

            File file = path.toFile();

            Path path1 = file.toPath();

            System.out.println("file under " + path + path1);

            System.out.println("parent path of " + workPath + " is " + parentPath);



            System.out.println("----");

            Path fd = path.resolve("fd");

            Path singblingPath = path.resolveSibling("two");

            //以 path为 基准 产生 相对 目录
            Path relativizePath = path.relativize(singblingPath);

            Path normalizePath = relativizePath.normalize();

            System.out.println("normalize : " + normalizePath);

            Path abs = relativizePath.toAbsolutePath();

            System.out.println(abs);


            //System.out.println(relativize);
            //System.out.println(singblingPath);

            System.out.println(path.toString());


        }
    }


    static class FilesTest {

        public static void main(String[] args) {

            Path path = Paths.get(PathAndFilesTest.workPath);

            System.out.println(path);
            Path filePath = path.resolve("readme.txt");

            try {
                List<String> strings = Files.readAllLines(filePath);
                for (String ele:strings
                     ) {
                    System.out.println(ele);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Files.write(filePath, )


        }
    }
}
