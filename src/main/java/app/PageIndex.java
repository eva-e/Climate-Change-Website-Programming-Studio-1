package app;

import java.util.ArrayList;

import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin
 * by writing the raw HTML into a Java String object
 *
 * @author Timothy Wiley, 2023. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class PageIndex implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Header information
        html = html + "<head>" + 
               "<title>Home</title>";
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
                <a href='mission.html'>About Us</a>
                <a href='page2A.html'>Oceania</a>
                <a href='page2B.html'>Volunteer</a>
            </div>
        """;
    //   Style relates to the OCT Logo homepage link
        html = html + """
            </div>
        <section class="showcase">
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
          <video src="beachstock.mp4" muted loop autoplay></video>
          <div class="overlay"></div>
          <div class="text">
            <h2>Oceania Climate Trends</h2> 
            <p>At OCT we work to ensure we deliver useful and insightful content, which will aid your understanding of the effects of climate change. OCT is also a proud partner with many non-profit and charitable organisations, who work tireless on beach clean ups to aid relief for natural disaster victims - and everything in-between. On our site we provide data for worldwide country temperatures ranging from the year 1750 to 2015. To find out more about out mission, please click the explore button below.</p>
            <a href='mission.html'>Explore</a>
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
 
       
// CURRENT BURGER MENU
        html = html + """
            <body>
            <label>
            <input type="checkbox">
            <span class="menu"> <span class="hamburger"></span> </span>
            <ul>
            <li> <b href="#">Choose your preferred Data page</b> </li>
            <a href='page2A.html'>Temp/Pop</a>
            </ul>
            """;

            // // Add Div for page Content 
            // html = html + "<div class='content'>"; 
            //         """;

       
        // Add side nav menu ^^^
        // This uses a Java v15+ Text Block ^^


        // Tried to implement javascript through HTML here, finally worked
        // This is a new burger menu
        // html = html + """
        //     <script>
        // const menuToggle = document.querySelector('.toggle');
        // const showcase = document.querySelector('.showcase');

        // menuToggle.addEventListener('click', () => {
        // menuToggle.classList.toggle('active');
        // showcase.classList.toggle('active');
        // })
        // </script>
        // </body>
        // </html>
        // """;

       
        // Add Div for page Content
        html = html + "<div class='content'>";

        // Add HTML for the page content
        html = html + """
            <p>Home</p>
            """;

        // // Get the ArrayList of Strings of all LGAs
        // ArrayList<String> lgaNames = getLGAs2016();

        // Get the ArrayList of Strings of all LGAs
        // ArrayList<String> CountryData = getCountryData();

        // // Add HTML for the LGA list
        // // html = html + "<h1>All 2016 LGAs in the CTG database</h1>" + "<ul>";

        // // Finally we can print out all of the LGAs
        // for (String name : lgaNames) {
        //     html = html + "<li>" + name + "</li>";
        // }

          // Finally we can print out all of the CLIMATE
        // for (String ccode : CountryData) {
        //     html = html + "<li>" + ccode + "</li>";
        // }

        // Finish the List HTML
        html = html + "</ul>";

        // Close Content div
        html = html + "</div>";

        // Footer
        html = html + """
            <div class='footer'>
                <p>COSC2803 - Studio Project Starter Code (Apr23)</p>
            </div>
        """;

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";


        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }
}



//     //  Get the names of the LGAs in the database.
     
//     public ArrayList<String> getLGAs2016() {
//         // Create the ArrayList of LGA objects to return
//         ArrayList<String> lgas = new ArrayList<String>();

//         // Setup the variable for the JDBC connection
//         Connection connection = null;

//         try {
//             // Connect to JDBC data base
//             connection = DriverManager.getConnection(JDBCConnection.DATABASE);

//             // Prepare a new SQL Query & Set a timeout
//             Statement statement = connection.createStatement();
//             statement.setQueryTimeout(30);

//             // The Query
//             String query = "SELECT * FROM LGA WHERE year='2016'";
            
//             // Get Result
//             ResultSet results = statement.executeQuery(query);

//             // Process all of the results
//             while (results.next()) {
//                 String name16  = results.getString("name");

//                 // Add the lga object to the array
//                 lgas.add(name16);
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

// CLIMATE DATABASE
//  Get the names of the CountryTempObservation in the database.
     
//     public ArrayList<String> getCountryData() {
//         // Create the ArrayList of CountryTempObservation objects to return
//         ArrayList<String> climateD = new ArrayList<String>();

//         // Setup the variable for the JDBC connection
//         Connection connection = null;

//         try {
//             // Connect to JDBC data base
//             connection = DriverManager.getConnection(JDBCConnection.DATABASE);

//             // Prepare a new SQL Query & Set a timeout
//             Statement statement = connection.createStatement();
//             statement.setQueryTimeout(30);

//             // The Query
//             String query = "SELECT * FROM CountryTempObservation ON Year";
//             // String query = "SELECT * FROM CountryTempObservation ON CountryCode";
            
//             // Get Result
//             ResultSet results = statement.executeQuery(query);

//             // Process all of the results
//             while (results.next()) {
//                     int year     = results.getInt("Year");
//                     String ccode     = results.getString("CountryCode");
//                     int avgtemp     = results.getInt("AvgTemp");
//                     int mintemp     = results.getInt("MinTemp");
//                     int maxtemp     = results.getInt("MaxTemp");

//                 // Add the lga object to the array
//                 climateD.add(ccode);
//                 // climateD.add(year);
//                 // // climateD.add(avgtemp);
//                 // // climateD.add(mintemp);
//                 // // climateD.add(maxtemp);

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
//         return climateD;
//     }
// }
