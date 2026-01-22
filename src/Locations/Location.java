package Locations;

import Characters.Enemy;
import Characters.NPC;
import Items.Item;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Location {

        private String name;
        private String description;
        private String id;
        private ArrayList<String> connectedLocations;

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
}



