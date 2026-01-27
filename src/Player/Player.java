package Player;

import Characters.Enemy;
import Items.Item;
import Items.Weapon;
import Locations.Location;

import java.util.ArrayList;

public class Player {

        private String name;
        private int health;
        private int maxHealth;
        private Location currentLocation;
        private Weapon equippedWeapon;
        private ArrayList<Item> inventory = new ArrayList<>();

        public Player(String name, int maxHealth) {
                this.name = name;
                this.maxHealth = maxHealth;
                this.health = 50;
        }

        public void moveTo(Location location) {}
        public void moveForward() {}
        public int attack(Enemy enemy) {
            return 0;
        }
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

        public String getName() {
                return name;
        }

        public int getHealth() {
                return health;
        }

        public void heal(int amount) {
                health += amount;
                if (health > maxHealth) {
                        health = maxHealth;
                }
        }

        public ArrayList<Item> getInventory() {
                return inventory;
        }
}


