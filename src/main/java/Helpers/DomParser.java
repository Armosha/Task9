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

public class DomParser implements DataUserSource {

    public DomParser() {
    }

    @Override

    public List<DataUser> datalist() throws IOException, SAXException, ParserConfigurationException {

        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setValidating(false);
        DocumentBuilder builder = f.newDocumentBuilder();
        Document doc = builder.parse(new File(this.getClass().getClassLoader().getResource("data.xml").getPath()));
        List<DataUser> datalist = new ArrayList<DataUser>();
        NodeList nodes = doc.getElementsByTagName("account");

        for (int i = 0; i < nodes.getLength(); i++) {

            DataUser acc = new DataUser();

            Node fstNode = nodes.item(i);

            if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                Element fstElmnt = (Element) fstNode;

                String data = fstElmnt.getElementsByTagName("login").item(0).getTextContent();

                acc.setLogin(data);

                String datap = fstElmnt.getElementsByTagName("password").item(0).getTextContent();

                acc.setPassword(datap);
            }
            datalist.add(acc);

        }
        return datalist;
    }


}