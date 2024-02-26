package app;

import java.util.ArrayList;

import kotlin.contracts.Returns;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;

/**
 * Class for Managing the JDBC Connection to a SQLLite Database.
 * Allows SQL queries to be used with the SQLLite Databse in Java.
 *
 * @author Timothy Wiley, 2023. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
// public class JDBCConnection {

//     // Name of database file (contained in database folder)
//     public static final String DATABASE = "jdbc:sqlite:database/ctg.db";
//     // public static final String DATABASE = "jdbc:sqlite:database/climate.db";

//     //This creates a JDBC Object so we can keep talking to the database

//     public JDBCConnection() {
//         System.out.println("Created JDBC Connection Object");
//     }

    /**
     * Get all of the LGAs in the database.
     * @return
     *    Returns an ArrayList of LGA objects
     */
    // public ArrayList<LGA> getLGAs2016() {
//         // Create the ArrayList of LGA objects to return
//         ArrayList<LGA> lgas = new ArrayList<LGA>();

//         // Setup the variable for the JDBC connection
//         Connection connection = null;

//         try {
//             // Connect to JDBC data base
//             connection = DriverManager.getConnection(DATABASE);

//             // Prepare a new SQL Query & Set a timeout
//             Statement statement = connection.createStatement();
//             statement.setQueryTimeout(30);

//             // The Query
//             String query = "SELECT * FROM LGA WHERE year='2016'";
            
//             // Get Result
//             ResultSet results = statement.executeQuery(query);

//             // Process all of the results
//             while (results.next()) {
//                 // Lookup the columns we need
//                 int code     = results.getInt("code");
//                 String name  = results.getString("name");

//                 // Create a LGA Object
//                 LGA lga = new LGA(code, name, 2016);

//                 // Add the lga object to the array
//                 lgas.add(lga);
//             }

//             // Close the statement because we are done with it
//             statement.close();
//         } catch (SQLException e) {
//             // If there is an error, lets just pring the error
//             System.err.println(e.getMessage());
//         } finally {
//             // Safety code to cleanup
//             try {
//                 if (connection != null) {
//                     connection.close();
//                 }
//             } catch (SQLException e) {
//                 // connection close failed.
//                 System.err.println(e.getMessage());
//             }
//         }

//         // Finally we return all of the lga
//         return lgas;
//     }
// }


public class JDBCConnection {

//     // Name of database file (contained in database folder)
//     public static final String DATABASE = "jdbc:sqlite:database/ctg.db";
    public static final String DATABASE = "jdbc:sqlite:database/climate.db";

//     //This creates a JDBC Object so we can keep talking to the database

    public JDBCConnection() {
        System.out.println("Created JDBC Connection Object");
    }

// NEW CLIMATE DATABASE
/**
 * Get all of the Country in the database.
 * @return
 *    Returns an ArrayList of Country objects
 */
public ArrayList<Country> getCountry() {
    // Create the ArrayList of Date objects to return
    ArrayList<Country> countries = new ArrayList<Country>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(DATABASE);

        // Prepare a new SQL Query & Set a timeout
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        // The Query
        String query = "SELECT CountryCode,CountryName FROM Country";
        
        // Get Result
        ResultSet results = statement.executeQuery(query);

        // Process all of the results
        while (results.next()) {
            // Lookup the columns we need
            String CountryCode = results.getString("CountryCode");
            String CountryName = results.getString("CountryName");

            // Create a Date Object
            Country cc = new Country(CountryCode, CountryName);


            // Add the lga object to the array
            countries.add(cc);
        }

        // Close the statement because we are done with it
        statement.close();
    } catch (SQLException e) {
        // If there is an error, lets just pring the error
        System.err.println(e.getMessage());
    } finally {
        // Safety code to cleanup
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

    // Finally we return all of the lga
    return countries;
}



/**
 * Get all of the Date in the database.
 * @return
 *    Returns an ArrayList of Date objects
 */

