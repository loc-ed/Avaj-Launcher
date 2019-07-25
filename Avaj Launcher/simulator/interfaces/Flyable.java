package simulator.interfaces;

import simulator.*;
import simulator.vehicles.*;

public interface Flyable {

void updateConditions();
void registerTower(WeatherTower WeatherTower);
Coordinates getCoordinates();
        
}