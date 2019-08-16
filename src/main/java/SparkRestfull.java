import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;

import static spark.Spark.*;

public class SparkRestfull {
    public static void main(String[] args) {

        final IServiceItem service = new ItemServiceMap();

        port(8080);

        post("/users", (req, res) -> {
            res.type("aplication/json");
            URL urlSites = new URL("http://localhost:4567/Users");
            URLConnection urlConnectionSites = urlSites.openConnection();
            return conexion(urlConnectionSites, "POST");
        });

        get("/sites", (req, res) -> {
            res.type("aplication/json");
            URL urlSites = new URL("http://localhost:4567/Sites");
            URLConnection urlConnectionSites = urlSites.openConnection();
            return conexion(urlConnectionSites, "GET");
        });

        get("",(req,res)->{
            res.type("aplication/json");
            URL urlSites = new URL("http://localhost:4567/Sites/"+req.headers("id")+"/categories");
            URLConnection urlConnectionSites = urlSites.openConnection();
            return conexion(urlConnectionSites, "GET");
        });

        get("/items", (req, res) -> {
            res.type("aplication/json");
            Collection<Item> items = service.getItems();
            return new Gson().toJsonTree(items);
        });

        post("/items", (req, res) -> {
            res.type("aplication/json");
            Item item = new Gson().fromJson(req.body(), Item.class);
            int id = service.addItem(item);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(item)));
        });

        get("/items/:userName", (req, res) -> {
            res.type("aplication/json");
            Collection<Item> items = service.getItemsUsers(req.params(":userName"));
            return new Gson().toJsonTree(items);
        });

        /* put("/sites/:id", (req, res) -> {
           res.type( "aplication/json");
           Site site = service.getSite(req.params(":id"));
           Site siteE = new Gson().fromJson(req.body(), Site.class);
           service.addSite(siteE);
           return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(siteE)));
       });*/
    }

    private static Object conexion(URLConnection urlConnectionSites, String metodo) throws IOException {
        if (urlConnectionSites instanceof HttpURLConnection) {

            urlConnectionSites.setRequestProperty("Accept", "application/json");
            urlConnectionSites.setRequestProperty("User-Agent", "Mozilla/5.0");

            HttpURLConnection connectionSites = (HttpURLConnection) urlConnectionSites;
            connectionSites.setRequestProperty("username","Bret");
            connectionSites.setRequestProperty("password","1234");
            connectionSites.setRequestMethod(metodo);
            //BufferedWriter outSites = new BufferedWriter(new OutputStreamWriter(connectionSites.getOutputStream()));
            BufferedReader inSites = new BufferedReader(new InputStreamReader(connectionSites.getInputStream()));

            Gson gsonSites = new Gson();
            Object[] categories = gsonSites.fromJson(inSites, Object[].class);

            //StringBuilder sb = new StringBuilder();
            //String line;
            //while ((line = inSites.readLine()) != null) {
            //sb.append(line);
            //}

            return new Gson().toJson(categories, Object[].class);
        } else {
            return new Gson().toJson(new StandardResponse(StatusResponse.ERROR, "URL inválida."));
        }
    }

}
