import java.util.ArrayList;

public class Pessoa {
    static ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

    private String nome, sobrenome;
    private String cpf;
    private String email;
    private String genero;
    private String senha;

    public Pessoa(String nome, String sobrenome, String cpf, String email, String genero, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.genero = genero;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "" +
                "Nome: " + nome +
                "| Sobrenome: " + sobrenome +
                "| CPF: " + cpf +
                "| E-Mail: " + email +
                "| Gênero: " + genero +
                "| Senha: " + senha;
    }

    public static ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public static void setListaPessoas(ArrayList<Pessoa> listaPessoas) {
        Pessoa.listaPessoas = listaPessoas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
