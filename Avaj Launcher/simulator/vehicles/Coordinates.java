package simulator.vehicles;

public class  Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height)
    {
        if (longitude < 0) {
            this.longitude = 0;
        }
        else if (latitude < 0) {
            this.latitude = 0;
        }
        else if (height >= 100) {
            this.height = 100;
        }
        else if (height < 0) {
            this.height = 0;
        }
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }
    
    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }
}