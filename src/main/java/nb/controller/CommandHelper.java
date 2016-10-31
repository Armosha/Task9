package nb.controller;

import nb.command.Command;
import nb.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {

    private Map<String, Command> commands = new HashMap<String, Command>();

    public CommandHelper() {
        commands.put("ADD_NEW_QUEST", new AddNewQuest());
        commands.put("ADD_NEW_TEST", new CreateTest());
        commands.put("FIND_TEST", new FindTest());
        commands.put("AUTHENTICATION", new Authentication());
        commands.put("REGISTRATION", new Registration());
    }

    public Command getCommand(String commandName) {
        Command command;
        command = commands.get(commandName);
        return command;
    }
}