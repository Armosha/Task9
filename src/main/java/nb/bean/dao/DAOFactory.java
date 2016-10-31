package nb.bean.dao;


import nb.bean.dao.impl.TestDAOImpl;
import nb.bean.dao.impl.UserDAOImpl;

public class DAOFactory {

    private final static DAOFactory INSTANCE = new DAOFactory();

    private final TestDAO TestDAO = new TestDAOImpl();
    private final UserDAO userDAO = new UserDAOImpl();

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public TestDAO getTestDAO() {
        return TestDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}