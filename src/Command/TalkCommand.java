package Command;

import Player.Player;

public class TalkCommand implements Command {

    private String npcName;

    public TalkCommand(String npcName) {
        this.npcName = npcName;
    }

    @Override
    public void execute(Player player) {}
}
