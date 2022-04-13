import java.time.chrono.MinguoDate;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        /*1- Aprovado, 2- Reprovado, 3- Aguardando revisão, 4- Em revísão, 5- Aguardando edição, 6- Publicado*/

        /*diretor pré-cadastrado!!!*/
        /*revisor também para ser mais fácil, porém, o diretor cadastra um revisor!!!*/
        /*Efetuar login ou cadastrar-se*/
        /*Analisar quantidade de páginas*/
        preCadastros();
        menuInicial();
    }

    private static void menuInicial() {
        System.out.println("--- MENU INICIAL ---" +
                "\n1 - Fazer login;" +
                "\n2 - Cadastrar-se.");
        int opcao = sc.nextInt();
        switch (opcao){
            case 1:
                login();
                break;
            case 2:
                Autor autor = (Autor) coletaDados(1);
                Pessoa.listaPessoas.add(autor);
                menu(Pessoa.listaPessoas.size() - 1);
                break;
            default:
                System.out.println("Tanço! Apertou errado!");
                menuInicial();
        }
    }

    private static void cadastroLivro(int indice) {
        System.out.println("Título: ");
        String titulo = sc.next();
        System.out.println("Quantidade de páginas: ");
        int qtdPaginas = sc.nextInt();
        System.out.println("ISBN: ");
        String isbn = sc.next();
        System.out.println("Possuí uma editora? " +
                "\n1 - Sim;" +
                "\n2 - Não.");
        int editora = sc.nextInt();
        System.out.println("Livro cadastrado com sucesso!");
        Livro livro = new Livro( (Autor) Pessoa.listaPessoas.get(indice), titulo, 3, qtdPaginas, isbn);
        Livro.listaLivros.add(livro);
        menu(indice);
    }

    private static void login() {
        int indice;
        System.out.println("E-mail:");
        String email = sc.next();
        System.out.println("CPF: ");
        String cpf = sc.next();
        System.out.println("Senha: ");
        String senha = sc.next();
        indice = verificaLogin(email, cpf, senha);
        if (indice != -1){
            menu(indice);
        }
        login();
    }

    private static void menu(int indice) {
        int tipo = tipo(indice);
        switch (tipo){
            case 1:
                System.out.println("--- MENU DIRETOR ---" +
                        "\n1 - Editar livros;" +
                        "\n2 - Listar atividades;" +
                        "\n3 - Cadastrar revisor;" +
                        "\n4 - Listar livros;" +
                        "\n5 - Sair.");
                int opcaoDiretor = sc.nextInt();
                switch (opcaoDiretor){
                    case 1:
                        editarLivros(indice);
                        break;
                    case 2:
                        listarAtividades(indice);
                        break;
                    case 3:
                        cadastrarRevisor(indice);
                        break;
                    case 4:
                        listarLivros(indice);
                        break;
                    case 5:
                        System.out.println("Deslogado com sucesso!");
                        menuInicial();
                        break;
                    default:
                        System.out.println("Tanço! Apertou errado!");
                        menu(indice);
                }
                break;
            case 2:
                System.out.println("--- MENU REVISOR ---" +
                        "\n1 - Listar atividades;" +
                        "\n2 - Listar livros aguardando edição;" +
                        "\n3 - Editar Livro;" +
                        "\n4 - Sair.");
                int opcaoRevisor = sc.nextInt();
                switch (opcaoRevisor){
                    case 1:
                        listarAtividades(indice);
                        break;
                    case 2:
                        listarLivros(indice);
                        break;
                    case 3:
                        editarLivros(indice);
                        break;
                    case 4:
                        System.out.println("Deslogado com sucesso!");
                        menuInicial();
                        break;
                    default:
                        System.out.println("Tanço! Apertou errado!");
                        menu(indice);
                }
                break;
            case 3:
                System.out.println("--- MENU AUTOR ---" +
                        "\n1 - Cadastrar livro;" +
                        "\n2 - Listar livros;" +
                        "\n3 - Editar livros;" +
                        "\n4 - Sair.");
                int opcaoAutor = sc.nextInt();

                switch (opcaoAutor){
                    case 1:
                        cadastroLivro(indice);
                        break;
                    case 2:
                        listarLivros(indice);
                        break;
                    case 3:

                        break;
                    case 4:
                        System.out.println("Deslogado com sucesso!");
                        menuInicial();
                        break;
                    default:
                        System.out.println("Tanço! Apertou errado!");
                        menu(indice);
                }
                break;
            default:
                System.out.println("Tanço! Apertou errado!");
                menu(indice);
        }

    }

    private static void editarLivros(int indice) {
        int tipo = tipo(indice);
        switch (tipo) {
            case 1:
                for (int j = 0; j < Livro.listaLivros.size(); j++) {
                    if (Livro.listaLivros.get(j).getStatus() == 1) {
                        System.out.println(Livro.listaLivros.get(j).toString());
                    }
                }
                System.out.println("Digite o ISBN do livro: ");
                String isbn = sc.next();
                int indiceLivro = verificaLivro(isbn);
                System.out.println("O que você deseja fazer? " +
                        "\n1 - Publicar o livro;" +
                        "\n2 - Reprovar o livro;" +
                        "\n3 - Aguardando revisão.");
                int opcao = sc.nextInt();
                for (int i = 0; i < Livro.listaLivros.size(); i++) {
                    if (Livro.listaLivros.get(i).getStatus() == 1) {
                        switch (opcao) {
                            case 1:
                                System.out.println("Livro publicado com sucesso!");
                                Livro.listaLivros.get(indiceLivro).setStatus(6);
                                break;
                            case 2:
                                System.out.println("Livro reprovado com sucesso!");
                                Livro.listaLivros.get(indiceLivro).setStatus(2);
                                break;
                            case 3:
                                System.out.println("Livro aguardando revisão com sucesso!");
                                Livro.listaLivros.get(indiceLivro).setStatus(3);
                                break;
                            default:
                                System.out.println("Tanço! Apertou errado!");
                                editarLivros(indice);
                        }
                    }
                }
                break;
            case 2:
                for (int j = 0; j < Livro.listaLivros.size(); j++) {
                    if (Livro.listaLivros.get(j).getStatus() == 3 || Livro.listaLivros.get(j).getStatus() == 4) {
                        System.out.println(Livro.listaLivros.get(j).toStringP(0.0));
                    }
                }
                System.out.println("Digite o ISBN do livro: ");
                isbn = sc.next();
                indiceLivro = verificaLivro(isbn);
                int statusDoLivro = Livro.listaLivros.get(indiceLivro).getStatus();
                if (statusDoLivro == 3){
                    System.out.println("O que você deseja fazer? " +
                            "\n1 - Colocar o livro em revisão.");
                    opcao = sc.nextInt();
                    switch (opcao){
                        case 1:
                            System.out.println("Livro em revisão com sucesso!");
                            Livro.listaLivros.get(indiceLivro).setStatus(4);
                            System.out.println("Em que página você parou? ");
                            int numeroPagina = sc.nextInt();
                            double mediaPaginas = (numeroPagina * 100) / Livro.listaLivros.get(indiceLivro).getQtdPaginas();
                            Livro.listaLivros.get(indiceLivro).setPorcentagem(mediaPaginas);
                            break;
                        default:
                            System.out.println("Tanço! Apertou errado!");
                            editarLivros(indice);
                    }
                } else if(statusDoLivro == 4){
                    System.out.println("O que você deseja fazer? " +
                            "\n1 - Reprovar o livro;" +
                            "\n2 - Aprovar o livro;" +
                            "\n3 - Aguardando edição.");
                    opcao = sc.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println("Livro reprovado com sucesso!");
                            Livro.listaLivros.get(indiceLivro).setStatus(2);
                            break;
                        case 2:
                            System.out.println("Livro aprovado com sucesso!");
                            Livro.listaLivros.get(indiceLivro).setStatus(1);
                            break;
                        case 3:
                            System.out.println("Livro aguardando edição com sucesso!");
                            Livro.listaLivros.get(indiceLivro).setStatus(5);
                            break;
                        default:
                            System.out.println("Tanço! Apertou errado!");
                            editarLivros(indice);
                    }
                }
                    break;
                    case 3:
                        for (int i = 0; i < Livro.listaLivros.size(); i++){
                            if (Livro.listaLivros.get(i).getStatus() == 5){
                                System.out.println(Livro.listaLivros.get(i).toString());
                            }
                        }
                        System.out.println("Digite o ISBN do livro que desejas editar: ");
                        isbn = sc.next();
                        indiceLivro = verificaLivro(isbn);
                        if (indiceLivro != -1){
                            System.out.println("Título: ");
                            Livro.listaLivros.get(indiceLivro).setTitulo(sc.next());
                            System.out.println("Quantidade de páginas: ");
                            Livro.listaLivros.get(indiceLivro).setQtdPaginas(sc.nextInt());
                            System.out.println("ISBN: ");
                            Livro.listaLivros.get(indiceLivro).setIsbn(sc.next());
                            System.out.println("Livro editado com sucesso!");
                        }
            default:
                System.out.println("Tanço! Apertou errado!");
                editarLivros(indice);
                }
                menu(indice);
        }


    private static int verificaLivro(String isbn) {
        for(int i = 0; i < Livro.listaLivros.size(); i++){
            if (Livro.listaLivros.get(i).getIsbn().equals(isbn)){
             return i;
            }
        }
        return -1;
    }

    private static void cadastrarRevisor(int indice) {
        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("Sobrenome: ");
        String sobrenome = sc.next();
        System.out.println("CPF: ");
        String cpf = sc.next();
        System.out.println("E-mail: ");
        String email = sc.next();
        System.out.println("Gênero: ");
        String genero = sc.next();
        System.out.println("Senha: ");
        String senha = sc.next();
        System.out.println("Revisor cadastrado com sucesso!");
        Pessoa revisor = new Revisor(nome,sobrenome,cpf,email,genero,senha);
        Pessoa.listaPessoas.add(revisor);
        menu(indice);
    }

    private static void listarAtividades(int indice) {
        int tipo = tipo(indice);
        switch (tipo){
            case 1:
                for (int i = 0; i < Livro.listaLivros.size(); i++) {
                    if (Livro.listaLivros.get(i).getStatus() == 1) {
                        System.out.println(Livro.listaLivros.get(i).toString());
                    }
                }
                break;
            case 2:
                for (int i = 0; i < Livro.listaLivros.size(); i++){
                    if (Livro.listaLivros.get(i).getStatus() == 4){
                        System.out.println(Livro.listaLivros.get(i).toStringP(0.0));
                    }
                }
                break;
            default:
                System.out.println("Tanço! Apertou errado!");
                listarAtividades(indice);
        }
        menu(indice);
    }

    private static void listarLivros(int indice) {
        int tipo = tipo(indice);
        switch (tipo){
            case 1:
                for (int i = 0; i < Livro.listaLivros.size(); i++){
                    System.out.println(Livro.listaLivros.get(i).toString());
                }
                break;
            case 2:
                for (int i = 0; i < Livro.listaLivros.size(); i++){
                    if (Livro.listaLivros.get(i).getStatus() == 3){
                        System.out.println(Livro.listaLivros.get(i).toStringP(0.0));
                    }
                }
                break;
            case 3:
                for (int i = 0; i < Livro.listaLivros.size(); i++){
                    if (Livro.listaLivros.get(i).getAutor() == Pessoa.listaPessoas.get(indice)){
                        System.out.println(Livro.listaLivros.get(i).toString());
                    }
                }
                break;
            default:
                System.out.println("Tanço! Apertou errado!");
                listarLivros(indice);
        }
    menu(indice);
    }

    private static int tipo(int indice){
        if (Pessoa.listaPessoas.get(indice) instanceof Diretor){
            return 1;
        } else if (Pessoa.listaPessoas.get(indice) instanceof Revisor){
            return 2;
        } else if (Pessoa.listaPessoas.get(indice) instanceof Autor){
            return 3;
        }
        return -1;
    }

    private static int verificaLogin(String email, String cpf, String senha) {
        for(int i = 0; i < Pessoa.listaPessoas.size(); i++){
            if (Pessoa.listaPessoas.get(i).getEmail().equals(email) && Pessoa.listaPessoas.get(i).getSenha().equals(senha)
            && Pessoa.listaPessoas.get(i).getCpf().equals(cpf)){
                return i;
            }
        }
        return -1;
    }

    /*1-Autor | 2-Diretor | 3-Revisor*/
    private static Pessoa coletaDados(int indice) {
        System.out.println("Nome: ");
        String nome = sc.next();
        System.out.println("Sobrenome: ");
        String sobrenome = sc.next();
        System.out.println("CPF: ");
        String cpf = sc.next();
        System.out.println("E-mail: ");
        String email = sc.next();
        System.out.println("Gênero: ");
        String genero = sc.next();
        System.out.println("Senha: ");
        String senha = sc.next();
        if (indice == 1){
            return new Autor(nome, sobrenome, cpf, email, genero, senha);
        } else if (indice == 2){
            return new Diretor(nome, sobrenome, cpf, email, genero, senha);
        } else {
            return new Revisor(nome, sobrenome, cpf, email, genero, senha);
        }
    }


    private static void preCadastros() {
        Editora editora = new Editora("Editora1", "341231");
        Pessoa diretor = new Diretor("diretor", "Um", "1", "diretor@", "masc", "1");
        Pessoa autor = new Autor("Autor1", "Um", "20000000", "autor1@gmai.com", "masc", "1");
        Livro livro = new Livro((Autor) autor, "LivroAprovado", 1, 500, "12");
        Livro livro2 = new Livro((Autor) autor, "LivroAprovado2", 1, 800, "13");
        Pessoa revisor = new Revisor("revisor", "Um", "3", "revisor@", "masc", "1");
        Editora.listaEditora.add(editora);
        Pessoa.listaPessoas.add(diretor);
        Pessoa.listaPessoas.add(autor);
        Livro.listaLivros.add(livro);
        Livro.listaLivros.add(livro2);
        Pessoa.listaPessoas.add(revisor);
    }
}
