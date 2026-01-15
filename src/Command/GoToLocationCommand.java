package Command;

import Player.Player;

public class GoToLocationCommand implements Command {

    private String locationName;

    public GoToLocationCommand(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public void execute(Player player) {
    }
}
