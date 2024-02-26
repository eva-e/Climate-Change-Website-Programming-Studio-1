package app;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;


/**
 * Main Application Class.
 * <p>
 * Running this class as regular java application will start the 
 * Javalin HTTP Server and our web application.
 *
 * @author Timothy Wiley, 2023. email: timothy.wiley@rmit.edu.au
 * @author Santha Sumanasekara, 2021. email: santha.sumanasekara@rmit.edu.au
 */
public class App {

    public static final int         JAVALIN_PORT    = 7001;
    public static final String      CSS_DIR         = "css/";
    public static final String      IMAGES_DIR      = "images/";

    public static void main(String[] args) {
        // Create our HTTP server and listen in port 7000
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin("/help/routes"));
            
            // Uncomment this if you have files in the CSS Directory
            config.addStaticFiles(CSS_DIR);

            // Uncomment this if you have files in the Images Directory
            config.addStaticFiles(IMAGES_DIR);
        }).start(JAVALIN_PORT);


        // Configure Web Routes
        configureRoutes(app);
    }

    public static void configureRoutes(Javalin app) {
        // All webpages are listed here as GET pages
        app.get(PageIndex.URL, new PageIndex());
        app.get(PageMission.URL, new PageMission());
        app.get(PageST2A.URL, new PageST2A());
        app.get(PageST2B.URL, new PageST2B());
        // app.get(PageST3A.URL, new PageST3A());
        app.get(PageST3B.URL, new PageST3B());
        app.get(PageSignUp.URL, new PageSignUp());

        // Add / uncomment POST commands for any pages that need web form POSTS
        // app.post(PageIndex.URL, new PageIndex());
        // app.post(PageMission.URL, new PageMission());
        app.post(PageST2A.URL, new PageST2A());
        // app.post(PageST2B.URL, new PageST2B());
        // app.post(PageST3A.URL, new PageST3A());
        // app.post(PageST3B.URL, new PageST3B());
    }

}
