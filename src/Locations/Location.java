package Locations;

import Characters.Enemy;
import Items.Item;

import java.util.ArrayList;


public class Location {

        private String name;
        private String description;
        private String id;
        private ArrayList<String> connectedLocations;
        private ArrayList<Item> items = new ArrayList<>();
        private ArrayList<Enemy> enemies = new ArrayList<>();
        private Enemy enemy;

        public Location(String name, String description, String id, ArrayList<String> connectedLocations) {
                this.name = name;
                this.description = description;
                this.id = id;
                this.connectedLocations = connectedLocations;
        }

        public Location(String name) {
                this.name = name;
        }

        public String getName() {
                return name;
        }

        public String getDescription() {
                return description;
        }

        public String getId() {
                return id;
        }

        public ArrayList<String> getConnectedLocations() {
                return connectedLocations;
        }

        public void addItem(Item item) {
                if (items == null) items = new ArrayList<>();
                items.add(item);
        }

        public ArrayList<Item> getItems() {
                if (items == null) items = new ArrayList<>();
                return items;
        }

        public Enemy getEnemy() {
                return enemy;
        }

        public void setEnemy(Enemy enemy) {
                this.enemy = enemy;
        }
}



