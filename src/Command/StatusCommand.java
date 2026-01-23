package Command;

import Player.Player;

public class StatusCommand implements Command {

    private Player player;

    public StatusCommand(Player player) {
        this.player = player;
    }

    @Override
    public String execute() {
        System.out.println("HP: " + player.getHealth());
        return "";
    }
}
