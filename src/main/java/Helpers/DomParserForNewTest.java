package Helpers;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParserForNewTest implements DataNewTestSource {

    @Override

    public List<DataNewTest> dataslist() throws IOException, SAXException, ParserConfigurationException {

        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder = f.newDocumentBuilder();
        Document doc = builder.parse(new File(this.getClass().getClassLoader().getResource("datanext.xml").getPath()));
        List<DataNewTest> dataslist = new ArrayList<DataNewTest>();
        NodeList nodes = doc.getElementsByTagName("test");

        for (int i = 0; i < nodes.getLength(); i++) {

            DataNewTest test = new DataNewTest();

            Node fstNode = nodes.item(i);

            if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                Element fstElmnt = (Element) fstNode;

                String dataId = fstElmnt.getElementsByTagName("subjectId").item(0).getTextContent();
                test.setSubjectId(Integer.parseInt(dataId));

                String dataquestion = fstElmnt.getElementsByTagName("question").item(0).getTextContent();
                test.setQuestion(dataquestion);

                String dataanswer = fstElmnt.getElementsByTagName("answer").item(0).getTextContent();
                test.setAnswer(dataanswer);

                String datacommandName = fstElmnt.getElementsByTagName("CommandName").item(0).getTextContent();
                test.setCommandName(datacommandName);
            }
            dataslist.add(test);
        }
        return dataslist;
    }
}
