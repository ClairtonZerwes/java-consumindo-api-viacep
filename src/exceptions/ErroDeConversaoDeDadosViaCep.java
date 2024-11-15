package exceptions;

public class ErroDeConversaoDeDadosViaCep extends NumberFormatException {

    private String mensagem;

    public ErroDeConversaoDeDadosViaCep(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
