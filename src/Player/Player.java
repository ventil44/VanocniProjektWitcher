package Player;

import Characters.Enemy;
import Items.Item;
import Items.Weapon;
import Locations.Location;

public class Player {

        private String name;
        private int health;
        private int currentHealth;

        public Player(String name, int health, int currentHealth) {
                this.name = name;
                this.health = health;
                this.currentHealth = 100;
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

        public int getCurrentHealth() {
                return currentHealth;
        }

        public void setCurrentHealth(int currentHealth) {
                this.currentHealth = currentHealth;
        }
}


