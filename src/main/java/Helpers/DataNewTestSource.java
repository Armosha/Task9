package Helpers;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface DataNewTestSource {

    List<DataNewTest> dataslist() throws IOException, SAXException, ParserConfigurationException;

}

