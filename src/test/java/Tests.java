import Helpers.TutData;
import nb.bean.AddTestQuestionsRequest;
import nb.bean.Response;
import nb.bean.dao.DAOFactory;
import nb.bean.dao.exeption.DAOException;
import nb.controller.Controller;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Tests {

    @Test(dataProvider = "datauser", dataProviderClass = TutData.class)
    public void checkAutorisation(String login, String password) throws DAOException, SAXException, IOException {
        boolean actual = DAOFactory.getInstance().getUserDAO().registration(login, password);
        Assert.assertEquals(actual, true);
    }

    @Test(dataProvider = "newtest", dataProviderClass = TutData.class)
    public void checkNewTestCreation(int subjectId, String question, String answer, String commandName) throws DAOException, SAXException, IOException {
        Response response = new Response();
        DAOFactory.getInstance().getTestDAO();
        Controller controller = new Controller();
        AddTestQuestionsRequest request = new AddTestQuestionsRequest();
        request.setAnswer(answer);
        request.setQuest(question);
        request.setSubject(subjectId);
        request.setCommandName(commandName);
        response = controller.doRequest(request);
        Assert.assertEquals(response.isErrorStatus(), false);
    }

}
