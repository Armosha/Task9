package Helpers;


import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface DataUserSource {

    List<DataUser> datalist() throws IOException, SAXException, ParserConfigurationException;
}
