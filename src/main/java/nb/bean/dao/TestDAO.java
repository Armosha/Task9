package nb.bean.dao;

import nb.bean.dao.exeption.DAOException;
import nb.bean.entity.Questions;
import java.util.List;



public interface TestDAO {

    void addQuestion(Questions questions) throws DAOException;
    List<Questions> findByTest(int id) throws DAOException;
    List<Questions> findForAddingTest(int subject, int numberOfTest, int amtOfTests) throws DAOException;

}
