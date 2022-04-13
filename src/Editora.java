import java.util.ArrayList;

public class Editora {
    static ArrayList<Editora> listaEditora = new ArrayList<Editora>();

    private String nome;
    private String cnpj;

    @Override
    public String toString() {
        return "Editora{" +
                "nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Editora(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }
}
