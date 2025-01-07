package commands;

import receiver.AC;

public class TurnOnAcCommand implements ICommand {

    private AC ac;

    public TurnOnAcCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOnAC();
    }

    @Override
    public void undo() {
        ac.turnOffAC();
    }
}
