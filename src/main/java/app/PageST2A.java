package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 * <p>
 * PageST2A class handles the HTTP GET and POST requests for page2A.html
 * and performs the global temperature search based on the user's input.
 * The search results are displayed on the webpage.
 */
public class PageST2A implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/page2A.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" +
                "<title>Subtask 2.1</title>";

        // Add some CSS (external file)
        html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
        html = html + "</head>";

        // Add the body
        html = html + "<body>";

        // Add the topnav
        // This uses a Java v15+ Text Block
        html = html + """
                <div class='topnav'>
                    <a href='/'>Homepage</a>
                    <a href='mission.html'>About us</a>
                    <a href='page2A.html'>Oceania</a>
                <a href='page2B.html'>Volunteer</a>
                 
                </div>
            """;

        // Add header content block
        // html = html + """
        //         <div class='header'>
        //             <h1>Temperature & Population change</h1>
        //         </div>
        //     """;

        // Add Div for page Content
        html = html + "<div class='content'>";

        // Add HTML for the page content
        // html = html + """
        //         <p>Subtask 2.A page content</p>
        //         <h1>Global Data</h1>

        //     """;
        html = html + """
        <section class="datapage">
          <header>
            <style>
            .logo-link {
            text-decoration: none;
            }
            </style>
            <a href="/" class="logo-link">
                <h2 class="logo">OCT</h2>
            </a>
            <div class="toggle"></div>
          </header>
          <img src='oceania_map.png'/imageocean>
          <div class="overlay"></div>
          <div class="text">
            <h2>Oceania Preferences</h2> 
            <p>Welcome to your very own custom Oceania selection page. Here OCT provides an area for you to choose exactly the type of information you are looking for such as, country, city, state and specific years. Once you have selected your preferences please click submit, which will then display the average temp, minimum temp and maximum temp for your selected country.</p>
            
            <form action='/page2A.html' method='post'>
            <label>Enter Global start year</label>
                <input name="startYearInput" type="number" required>
                <label>Enter Global end year</label>
                <input name="endYearInput" type="number" required>
                <button type="submit">Search</button>
            </form>
            
            <form id="countrySearchForm" action="/page2A.html" method="post">
            <label>Enter Country</label>
            <input name="countryInput">
            <label>Enter start year</label>
            <input name="startYear" type="number" required>
            <label>Enter end year</label>
            <input name="endYear" type="number" required>
            <button type="submit">Search</button>
        </form>
        <p>Please scroll down for results after clicking Search.</p>
          </div>
          </section>
          <div class="menu">
            <ul>
            <li><a href='/'>Homepage</a></li>
            <li><a href='mission.html'>About Us</a></li>
            <li><a href='page2A.html'>Oceania</a></li>
            <li><a href='page2B.html'>Volunteer</a></li>
            </ul>
            </div>
        """;


        html = html + "<form action='/page2A.html' method='post'>";
        // Global search box 
        // html = html + """
        //         <label>Enter Global start year</label>
        //         <input name="startYearInput" type="number" required>
        //         <label>Enter Global end year</label>
        //         <input name="endYearInput" type="number" required>
        //         <button type="submit">Search</button>
        //     </form>""";

        // Allow the year to be used in a form of submission (For global)
        String startYearInputString = context.formParam("startYearInput");//startYearInput is from the input name(ID) from the search both. The String is bc of the String at the front
        String endYearInputString = context.formParam("endYearInput");

        if (startYearInputString == null || startYearInputString.isEmpty()
                || endYearInputString == null || endYearInputString.isEmpty()) {
            // If any input is NULL or empty, nothing to show, therefore we make some "no results" HTML
            html = html + "<h2><i>No Results to show for global search</i></h2>";
        } else {
            // If NOT NULL or empty, perform the global search!
            int startYearInput = Integer.parseInt(startYearInputString);
            int endYearInput = Integer.parseInt(endYearInputString);
            html = html + GlobalSearch(startYearInput, endYearInput);
        }

//Country search box
 html = html + "</ul>"; 

    // html = html + """
    //     <form id="countrySearchForm" action="/page2A.html" method="post">
    //         <h1>Country Data</h1>
    //         <label>Enter Country</label>
    //         <input name="countryInput">
    //         <label>Enter start year</label>
    //         <input name="startYear" type="number" required>
    //         <label>Enter end year</label>
    //         <input name="endYear" type="number" required>
    //         <button type="submit">Search</button>
    //     </form>
    // """;

// Allowing year and country to be used as a form of submission (For Country)
String countryInput = context.formParam("countryInput");
String startYearString = context.formParam("startYear");
String endYearString = context.formParam("endYear");

