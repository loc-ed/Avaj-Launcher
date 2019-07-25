package simulator.vehicles;

import 	simulator.interfaces.*;


public class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) 
	{
		if (longitude < 0 && latitude < 0 && height < 0){
			System.out.println("Aircraft could not be built.");
			return null;
		}
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type.equalsIgnoreCase("Baloon")) {
			return new Baloon(name, coordinates);
		}
		else if (type.equalsIgnoreCase("Jetplane")) {
			return new JetPlane(name, coordinates);
		}
		else if (type.equalsIgnoreCase("Helicopter")) {
			return new Helicopter(name, coordinates);
		} 
		else {
			System.out.println("Invalid flyable");
			return null;
		}
	}
}