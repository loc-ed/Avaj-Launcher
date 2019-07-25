package simulator.vehicles;

import simulator.interfaces.*;
import simulator.*;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN" :
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 10,
                    coordinates.getHeight() + 2);
                Simulator.printWriter.println("JetPlane#" + this.name + "(" + this.id + "): Nothing but blue skies . BLUE SKIES !!!");
                break;
            case "RAIN" :
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 5,
                    coordinates.getHeight() + 0);
                Simulator.printWriter.println("JetPlane#" + this.name + "(" + this.id + "): Looks like we entering a storm. Secure the president!");
                break;
            case "FOG" :
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 1,
                    coordinates.getHeight() + 0);
                Simulator.printWriter.println("JetPlane#" + this.name + "(" + this.id + "): What is that ? ...it couldn't be...[inaudible]...HELP!!!");
                break;
            case "SNOW" :
                this.coordinates = new Coordinates(
                    coordinates.getLongitude() + 0,
                    coordinates.getLatitude() + 0,
                    coordinates.getHeight() - 7);
                Simulator.printWriter.println("JetPlane#" + this.name + "(" + this.id + "):  Can we get someon eout there to scrape the ice from the windscreen.");
                break;
        }
        if (this.coordinates.getHeight() == 0){
            Simulator.printWriter.println("JetPlane#" + this.name + "(" + this.id + ") landing.");
            this.weatherTower.unregister(this);
            Simulator.printWriter.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Simulator.printWriter.println("Tower says: " + this.name + "#" + "(" + this.id + ") registered to weather tower");
    }
}