if (countryInput == null || countryInput.isEmpty()
        || startYearString == null || startYearString.isEmpty()
        || endYearString == null || endYearString.isEmpty()) {
    // If any input is NULL or empty, display a message
    html = html + "<h2><i>No Results to show for country search</i></h2>";
} else {
    // If NOT NULL or empty, perform the country search!
    int startYear = Integer.parseInt(startYearString);
    int endYear = Integer.parseInt(endYearString);
    html = html + CountrySearch(countryInput, startYear, endYear);
}

// //Sort by search box 
//     html = html + """ 

//         <div class="form-group"> 

//        <label for="sortby_select">Sort By:</label> 

//        <select id="sortby_select" name="sortby_select"> 

//         <option value=></option> 

//        <option value="population">Population</option> 

//        <option value="temperature">Temperature</option> 

//        </select> 

//        </div> 

//     """        ; 
        html = html + "</div>";

        // // Footer
        // html = html + """
        //         <div class='footer'>
        //             <p>COSC2803 - Studio Project Starter Code (Apr23)</p>
        //         </div>
        //     """;

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";

        // Makes Javalin render the webpage
        context.html(html);
    }
 
    //To connect to the GlobalSearch from before(Need this for the one before to work)
    public String GlobalSearch(int startYearInput, int endYearInput) {
    String html = "";
    html = html + "<h2>Global Results</h2>";

    // Look up global yearly temperature from JDBC
    ArrayList<GlobalYearlyTemp> GlobalYT = getGlobalYearlyTemp(startYearInput, endYearInput);

    // Add HTML for the global yearly temperature table
    html = html + "<table>";
    html = html + "<tr>";
    html = html + "<th>Year</th>";
    html = html + "<th>AvgTemp</th>";
    html = html + "<th>MinTemp</th>";
    html = html + "<th>MaxTemp</th>";
    html = html + "</tr>";
    for (GlobalYearlyTemp gyt : GlobalYT) {
        html = html + "<tr>";
        html = html + "<td>" + gyt.getYear() + "</td>";
        html = html + "<td>" + gyt.getAvgTemp() + "</td>";
        html = html + "<td>" + gyt.getMinTemp() + "</td>";
        html = html + "<td>" + gyt.getMaxTemp() + "</td>";
        html = html + "</tr>";
    }
    html = html + "</table>";

    return html;
}

//     public String GlobalSearch(int startYearInput, int endYearInput) {
//         String html = "";
//         html = html + "<h2>Global Results</h2>";

//         // Look up global yearly temperature from JDBC
//         ArrayList<GlobalYearlyTemp> GlobalYT = getGlobalYearlyTemp(startYearInput, endYearInput);

//         // Add HTML for the global yearly temperature list
//         html = html + "<ul>";
//         for (GlobalYearlyTemp gyt : GlobalYT) {
//     html = html + "<br>"; 
//     html = html + "<li>Year: " + gyt.getYear() + "</li>";
//     html = html + "<li>AvgTemp: " + gyt.getAvgTemp() + "</li>";
//     html = html + "<li>MinTemp: " + gyt.getMinTemp() + "</li>";
//     html = html + "<li>MaxTemp: " + gyt.getMaxTemp() + "</li>";
// }
//         html = html + "</ul>";

//         return html;
//     }

    public ArrayList<GlobalYearlyTemp> getGlobalYearlyTemp(int startYearInput, int endYearInput) {
        ArrayList<GlobalYearlyTemp> GlobalYT = new ArrayList<>();

        Connection connection = null;

        try {
            // Connect to JDBC database
            connection = DriverManager.getConnection(JDBCConnection.DATABASE);

            // Prepare a new SQL Query & Set a timeout
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // The Query
            String query = "SELECT DISTINCT Year, AvgTemp, MinTemp, MaxTemp FROM GlobalYearlyTemp " +
                "WHERE Year >= " + startYearInput + " AND Year <= " + endYearInput;
            // Get Result
            ResultSet results = statement.executeQuery(query);

            // Process all of the results
            while (results.next()) {
                // Lookup the columns we need
                int Year = results.getInt("Year");
                double AvgTemp = results.getDouble("AvgTemp");
                double MinTemp = results.getDouble("MinTemp");
                double MaxTemp = results.getDouble("MaxTemp");

                // Create a GlobalYearlyTemp object
                GlobalYearlyTemp gyt = new GlobalYearlyTemp(Year, AvgTemp, MinTemp, MaxTemp);

                // Add the GlobalYearlyTemp object to the array
                GlobalYT.add(gyt);
            }

            // Close the statement because we are done with it
            statement.close();
        } catch (SQLException e) {
            // If there is an error, let's just print the error
            System.err.println(e.getMessage());
        } finally {
            // Safety code to cleanup
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // Connection close failed.
                System.err.println(e.getMessage());
            }
        }

        // Finally, return all of the GlobalYearlyTemp objects
        return GlobalYT;
    }


