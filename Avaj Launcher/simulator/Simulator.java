package simulator;

import java.io.*;
//import java.util.*;
import java.lang.NullPointerException;

import simulator.interfaces.*;
import simulator.vehicles.*;

public class  Simulator {
    private static WeatherTower weatherTower = new WeatherTower();
   // private static List<Flyable> flyables = new ArrayList<>();
    public static PrintWriter printWriter = null;
    

    public static void main(String[] arg) throws InterruptedException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
            printWriter = new PrintWriter(new File("simulation_output.txt"));

            String line = reader.readLine();
            if (line != null)
            {
                //weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 1) {
                    printWriter.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    String[] inline = line.split(" ");
                    if (inline != null) {
                        Flyable flyable = AircraftFactory.newAircraft(inline[0], inline[1], 
                                            Integer.parseInt(inline[2]), Integer.parseInt(inline[3]), Integer.parseInt(inline[4]));
                        flyable.registerTower(weatherTower);
                    }
                }
                    /*
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], 
                                                                  line.split(" ")[1],
                                                                  Integer.parseInt(line.split(" ")[2]),
                                                                  Integer.parseInt(line.split(" ")[3]),
                                                                  Integer.parseInt(line.split(" ")[4]));
                    flyables.add(flyable);
                }

                for (Flyable flyable :  flyables) {
                    Flyable flyable2 = flyable;
                    flyable2.registerTower(weatherTower);
                }
                */
                while (simulations > 0) {
                    weatherTower.changeWeather();
                    simulations--;
                }
                /*
                for (int i = 1; i <= simulations; i++) {
                    weatherTower.changeWeather();
                }
                */
               System.out.println("Simulation complete") ;
            }
            reader.close();
            printWriter.close();
        }
        
        catch (FileNotFoundException e) {
            System.out.println("Could not locate file " + arg[0]);
        }
        catch (IOException e) {
            System.out.println("Error reading the file " + arg[0]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Specify simulation file");
        }
        catch (NullPointerException e) {
            System.out.println(" NullPointerException \n " + e);     
        }
        /*
        
        finally {
            Logger.getLogger().close();
        }
        */

    }
}