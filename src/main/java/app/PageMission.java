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
public class PageMission implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/mission.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        html = html + "<head>" + 
               "<title>Our Mission</title>";

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

        // Add header content block
        // html = html + """
        //     <div class='header'>
        //         <h1>Our Mission</h1>
        //     </div>
        // """;

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
            <h12>Our Mission</h12> 
            <p>OCT has a core focus on each country within the Oceania region, 
            providing visitors with statistics of ocean and land temperature 
            changes over a 260-year-period. In doing so, our site reaches a 
            broad range of people who are interested in climate change overall, 
            or with intentions to volunteer, analyse data and gain more knowledge on 
            how this region of the earth has progressed over time on both land and 
            in the surrounding oceans.</p>
            <h6>All In</h6> 
            <p>Our OCT team, believe that everyone should have the opportunity to 
            make a difference in their own way to give back to the community 
            and also have an impact on a global scale. All In, is a volunteering 
            program for All to get involved with different ways to promote and clean our communities. 
            For more information on volunteering and events related to our land and ocean focused programs 
            please visit the Volunteer page also linked below.</p>
            <a href='page2B.html'>Volunteer</a>
            <p></p>
            <h6>Our Team</h6> 
            <p>Our team consists of two passionate climate action members, Nazam Gill and Eva Evgenidis.</p>

          </div>
          </section>
        <div class="menu">
          <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">News</a></li>
            <li><a href="#">Destination</a></li>
            <li><a href="#">Blog</a></li>
            <li><a href="#">Contact</a></li>
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


//OLD MENU
        // html = html + """
        //   <body>
        //   <label>
        //   <input type="checkbox">
        //   <span class="menu"> <span class="hamburger"></span> </span>
        //   <ul>
        //     <li> <a href="#">Home</a> </li>
        //     <li> <a href="#">About</a> </li>
        //     <li> <a href="#">Contact</a> </li>
        //   </ul>
        //   </label>
        //   <h1>Morphing Fullscreen Hamburger Menu Demo</h1>
        //   </body>
        //   // Add Div for page Content
        //   html = html + "<div class='content'>";
        //   """;
        // html = html + """
        //     <div class='header'>
        //         <h1>
        //             <img src='image.png' class='top-image' alt='RMIT logo' height='400'>
                    
        //         </h1>
        //     </div>
        // """;

        // Add Div for page Content
        html = html + "<div class='content'>";

        // Add HTML for the page content
        html = html + """
            <p>Mission page</p>
            """;


        // Finish the List HTML
        html = html + "</ul>";


        // Close Content div
        html = html + "</div>";

        // Footer
        // html = html + """
        //     <div class='footer'>
        //         <p>COSC2803 - Studio Project Starter Code (Apr23)</p>
        //     </div>
        // """;

        // Finish the HTML webpage
        html = html + "</body>" + "</html>";
        

        // DO NOT MODIFY THIS
        // Makes Javalin render the webpage
        context.html(html);
    }

}


        // // This example uses JDBC to lookup the LGAs
        // JDBCConnection jdbc = new JDBCConnection();

        // // Next we will ask this *class* for the LGAs
        // ArrayList<LGA> lgas = jdbc.getLGAs2016();

        // // Add HTML for the LGA list
        // html = html + "<h1>All 2016 LGAs in the CTG database (using JDBC Connection)</h1>" + "<ul>";

        // // Finally we can print out all of the LGAs
        // for (LGA lga : lgas) {
        //     html = html + "<li>" + lga.getCode()
        //                 + " - " + lga.getName() + "</li>";
        // }