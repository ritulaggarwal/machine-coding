package commands;

import receiver.AC;

public class TurnOffAcCommand implements ICommand {

    private AC ac;

    public TurnOffAcCommand(AC ac) {
        this.ac = ac;
    }


    @Override
    public void execute() {
        ac.turnOffAC();
    }

    @Override
    public void undo() {
        ac.turnOnAC();
    }
}