//To connect it to the CountrySearch before (need this for the one before to work)
public String CountrySearch(String countryInput, int startYear, int endYear) {
    String html = "";
    html = html + "<h2>Country Temp Observation Results</h2>";

    ArrayList<CountryTempObservation> CountryTO = getCountryTempObservation(countryInput, startYear, endYear);

    html = html + "<table>";
    html += "<tr><th>Year</th><th>Country code</th><th>AvgTemp</th><th>MinTemp</th><th>MaxTemp</th><th>Population</th></tr>";
    for (CountryTempObservation cto : CountryTO) {
        html += "<tr>";
        html += "<td>" + cto.getYear() + "</td>";
        html += "<td>" + cto.getCountryCode() + "</td>";
        html += "<td>" + cto.getAvgTemp() + "</td>";
        html += "<td>" + cto.getMinTemp() + "</td>";
        html += "<td>" + cto.getMaxtemp() + "</td>";
        html += "<td>" + cto.getPopulation() + "</td>";
        html += "</tr>";
    }
    html = html +  "</table>";

    return html;
}

//     public String CountrySearch(String countryInput, int startYear, int endYear) {
//     String html = "";
//     html = html + "<h2>Country Temp Observation Results</h2>";

//     ArrayList<CountryTempObservation> CountryTO = getCountryTempObservation(countryInput, startYear, endYear);

//     html = html + "<ul>";
//     for (CountryTempObservation cto : CountryTO) {
//         html += "<li>Year: " + cto.getYear() + "</li>";
//         html += "<li>Country code: " + cto.getCountryCode() + "</li>";
//         html += "<li>AvgTemp: " + cto.getAvgTemp() + "</li>";
//         html += "<li>MinTemp: " + cto.getMinTemp() + "</li>";
//         html += "<li>MaxTemp: " + cto.getMaxtemp() + "</li>";
//         html += "<li>Population: " + cto.getPopulation() + "</li>";
//     }
//     html = html +  "</ul>";

//     return html;
// }

//From JDBC 
    public ArrayList<Country> getCountry() {
    // Create the ArrayList of Date objects to return
    ArrayList<Country> countries = new ArrayList<Country>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(JDBCConnection.DATABASE);

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


 public ArrayList<CountryTempObservation> getCountryTempObservation(String countryInput, int startYear, int endYear) {
        ArrayList<CountryTempObservation> CountryTO = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBCConnection.DATABASE);
         PreparedStatement statement = connection.prepareStatement(
                 "SELECT CountryCode, Year, AvgTemp, MinTemp, MaxTemp, Population " +
                 "FROM CountryTempObservation " +
                 "WHERE CountryCode IN (SELECT CountryCode FROM Country WHERE CountryName = ?) " +
                 "AND Year >= ? AND Year <= ?")) {

        statement.setString(1, countryInput);
        statement.setInt(2, startYear);
        statement.setInt(3, endYear);

        ResultSet results = statement.executeQuery();

        while (results.next()) {
            String countryCode = results.getString("CountryCode");
            int Year = results.getInt("Year");
            double AvgTemp = results.getDouble("AvgTemp");
            double MinTemp = results.getDouble("MinTemp");
            double MaxTemp = results.getDouble("MaxTemp");
            int Population = results.getInt("Population");

            CountryTempObservation cto = new CountryTempObservation(countryCode, Year, AvgTemp, MinTemp, MaxTemp, Population);
            CountryTO.add(cto);
        }
    } catch (SQLException e) {
        System.err.println(e.getMessage());
    }

    return CountryTO;
}


public static ArrayList<Population> getppl() {
    // Create the ArrayList of Date objects to return
    ArrayList<Population> pop = new ArrayList<Population>();

    // Setup the variable for the JDBC connection
    Connection connection = null;

    try {
        // Connect to JDBC data base
        connection = DriverManager.getConnection(JDBCConnection.DATABASE);

        // Prepare a new SQL Query & Set a timeout
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        // The Query
        String query = "SELECT CountryName, CountryCode, Year, Population FROM Population";
        
        // Get Result
        ResultSet results = statement.executeQuery(query);

        // Process all of the results
        while (results.next()) {
            // Lookup the columns we need
            String CountryName = results.getString("Country Name");
            String CountryCode = results.getString("Country Code");
            int Year = results.getInt("Year");
            int population = results.getInt("Population");
            
            Population p = new Population(CountryName, CountryCode, Year, population);


            // Add the lga object to the array
            pop.add(p);
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
    return pop;
}
}

