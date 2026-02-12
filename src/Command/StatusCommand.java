package Command;

import Player.Player;

/**
 * Command that displays the players HP
 * @author Denis Vesely
 */
public class StatusCommand implements Command {

    private final Player player;


    public StatusCommand(Player player) {
        this.player = player;
    }

    /**
     * Executes status command
     * @return players current HP
     */
    @Override
    public String execute() {
        return "HP: " + player.getHealth();
    }
}
