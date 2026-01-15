package Locations;

import Characters.Enemy;
import Characters.NPC;
import Items.Item;

public class Location {

        private String name;
        private String description;

        public Location(String name) {
                this.name = name;
        }

        public void addNeighbor(Location location) {}
        public Location getNeighbor(String name) {
            return null;
        }

        public void addNPC(NPC npc) {}
        public void addEnemy(Enemy enemy) {}
        public void addItem(Item item) {}
    }



