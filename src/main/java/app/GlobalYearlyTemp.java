package app;

public class GlobalYearlyTemp {
    private int year;
    private double avgTemp;
    private double minTemp;
    private double maxTemp;


    public GlobalYearlyTemp(int year, double avgTemp, double minTemp, double maxTemp) {
        this.year = year;
        this.avgTemp = avgTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public int getYear() {
        return year;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }


   
}


