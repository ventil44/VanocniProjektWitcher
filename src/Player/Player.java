package Player;

import Characters.Enemy;
import Items.Item;
import Items.Weapon;
import Locations.Location;

public class Player {

        private String name;
        private int health;

        public Player(String name, int health) {
                this.name = name;
                this.health = 100;
        }

        public void heal(int amount) {}
        public void die() {}
        public void equipWeapon(Weapon weapon) {}
        public int getDamage() {
            return 0;
        }
        public boolean isAlive(){
            return false;
        }

        public String getName() {
                return name;
        }

        public int getHealth() {
                return health;
        }
}


