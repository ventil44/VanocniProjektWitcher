package Command;

import Player.Player;

public class UseCommand implements Command {

    private String itemName;

    public UseCommand(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String execute() {
        return "";
    }
}