

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
public class PageSignUp implements Handler {

    // URL of this page relative to http://localhost:7001/
    public static final String URL = "/pagesignup.html";

    @Override
    public void handle(Context context) throws Exception {
        // Create a simple HTML webpage in a String
        String html = "<html>";

        // Add some Head information
        // html = html + "<head>" + 
        //        "<title>Sign Up</title>";

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
                <a href='pagesignup.html'>Sign Up</a>
                
            </div>
        """;

        // // Add header content block
        // html = html + """
        //     <div class='header'>
        //         <h1>Volunteer</h1>
        //     </div>
        // """;

        // html = html + """
        //     </div>
        // <section class="showcase">
        //   <header>
        //     <h2 class="logo">OCT</h2>
        //     <div class="toggle"></div>
        //   </header>
        //   <video src="volunteer.mp4" muted loop autoplay></video>
        //   <div class="overlay"></div>
        //   <div class="text">
        //     <h5>Volunteer</h5> 
        //     <p>Our project is reaching more and more individuals, groups and communities, who are joining the OCT family, with now over 10,000 members. The purpose of the All In program is to promote change for our climate and beautiful planet that we all call home. Climate Change awareness and participation starts here at OCT, where diverse people from around Oceania can spread their wings and discover new ways to learn about the changes in land and sea temperatures, while passing on that knowledge to the elder and younger generations.
        //     </p>
        //     <p>There are various events held monthly that you can sign up for by just providing your name and email address at the bottom of the page. Whether you are intending to simply explore this new site or take part in its much-loved program, we are here for you at every step of the way. OCT provides support for people interested in training courses and teaching/core knowledge seminars that feature information about our main focus, land and ocean temperature changes across a 260-year period.</p>
        //     <h5>Testimonials</h5>
        //     <x>Coming into this program with a small amount of climate knowledge and in means to discover a new outlet of people to connect with, I have now been encouraged to encourage others to not be afraid to take a step forward into a new experience. The All-In program has helped me grow into a person of compassion for people and the earth in a much deeper way.</x>
        //     <x>Kate.D</x>
        //     <br>
        //     <br>
        //     <x>After years of experience in Council work, All In was my very first volunteer program that I would never regret choosing to be a part of. Looking back, the connections with likeminded people that I formed and passionate teams really benefited my journey in this field. The most insightful aspect was the training program where I was able to learn more about land and ocean temperature changes within Oceania and be able to use that information to teach others.</x>
        //     <x>Michael L.</x>
              
        //     </div>

        //   </section>
        //   <div class="menu">
        //   <ul>
        //   <li><a href='/'>Homepage</a></li>
        //   <a href='page3A.html'>Temp/Pop</a>
        //   <li><a href='page2A.html'>Oceania</a></li>
        //   <li><a href='page2B.html'>Volunteer</a></li>
        //   <li><a href='pagesignup.html'>Sign Up</a></li>
        //    </ul>
        //    </div>
        // """;
    //   CURRENT BURGER MENU
        html = html + """
            <body>
            <label>
            <input type="checkbox">
            <span class="menu"> <span class="hamburger"></span> </span>
            <ul>
            <li> <a href="#">Temp/Pop</a> </li>
            <li> <a href="#">Temp Only</a> </li>
            <li> <a href="#">Temp Similarities</a> </li>
            </ul>
            """;
            // SUBSCRIBE CODE
    html = html + """

        """;

    // html = html + """
    //       <script>
    //   const menuToggle = document.querySelector('.toggle');
    //   const showcase = document.querySelector('.showcase');

    //   menuToggle.addEventListener('click', () => {
    //   menuToggle.classList.toggle('active');
    //   showcase.classList.toggle('active');
    //   })
    //   </script>
    //   </body>
    //   </html>
    //   """;

        // html = html + """
        //     <body>
        //     <label>
        //     <input type="checkbox">
        //     <span class="menu"> <span class="hamburger"></span> </span>
        //     <ul>
        //       <li> <a href="#">Home</a> </li>
        //       <li> <a href="#">About</a> </li>
        //       <li> <a href="#">Contact</a> </li>
        //     </ul>
        //     </label>
        //     <h1>Morphing Fullscreen Hamburger Menu Demo</h1>
        //     </body>
        //     // Add Div for page Content
        //     html = html + "<div class='content'>";
        //     """;

        // Add Div for page Content
        html = html + "<div class='content'>";

        // Add HTML for the page content
        // html = html + """
        //     <p>Sign Up</p>
        //     """;

        // Close Content div
        html = html + "</div>";

        // // Footer
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
