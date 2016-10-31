package nb.service;

import nb.service.impl.TestServiceImpl;
import nb.service.impl.UserServiceImpl;


public class ServiceFactory {

    private final static ServiceFactory INSTANCE = new ServiceFactory();
    private final TestService testService = new TestServiceImpl();
    private final UserService userService = new UserServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public TestService getTestService() {
        return this.testService;
    }

    public UserService getUserService() {
        return userService;
    }
}