package Command;

import Player.Player;

public class StatusCommand implements Command {

    private Player p;

    public StatusCommand(Player p) {
        this.p = p;
    }

    @Override
    public String execute() {
        System.out.println("HP: " + p.getHealth());
        return "";
    }
}
