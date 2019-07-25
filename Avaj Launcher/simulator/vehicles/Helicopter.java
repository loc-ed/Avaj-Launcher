package simulator.vehicles;

import simulator.interfaces.*;
import simulator.*;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN" :
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 10,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 2);
                Simulator.printWriter.println("Helicopter#" + this.name + "(" + this.id + "): Have some kebab, I made it on the dashboard.");
                break;
            case "RAIN" :
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 5,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 0);
                Simulator.printWriter.println("Helicopter#" + this.name + "(" + this.id + "): Strap in ,folks. It gonna be a bumpy ride.");
                break;
            case "FOG" :
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 1,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() + 0);
                Simulator.printWriter.println("Helicopter#" + this.name + "(" + this.id + "): Oh damn ! I think we just hit something!");
                break;
            case "SNOW" :
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 12);
                Simulator.printWriter.println("Helicopter#" + this.name + "(" + this.id + "):  Looks like its going to be a white Christmas .");
                break;
        }
        if (this.coordinates.getHeight() == 0){
            Simulator.printWriter.println("Helicopter#" + this.name + "(" + this.id + ") landing.");
            this.weatherTower.unregister(this);
            Simulator.printWriter.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printWriter.println("Tower says: " + this.name + "#" + "(" + this.id + ") registered to weather tower");
    }

}