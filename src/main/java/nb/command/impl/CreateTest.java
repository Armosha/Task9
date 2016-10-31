package nb.command.impl;

import nb.bean.AddTestRequest;
import nb.bean.Request;
import nb.bean.Response;
import nb.command.Command;
import nb.command.exception.CommandException;
import nb.service.ServiceFactory;
import nb.service.TestService;
import nb.service.exeption.ServiceException;


public class CreateTest implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        AddTestRequest req = null;

        if(request instanceof AddTestRequest){
            req = (AddTestRequest)request;
        }else{
            throw new CommandException("Wrong request");
        }

        Response response = new Response();

        String quest = req.getQuest();
        int subject = req.getSubject();
        int numberOfTest = req.getnumberTest();
        int amtOfTests = req.getamtOfTests();

        TestService service = ServiceFactory.getInstance().getTestService();

        try {
            service.addTest(subject, numberOfTest, amtOfTests);
        } catch(ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
            return response;
        }

        response.setErrorStatus(false);
        response.setResultMessage("Success!");

        return response;
    }

}
