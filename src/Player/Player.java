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

        public void takeItem(Item item) {
                inventory.add(item);
        }

        public String getName() {
                return name;
        }

        public int getHealth() {
                return health;
        }

        public void setHealth(int health) {
                this.health = health;
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

        public void takeDamage(int dmg) {
                health -= dmg;
                if (health < 0) {
                        health = 0;
                }
        }

        public int getDamage() {
                if (equippedWeapon != null) {
                        return equippedWeapon.getDamage();
                }
                return 5;
        }


        public int attack(Enemy enemy) {
                int damage = getDamage();
                enemy.takeDamage(damage);
                return damage;
        }


        public boolean isAlive() {
                return health > 0;
        }

        public void equipWeapon(Weapon weapon) {
                this.equippedWeapon = weapon;
        }
}


