package modelos;

import exceptions.ErroDeConversaoDeDadosViaCep;

public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String gia;
    private Integer ddd;
    private Integer ibge;
    private Integer siafi;

    // Construtor

    public Endereco(String cep, String logradouro, String complemento, String unidade,
                    String bairro, String localidade, String uf, String estado,
                    String regiao, String gia, Integer ddd, Integer ibge, Integer siafi)
    {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.unidade = unidade;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.estado = estado;
        this.regiao = regiao;
        this.gia = gia;
        this.ddd = ddd;
        this.ibge = ibge;
        this.siafi = siafi;
    }

    /* Construtor da Classe Endereco e Classe Record EnderecoViaCepApi_Record - para fazer conversão de dados direto */
    public Endereco(EnderecoViaCepApi_Record meuEnderecoViaCep) throws ErroDeConversaoDeDadosViaCep {
        this.cep = meuEnderecoViaCep.cep();
        this.logradouro = meuEnderecoViaCep.logradouro();
        this.complemento = meuEnderecoViaCep.complemento();
        this.unidade = meuEnderecoViaCep.unidade();
        this.bairro = meuEnderecoViaCep.bairro();
        this.localidade = meuEnderecoViaCep.localidade();
        this.uf = meuEnderecoViaCep.uf();
        this.estado = meuEnderecoViaCep.estado();
        this.regiao = meuEnderecoViaCep.regiao();
        this.gia = meuEnderecoViaCep.gia();
        this.ddd = Integer.valueOf(meuEnderecoViaCep.ddd());
        this.ibge = Integer.valueOf(meuEnderecoViaCep.ibge());
        this.siafi = Integer.valueOf(meuEnderecoViaCep.siafi());

    }

    // Getters e Setters

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public Integer getSiafi() {
        return siafi;
    }

    public void setSiafi(Integer siafi) {
        this.siafi = siafi;
    }

    @Override
    public String toString() {
        return "\nEndereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", unidade='" + unidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", estado='" + estado + '\'' +
                ", regiao='" + regiao + '\'' +
                ", gia='" + gia + '\'' +
                ", ddd=" + ddd +
                ", ibge=" + ibge +
                ", siafi=" + siafi +
                '}';
    }
}