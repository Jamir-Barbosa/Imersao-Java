import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    
    public static void main(String[] args) throws Exception {
        

        //Conexão
        
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        

        // Extração
        var parser = new JsonParcer();
        List<Map<String, String>> listadefilmes = parser.parse(body);
        
        // Exibir
            for (Map<String,String> filme : listadefilmes) {
            
            System.out.println(ColorsandBackgrouds.ANSI_BLUE_BACKGROUND + ColorsandBackgrouds.ANSI_RED + filme.get( "fullTitle") + ColorsandBackgrouds.ANSI_RESET);
            System.out.println(filme.get("image"));     
           

            String test = filme.get("imDbRating");

            double testd = Double.parseDouble(test);

            if (testd > 8){
                System.out.println(ColorsandBackgrouds.ANSI_YELLOW_BACKGROUND + ColorsandBackgrouds.ANSI_YELLOW + testd + ColorsandBackgrouds.ANSI_RESET);
            }
            else{
                System.out.println(ColorsandBackgrouds.ANSI_BLUE_BACKGROUND + ColorsandBackgrouds.ANSI_CYAN + testd + ColorsandBackgrouds.ANSI_RESET);
            }
            System.out.println();
           
          

        }

    }
}
