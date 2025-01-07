package invoker;

import commands.ICommand;

import java.util.Stack;

public class Remote {

    private ICommand command;
    private Stack<ICommand> commandHistory = new Stack<>();

    public Remote() {
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        commandHistory.add(command);
    }

    public void undo() {
        if(!commandHistory.empty()) {
            var lastCommand = commandHistory.pop();
            lastCommand.undo();
        }
    }

}
