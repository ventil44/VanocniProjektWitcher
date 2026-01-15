package Player;

import Characters.Enemy;
import Items.Item;
import Items.Weapon;
import Locations.Location;

public class Player {

        private String name;
        private int health;
        private Location currentLocation;
        private Weapon equippedWeapon;

        public Player(String name) {
                this.name = name;
        }

        public void moveTo(Location location) {}
        public void moveForward() {}
        public int attack(Enemy enemy) {
            return 0;
        }
        public void heal(int amount) {}
        public String getStatus() {
            return "";
        }
        public void die() {}
        public void takeItem(Item item) {}
        public void removeItem(Item item) {}
        public void useItem(Item item) {}
        public void equipWeapon(Weapon weapon) {}
        public int getDamage() {
            return 0;
        }
        public boolean isAlive(){
            return false;
        }


    }


