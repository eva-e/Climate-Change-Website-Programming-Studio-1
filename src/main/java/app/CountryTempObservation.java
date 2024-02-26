// package app;

// public class CountryTempObservation {
//     // CLIMATE DATABSE
//    // LGA Code
//    private int year;

//    // LGA Name
//    private String countryCode;

//    // LGA Year
//    private int avgtemp;

//    // LGA Year
//    private int mintemp;

//  // LGA Year
//    private int maxtemp;

//    /**
//     * Create an CountryTempObservation and set the fields
//     */
//    public CountryTempObservation(int year, String countryCode, int avgtemp, int mintemp, int maxtemp) {
//       this.countryCode = countryCode;
//       this.year = year;
//       this.avgtemp = avgtemp;
//       this.mintemp = mintemp;
//       this.maxtemp = maxtemp;

//    }
   

//    public CountryTempObservation(String countryCode, int year2, double avgTemp2, double minTemp2, double maxTemp2,
//         long population) {
// }


// public String getCode() {
//       return countryCode;
//    }

//    public int getYear() {
//       return year;
//    }

//    public int getAvgTemp() {
//       return avgtemp;
//    }

//    public int getMinTemp() {
//       return mintemp;
//    }

//    public int getMaxtemp() {
//       return maxtemp;
//    }


//    public String getCountryCode() {
//       return null;
//    }


// public String getMaxTemp() {
//     return null;
// }


// public String getPopulation() {
//     return null;
// }


// }

// // public String getCountryCode() {
// //     return null;
// // }

// // public String getMaxTemp() {
// //     return null;
// // }

// // public String getPopulation() {
// //     return null;
// // }
// // }


package app;

public class CountryTempObservation {
    private int year;
    private String countryCode;
    private double avgTemp;
    private double minTemp;
    private double maxTemp;
    private long population;

    public CountryTempObservation(int year, String countryCode, double avgTemp, double minTemp, double maxTemp) {
        this.year = year;
        this.countryCode = countryCode;
        this.avgTemp = avgTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public CountryTempObservation(String countryCode, int year, double avgTemp, double minTemp, double maxTemp,
            long population) {
        this.year = year;
        this.countryCode = countryCode;
        this.avgTemp = avgTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.population = population;
    }

    public int getYear() {
        return year;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxtemp() {
        return maxTemp;
    }

    public long getPopulation() {
        return population;
    }

   
}


