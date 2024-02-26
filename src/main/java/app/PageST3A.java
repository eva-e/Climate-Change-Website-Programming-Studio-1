// package app;

// import java.util.ArrayList;

// import io.javalin.http.Context;
// import io.javalin.http.Handler;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

// /**
//  * Example Index HTML class using Javalin
//  * <p>
//  * Generate a static HTML page using Javalin
//  * by writing the raw HTML into a Java String object
//  *
//  * @author Timothy Wiley, 2023. email: timothy.wiley@rmit.edu.au
//  * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
//  */
// public class PageST3A implements Handler {

//     // URL of this page relative to http://localhost:7001/
//     public static final String URL = "/page3A.html";

//     @Override
//     public void handle(Context context) throws Exception {
//         // Create a simple HTML webpage in a String
//         String html = "<html>";

//         // Add some Head information
//         html = html + "<head>" + 
//                "<title>Subtask 3.1</title>";

//         // Add some CSS (external file)
//         html = html + "<link rel='stylesheet' type='text/css' href='common.css' />";
//         html = html + "</head>";

//         // Add the body
//         html = html + "<body>";

//         // Add the topnav
//         // This uses a Java v15+ Text Block
//         html = html + """
//             <div class='topnav'>
//                 <a href='/'>Homepage</a>
//                 <a href='mission.html'>About Us</a>
//                 <a href='page2A.html'>Oceania</a>
//                 <a href='page2B.html'>Volunteer</a>
//             </div>
//         """;
// // <a href='page3A.html'>Temp/Pop</a>
//         //     html = html + """
//         //     </div>
//         // <section class="showcase">
//         //   <header>
//         //     <h2 class="logo">OCT</h2>
//         //     <div class="toggle"></div>
//         //   </header>
//         //   <video src="beachstock.mp4" muted loop autoplay></video>
//         //   <div class="overlay"></div>
//         //   <div class="text">
//         //     <h2>Temperature and Population</h2> 
//         //     <p>OCT has a core focus on each country within the Oceania region, 
//         //     providing visitors with statistics of ocean and land temperature 
//         //     changes over a 260-year-period. In doing so, our site reaches a 
//         //     broad range of people who are interested in climate change overall, 
//         //     or with intentions to volunteer, analyse data and gain more knowledge on 
//         //     how this region of the earth has progressed over time on both land and 
//         //     in the surrounding oceans.</p>
//         //     <h6>All In</h6> 
//         //     <p>Our OCT team, believe that everyone should have the opportunity to 
//         //     make a difference in their own way to give back to the community 
//         //     and also have an impact on a global scale. All In, is a volunteering 
//         //     program for all people and for All to get involved with different 
//         //     ways to promote and clean our communities 
//         //     and action for climate change. For more information on 
//         //     volunteering and events related to our land and ocean focused programs 
//         //     please visit the Volunteer page also linked below.</p>
//         //     <a href='page2B.html'>Volunteer</a>

//         //   </div>
//         //   </section>
//         // <div class="menu">
//         //   <ul>
//         //     <li><a href="#">Home</a></li>
//         //     <li><a href="#">News</a></li>
//         //     <li><a href="#">Destination</a></li>
//         //     <li><a href="#">Blog</a></li>
//         //     <li><a href="#">Contact</a></li>
//         //   </ul>
//         //   </div>
//         // """;

//         // CURRENT BURGER MENU
//         // html = html + """
//         //     <body>
//         //     <label>
//         //     <input type="checkbox">
//         //     <span class="menu"> <span class="hamburger"></span> </span>
//         //     <ul>
//         //     <li> <b href="#">Choose your preferred Data page</b> </li>
//         //     <li> <a href="#">Temp/Pop</a> </li>
//         //     <a href='page3A.html'>Temp/Pop</a>
//         //     <li> <a href="#">Temp Only</a> </li>
//         //     <li> <a href="#">Temp Similarities</a> </li>
//         //     </ul>
//         //     """;

//         html = html + "   <div class='form-group'>";
//         html = html + "      <label for='movietype_drop'>Select the type Movie Type (Dropdown):</label>";
//         html = html + "      <select id='movietype_drop' name='movietype_drop'>";
//         html = html + "         <option>HORROR</option>";
//         html = html + "         <option>COMEDY</option>";
//         html = html + "         <option>DRAMA</option>";
//         html = html + "      </select>";
//         html = html + "   </div>";

//         html = html + "   <div class='form-group'>";
//         html = html + "      <label for='movietype_textbox'>Select the type Movie Type (Textbox)</label>";
//         html = html + "      <input class='form-control' id='movietype_textbox' name='movietype_textbox'>";
//         html = html + "   </div>";

//         html = html + "   <button type='submit' class='btn btn-primary'>Get all of the movies!</button>";

//         html = html + "</form>";

//         // Add header content block
//         html = html + """
//             <div class='header'>
//                 <h1>Subtask 3.A</h1>
//             </div>
//         """;

//         // Add Div for page Content
//         html = html + "<div class='content'>";

//         // Add HTML for the page content
//         html = html + """
//             <p>Subtask 3.A page content</p>
//             """;

//         // Close Content div
//         html = html + "</div>";

//         // Footer
//         html = html + """
//             <div class='footer'>
//                 <p>COSC2803 - Studio Project Starter Code (Apr23)</p>
//             </div>
//         """;

//         // Finish the HTML webpage
//         html = html + "</body>" + "</html>";
        

//         // DO NOT MODIFY THIS
//         // Makes Javalin render the webpage
//         context.html(html);
//     }

// }
