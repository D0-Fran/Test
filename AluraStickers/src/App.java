import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        //Fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create(url);
        var Client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = Client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // extrair só os dados que interessa (Titulo, poster, classificações)
        var parser = new JsonParser();
        List<Map<String, String>> ListaDeFilmes = parser.parse(body);

        //exibir e manipular os dados
        for (Map<String,String> filme : ListaDeFilmes) {
                System.out.println(filme.get("title"));
                System.out.println(filme.get("image"));
                System.out.println(filme.get("imDbRating"));

        }
    }
}
