package se.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.management.modelmbean.XMLParseException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Optional;

public class XmlParserDemo {

    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        String PATH = "/Users/kimchang/IdeaProjects/javaSELearning/src/main/java/se/xml/example/yida.xml";
        try {

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            File file = new File(PATH);
            Document document = documentBuilder.parse(file);
            System.out.println(document);

            Optional.ofNullable(document.getElementById("beans"))
                    .ifPresent(System.out::println);

            Element elementById = document.getElementById("");


        }catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (IOException | SAXException e) {
            String prefix = null;
            if ( e instanceof IOException) {
                System.out.println("IOException: " + ((IOException) e).getMessage());
            } else {
                System.out.println("SAXException: " + ((SAXException) e).getMessage());
            }
        }


    }
}
