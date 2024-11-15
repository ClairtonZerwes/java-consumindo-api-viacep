package principal;

import exceptions.ErroDeConversaoDeDadosViaCep;
import modelos.*;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner leitura = new Scanner(System.in);
        String consultaCep = "";
        List<Endereco> enderecosConsultados = new ArrayList<>();
        //Gson gson = new Gson();
        GerarArquivo gerarArquivo = new GerarArquivo();

        do {
            System.out.println("Informe o CEP para consultar endereço (Digite \"sair\" para encerrar): ");
            // final String codigoChaveApi = "";
            String cep = leitura.nextLine();

            if (cep.equalsIgnoreCase("sair")) {
                break;
            } else if (!eValido(cep)) {
                continue;
            }

            /* Exemplo de consulta de CEP: viacep.com.br/ws/01001000/json/ */
            MontarUrlConsultaApiViaCep montarUrlConsultaCep = new MontarUrlConsultaApiViaCep();
            String urlConsultaCep =  montarUrlConsultaCep.montarUrlParaBuscarCep(cep);

            try {
                HttpResponse<Object> response;
                ConsultarCep consultarCep = new ConsultarCep();
                EnderecoViaCepApi_Record novoEndereco = consultarCep.consultarCepAPiViaCep(urlConsultaCep);
                Endereco enderecoConsultado = new Endereco(novoEndereco);
                System.out.println("Dados CEP consultado convertido JSON local");
                System.out.println(enderecoConsultado);

                /* Criando arquivo TXT */
                gerarArquivo.salvarTxt(enderecoConsultado);
                enderecosConsultados.add(enderecoConsultado);
            } catch (ErroDeConversaoDeDadosViaCep e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Ocorreu erro ao converter os dados");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ocorreu um ou mais erros na consulta API VIACEP, Verifique o endereço informado!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        } while (!consultaCep.equalsIgnoreCase("sair"));

        gerarArquivo.salvarJson(enderecosConsultados);
        System.out.println("Programa Executado Corretamente!!!");
    }

    public static boolean isNumeric(String cep) {
        for (char c : cep.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean eValido(String cep) {
        boolean cepValido = true;

        if (!isNumeric(cep)) {
            System.out.println("Informe somente números no CEP.");
            cepValido = false;
        }
        if (cep.length() != 8) {
            System.out.println("Inorme extamente o total de 8 digitos para o CEP.");
            cepValido = false;
        }

        return cepValido;
    }

}