package nb.command.impl;

import nb.bean.ChoiceTestByNameRequest;
import nb.bean.Request;
import nb.bean.Response;
import nb.bean.ShowTestResponse;
import nb.bean.entity.Questions;
import nb.command.Command;
import nb.command.exception.CommandException;
import nb.service.ServiceFactory;
import nb.service.TestService;
import nb.service.exeption.ServiceException;

import java.util.List;

public class FindTest implements Command {

    @Override
    public Response execute(Request request) throws CommandException {
        ChoiceTestByNameRequest req = null;

        if (request instanceof ChoiceTestByNameRequest) {
            req = (ChoiceTestByNameRequest) request;
        } else {
            throw new CommandException("Wrong command");
        }

        ShowTestResponse response = new ShowTestResponse();
        List<Questions> res = null;
        TestService testService = ServiceFactory.getInstance().getTestService();

        try {
            res = testService.findByTest(req.getTestId());
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
            return response;
        }

        response.setList(res);
        response.setErrorStatus(false);
        response.setResultMessage("Success!");

        return response;
    }
}
