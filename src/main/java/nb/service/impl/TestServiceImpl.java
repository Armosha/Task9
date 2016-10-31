package nb.service.impl;

import nb.bean.dao.DAOFactory;
import nb.bean.dao.exeption.DAOException;
import nb.bean.entity.Questions;
import nb.service.TestService;
import nb.service.exeption.ServiceException;

import java.util.List;

public class TestServiceImpl implements TestService {

    @Override
    public List<Questions> findByTest(int testId) throws ServiceException {

        if (testId <= 0) {
            throw new ServiceException("Test ID =0. Something wrong!");
        }

        try {
            return DAOFactory.getInstance().getTestDAO().findByTest(testId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void addQuestion(String quest, int subject, String answer, String wrongAnsw) throws ServiceException {

        if (quest == null || quest.equals("") || answer == null || answer.equals("") || wrongAnsw == null
                || wrongAnsw.equals("")) {
            throw new ServiceException("Illegal parameters");
        }

        try {
            DAOFactory.getInstance().getTestDAO().addQuestion(new Questions(quest, subject, answer, wrongAnsw));
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Questions> addTest(int subject, int numberOfTest, int amtOfTests) throws ServiceException {
        if (subject <= 0 || numberOfTest <= 0 || amtOfTests <= 0) {
            throw new ServiceException(" ID =0. Something wrong!");
        }

        try {
            return DAOFactory.getInstance().getTestDAO().findForAddingTest(subject, numberOfTest, amtOfTests);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
