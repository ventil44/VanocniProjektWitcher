package Command;

import Player.Player;

public class TakeCommand implements Command {

    private String itemName;

    public TakeCommand(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String execute() {
        return "";
    }
}

