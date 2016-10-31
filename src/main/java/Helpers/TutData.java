package Helpers;

import org.testng.annotations.DataProvider;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class TutData {
    @DataProvider(name = "datauser")
    public static Object[][] user() throws IOException, ParserConfigurationException, SAXException {
        DomParser pars = new DomParser();
        List<DataUser> datalist = pars.datalist();
        Object[][] accs = new Object[datalist.size()][];
        for (int i = 0; i < datalist.size(); i++) {
            accs[i] = new Object[1];
            accs[i][0] = datalist.get(i);
        }
        return accs;
    }

    @DataProvider(name = "newtest")
    public static Object[][] newtest() throws IOException, ParserConfigurationException, SAXException {
        DomParserForNewTest pars = new DomParserForNewTest();
        List<DataNewTest> dataslist = pars.dataslist();
        Object[][] test = new Object[dataslist.size()][];
        for (int i = 0; i < dataslist.size(); i++) {
            test[i] = new Object[1];
            test[i][0] = dataslist.get(i);
        }
        return test;
    }

}
