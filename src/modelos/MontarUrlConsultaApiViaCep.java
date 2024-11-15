package modelos;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MontarUrlConsultaApiViaCep {

    public String montarUrlParaBuscarCep(String cepInformado) {
        /*
            Exemplo de consulta de CEP:
            viacep.com.br/ws/01001000/json/
        */
        String urlConsultaCep = URLEncoder.encode(cepInformado, StandardCharsets.UTF_8);
        urlConsultaCep = "https://viacep.com.br/ws/" + urlConsultaCep + "/json/";
        System.out.println(urlConsultaCep);

        return urlConsultaCep;
    }
}
