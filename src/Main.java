import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    /*
    programa fica rodando ate que o usuario desej fechar
    pergunta o que o usuario deseja fazer:
        1. adicionar anotacao
        2. buscar anotacao
        3. editar anotacao
        4. apagar anotacao
        5. ver anotacoes
        6. sair
     */

    static final int ADICIONAR = 1;
    static final int BUSCAR = 2;
    static final int EDITAR = 3;
    static final int APAGAR = 4;
    static final int VER = 5;
    static final int SAIR = 6;
    static final String NOME_ARQUIVO = "bloco_save.dat";

    public static void main(String[] args){


        //Comentarios serão apenas sobre como salvar classe em arquivos
        //temos que salvar o que temos dentro do bloco de notas dentro de um arquivo
        //então temos 2 coisas que temos que ter em mente:
        //  1. O que é o bloco de notas?
        //      -> o bloco de notas é uma classe que irá armazenar várias anotações diferentes dentro delas
        //          Sendo assim, temos uma classe que irá armazenar objetos de outra classe (Anotacao)

        //  2. Como vamos armazenar o bloco de notas em um arquivo
        //      -> em java, podemos salvar uma classe diretamente em um arquivo
        //          o que significa que podemos ler desse arquivo e inicializar a classe conforme o arquivo
        //          nos informa, desse modo, se o objeto do bloco de notas tivesse, por exemplo, 5 anotações
        //          e fossemos salvar esse objeto em um arquivo, quando fossemos ler o arquivo a classe seria "recriada"
        //          com as 5 anotações anteriores
        //
        //
        // VER ARQUIVO BlocoDeNotas.java, Anotacao.java, neles há a adição do implements Serializable, um coiso que é necessário pq sim
        // VER ARQUIVO Arquivo.java, onde têm as funções/metodos de carregar e salvar o bloco de notas
        // os metodos de arquivo.java são estaticos, logo, não precisamos instanciar a classe para usa-los, podemos usa-los simplesmente
        // chamando o nomeDaClasse.metodo()
        //Exemplo: Arquivo.carregaBloco(NOME_ARQUIVO);

        Scanner sc = new Scanner(System.in);

        BlocoDeNotas bloco;

        //Tenta carregar o bloco de notas usando o nome do arquivo especificado (pode ser qualquer um)
        try{
            bloco = Arquivo.carregaBloco(NOME_ARQUIVO);
        }
        //caso tenha uma exception de FileNotFound (Arquivo não encontrado)
        //inicializamos um novo bloco de notas, uma vez que, se o arquivo não existe, significa que não
        //existiu um bloco de notas que foi salvo antes dele
        catch (FileNotFoundException e){
            bloco = new BlocoDeNotas();
        }

        //caso tenha outras exceptions, o programa fala qual foi o erro e fecha
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        boolean sair = false;
        do{

            System.out.println("""
                    1 - Adicionar anotação
                    2 - Buscar anotação
                    3 - Editar anotação
                    4 - Apagar anotação
                    5 - Ver anotaçoes
                    6 - Sair
                    """);
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha){
                case 1:
                    System.out.println("Escreva o texto que você deseja que esteja na anotação: ");
                    String texto = sc.nextLine();
                    Anotacao anotacaoParaAdicionar = new Anotacao(texto);
                    bloco.adicionar(anotacaoParaAdicionar);
                    break;
                case 2:
                    System.out.print("Digite o que você deseja buscar: ");
                    String textoParaBuscar = sc.nextLine();
                    bloco.buscar(textoParaBuscar);
                    break;
                case 3:
                    bloco.verAnotacoes();
                    System.out.print("Digite o numero da anotação que você deseja editar: ");
                    int numeroParaEditar = sc.nextInt();
                    sc.nextLine();
                    bloco.editar(numeroParaEditar);
                    break;
                case 4:
                    bloco.verAnotacoes();
                    System.out.print("Digite o numero da anotação que você deseja apagar: ");
                    int numeroParaApagar = sc.nextInt();
                    sc.nextLine();
                    bloco.apagar(numeroParaApagar);
                    break;
                case 5:
                    bloco.verAnotacoes();
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    break;

            }

        }while(sair == false);


        //ao finalizar o programa, informamos que vamos salvar o bloco de notas, informando o arquivo no qual ele será salvo
        //e o objeto que deve ser salvo no bloco de notas, nesse caso o objeto bloco que foi criado la em cima
        try {
            Arquivo.salvarBloco(NOME_ARQUIVO, bloco);
        }
        //mesma coisa, caso tenha alguma exceção, mostraremos o erro e o programa irá fechar
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}