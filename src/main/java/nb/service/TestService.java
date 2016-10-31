package nb.service;


import nb.bean.entity.Questions;
import nb.service.exeption.ServiceException;

import java.util.List;

public interface TestService {

    void addQuestion(String quest, int subject, String answer, String wrongAnsw) throws ServiceException;

    List<Questions> findByTest(int testId) throws ServiceException;

    List<Questions> addTest(int subject, int numberOfTest, int amtOfTests) throws ServiceException;
}
