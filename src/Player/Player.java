package Player;

import Characters.Enemy;
import Items.Item;
import Items.Weapon;
import Locations.Location;

import java.util.ArrayList;

/**
 * Represents users character
 * The character has a name, health and can equip weapons
 * The player can attack enemies, receive damage and heal
 * @author Denis Vesely
 */
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

        /**
         * Heals the player by a specific amount
         * Health cant exceed the max health
         * @param amount amout of HP restored
         */
        public void heal(int amount) {
                health += amount;
                if (health > maxHealth) {
                        health = maxHealth;
                }
        }

        public ArrayList<Item> getInventory() {
                return inventory;
        }

        /**
         * Reduces the player HP by a specific amount
         * Health will not drop below 0
         * @param dmg damage amount
         */
        public void takeDamage(int dmg) {
                health -= dmg;
                if (health < 0) {
                        health = 0;
                }
        }

        /**
         * Calculated the players damage
         * Default damage is 5
         * If a weapon is equipped it returns the weapons damage
         * @return
         */
        public int getDamage() {
                if (equippedWeapon != null) {
                        return equippedWeapon.getDamage();
                }
                return 5;
        }

        /**
         * Attacks an enemy and reduces its HP
         * @param enemy the enemy being attacked
         * @return the amount of damage dealt
         */
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


