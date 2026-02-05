package Characters;

import Player.Player;
import Quest.Quest;

public class NPC {

        private String name;
        private String id;
        private String homeLocationId;
        private String dialog;

        public NPC(String name) {}

        public String talk() {
            return "NPC " + name + ": " + dialog;
        }


    }




