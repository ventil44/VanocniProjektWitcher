package Command;

import Characters.NPC;
import Locations.Location;
import Game.GameWorld;
import Locations.Location;

public class TalkCommand implements Command {

    private GameWorld gameWorld;
    private NPC npc;

    @Override
    public String execute() {
        Location loc = gameWorld.getCurrentLocation();
        NPC npc = loc.getNPC();

        if (npc == null) {
            return "There is no one to talk to here.";
        }

        return npc.talk();
    }
}
