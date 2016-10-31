package nb.command.impl;

import nb.bean.AddTestQuestionsRequest;
import nb.bean.Request;
import nb.bean.Response;
import nb.command.Command;
import nb.command.exception.CommandException;
import nb.service.ServiceFactory;
import nb.service.TestService;
import nb.service.exeption.ServiceException;

public class AddNewQuest implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        AddTestQuestionsRequest req = null;

        if(request instanceof AddTestQuestionsRequest){
            req = (AddTestQuestionsRequest)request;
        }else{
            throw new CommandException("Wrong request");
        }

        Response response = new Response();

        String quest = req.getQuest();
        String answer = req.getAnswer();
        String wrong = req.getWrong();
        int sub = req.getSubject();

        TestService service = ServiceFactory.getInstance().getTestService();

        try {
            service.addQuestion(quest, sub, answer, wrong);
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
            return response;
        }

        response.setErrorStatus(false);
        response.setResultMessage("Success!");

        return response;
    }

}

