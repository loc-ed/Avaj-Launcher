package simulator.vehicles;

import simulator.interfaces.*;
import simulator.*;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
            super(name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN" :
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 2,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 4);
                Simulator.printWriter.println("Baloon#" + this.name + "(" + this.id + "): Wow! You can see my house from here.");
                break;
            case "RAIN" :
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 5);
                Simulator.printWriter.println("Baloon#" + this.name + "(" + this.id + "): Don't suppose anyone brought an umbrella ?");
                break;
            case "FOG" :
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 3);
                Simulator.printWriter.println("Baloon#" + this.name + "(" + this.id + "): Can't see shite in all this fog.");
                break;
            case "SNOW" :
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 15);
                Simulator.printWriter.println("Baloon#" + this.name + "(" + this.id + "): It's snowing. We're gonna crash! ...very slowly.");
                break;
        }
        if (this.coordinates.getHeight() == 0){
            Simulator.printWriter.println("Baloon#" + this.name + "(" + this.id + ") landing.");
            this.weatherTower.unregister(this);
            Simulator.printWriter.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printWriter.println("Tower says: " + this.name + "#" + "(" + this.id + ") registered to weather tower");
    }
}