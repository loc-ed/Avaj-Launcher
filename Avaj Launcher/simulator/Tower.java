package simulator;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import simulator.interfaces.*;

public class Tower {
   private List<Flyable> observers = new CopyOnWriteArrayList<Flyable>(); 

   public void  register(Flyable flyable) {
        if(!observers.contains(flyable)) {
            observers.add(flyable);
        }
   }

   public void unregister(Flyable flyable) {
        if (observers.contains(flyable)) {
            observers.remove(flyable);
        }
   }

   protected  void conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
            if (flyable.getCoordinates().getHeight() <= 0) {
                unregister(flyable);
            }
        }
   }
}