 public ArrayList<CountryTempObservation> getCountryTempObservations() {
    ArrayList<CountryTempObservation> CountryTO = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(JDBCConnection.DATABASE);
         Statement statement = connection.createStatement()) {

        String query = "SELECT CountryCode, Year, AvgTemp, MinTemp, MaxTemp, population FROM CountryTempObservation";

        ResultSet results = statement.executeQuery(query);

        while (results.next()) {
            String countryCode = results.getString("CountryCode");
            int year = results.getInt("Year");
            double avgTemp = results.getDouble("AvgTemp");
            double minTemp = results.getDouble("MinTemp");
            double maxTemp = results.getDouble("MaxTemp");
            long population = results.getLong("Population");

            CountryTempObservation cto = new CountryTempObservation(countryCode, year, avgTemp, minTemp, maxTemp, population);
            CountryTO.add(cto);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }

    return CountryTO;
}

// **
//  * Get all of the Country in the database.
//  * @return
//  *    Returns an ArrayList of Country objects
//  */
public static ArrayList<Population> getppl() {
    // Create the ArrayList of Date objects to return
    ArrayList<Population> popu = new ArrayList<Population>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(DATABASE);

        // Prepare a new SQL Query & Set a timeout
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        // The Query
        String query = "SELECT CountryName, CountryCode, Year, pop FROM Population";
        
        // Get Result
        ResultSet results = statement.executeQuery(query);

        // Process all of the results
        while (results.next()) {
            // Lookup the columns we need
            String CountryName = results.getString("Country Name");
            String CountryCode = results.getString("Country Code");
            int Year = results.getInt("Year");
            int pop = results.getInt("Population");
            
            Population p = new Population(CountryName, CountryCode, Year, pop);


            // Add the lga object to the array
            popu.add(p);
        }

        // Close the statement because we are done with it
        statement.close();
    } catch (SQLException e) {
        // If there is an error, lets just pring the error
        System.err.println(e.getMessage());
    } finally {
        // Safety code to cleanup
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.getMessage());
        }
    }

    // Finally we return all of the lga
    return popu;
}
}


























// // //     Add your methods here
// // //     //CLIMATE DATABASE
// public class JDBCConnection {

//     // Name of database file (contained in database folder)
//     public static final String DATABASE = "jdbc:sqlite:database/climate.db";

//     /**
//      * This creates a JDBC Object so we can keep talking to the database
//      */
//     public JDBCConnection() {
//         System.out.println("Created JDBC Connection Object");
//     }

    
//     /**
//      * Get all of the LGAs in the database.
//      * @return
//      *    Returns an ArrayList of LGA objects
//      */
     
// public ArrayList<CountryTempObservation> getCountryData() {
//     //Create the ArrayList of LGA objects to return
//     ArrayList<CountryTempObservation> climateD = new ArrayList<CountryTempObservation>();

//     // Setup the variable for the JDBC connection
//     Connection connection = null;

//     try {
//         // Connect to JDBC data base
//         connection = DriverManager.getConnection(DATABASE);

//         // Prepare a new SQL Query & Set a timeout
//         Statement statement = connection.createStatement();
//         statement.setQueryTimeout(30);

//         // The Query
//         String query = "SELECT * FROM CountryTempObservation";
        
//         // Get Result
//         ResultSet results = statement.executeQuery(query);

//         // Process all of the results
//         while (results.next()) {
//             // Lookup the columns we need
//             int year       = results.getInt("Year");
//             String ccode     = results.getString("CountryCode");
//             int avgtemp     = results.getInt("AvgTemp");
//             int mintemp     = results.getInt("MinTemp");
//             int maxtemp     = results.getInt("MaxTemp");

//             // Create a CountryTempObservation Object
//             CountryTempObservation climatedata = new CountryTempObservation(year, ccode, avgtemp, mintemp, maxtemp);

//             // Add the lga object to the array
//             climateD.add(climatedata);
//         }

//         // Close the statement because we are done with it
//         statement.close();
//     } catch (SQLException e) {
//         // If there is an error, lets just pring the error
//         System.err.println(e.getMessage());
//     } finally {
//         // Safety code to cleanup
//         try {
//             if (connection != null) {
//                 connection.close();
//             }
//         } catch (SQLException e) {
//             // connection close failed.
//             System.err.println(e.getMessage());
//         }
//     }

//     // Finally we return all of the countrytemp
//     return climateD;
// }
// }