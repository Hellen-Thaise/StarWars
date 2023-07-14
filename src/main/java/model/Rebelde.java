package model;

public class Rebelde {
    //Atributos = Colunas do banco

    private Integer id_rebelde;
    private String nome_rebelde;
    private Integer idade;
    private String genero;
    private String localizacao;

    public int getId_rebelde() {
        return id_rebelde;
    }

    public void setId_rebelde(Integer id_rebelde) {
        this.id_rebelde = id_rebelde;
    }

    public String getNome_rebelde() {
        return nome_rebelde;
    }

    public void setNome_rebelde(String nome_rebelde) {
        this.nome_rebelde = nome_rebelde;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
