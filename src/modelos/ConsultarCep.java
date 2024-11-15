package modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarCep {

    public EnderecoViaCepApi_Record consultarCepAPiViaCep(String urlConsultaCep) throws IOException, InterruptedException {
        System.out.println("Consultar CEP");

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlConsultaCep)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gsonEnderecoCep = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            String json = response.body();
            EnderecoViaCepApi_Record enderecoViaCep = gsonEnderecoCep.fromJson(json, EnderecoViaCepApi_Record.class);
            System.out.println("\nJSON formato API VIA CEP -> \n" + enderecoViaCep + "\n");

            return enderecoViaCep;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível encontrar dadados para o CEP informado.");
        }
    }
}
