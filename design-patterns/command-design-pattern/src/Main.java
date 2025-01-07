import commands.TurnOnAcCommand;
import invoker.Remote;
import receiver.AC;

public class Main {
    public static void main(String[] args) {

        AC ac = new AC();
        Remote remote = new Remote();
        remote.setCommand(new TurnOnAcCommand(ac));
        remote.pressButton();
        remote.undo();

    }
}