package Command;

import Player.Player;

public class StatusCommand implements Command {

    private Player p;

    @Override
    public String execute() {
        return Integer.toString(p.getHealth());
    }
}
