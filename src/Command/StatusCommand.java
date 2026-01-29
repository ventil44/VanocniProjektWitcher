package Command;

import Player.Player;

public class StatusCommand implements Command {

    private final Player player;

    public StatusCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        return "HP: " + player.getHealth();
    }
}
