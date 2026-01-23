package Command;

import Player.Player;

public class StatusCommand implements Command {

    private Player p;

    @Override
    public String execute() {
        return "HP: " + p.getHealth();
    }
}
