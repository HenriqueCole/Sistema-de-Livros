import java.util.ArrayList;

public class Livro {
    static ArrayList<Livro> listaLivros = new ArrayList<>();

    private Autor autor;
    private Editora editora;

    private String titulo;
    private int status;
    private int qtdPaginas;
    private String isbn;
    private double porcentagem;

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public String toString() {
        return "Livro-->" +
                "| AUTOR: " + autor +
                "| Título: " + titulo +
                "| Status: " + status +
                "| Quantidade de páginas: " + qtdPaginas +
                "| ISBN: " + isbn;
    }

    public String toStringP(double i) {
        return "Livro-->" +
                "| AUTOR: " + autor +
                "| Título: " + titulo +
                "| Status: " + status +
                "| Quantidade de páginas: " + qtdPaginas +
                "| ISBN: " + isbn +
                "| Porcentagem: " + porcentagem + "%";
    }

    public Livro() {

    }

    public Livro(Autor autor, String titulo, int status, int qtdPaginas, String isbn) {
        this.autor = autor;
        this.titulo = titulo;
        this.status = status;
        this.qtdPaginas = qtdPaginas;
        this.isbn = isbn;
    }

    public static ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public static void setListaLivros(ArrayList<Livro> listaLivros) {
        Livro.listaLivros = listaLivros;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
