import java.io.*;

public class Arquivo {
    //vamos criar um metodo para carregar o bloco de notas
    //é necessário adicionar esse throws IOException e ClassNotFoundException pois pode ser que haja
    //algo de errado ao ler ou carregar o objeto e precisamos lidar com isso
    //no metodo main
    public static BlocoDeNotas carregaBloco(String nomeArquivo) throws IOException, ClassNotFoundException, NotSerializableException {

        //usamos fileinputStream para receber  o arquivo informado [AQUI              ] como arquivo que contêm o objeto
        FileInputStream arquivoParaCarregar = new FileInputStream(new File(nomeArquivo));

        //objectInputStream é como se estivessemos querendo obter o objeto dentro do arquivo que estamos carregando
        ObjectInputStream objetoParaCarregar = new ObjectInputStream(arquivoParaCarregar);

        //Depois que obtivermos o objeto para carregar, nos especificamos que ele seja da classe BlocoDeNotas (ou o nome da classe
        //que você criou)
        //Depois disso, nós lemos o objeto com o metodo readObject(), que irá nós retornar o objeto da classe que salvamos no
        //arquivo e irá ser retornada, garantindo que seja da classe Bloco de notas
        return (BlocoDeNotas) objetoParaCarregar.readObject();
    }

    //para salvar o bloco de notas, nós fazemos o caminho reverso, nós pegamos a classe atual e a armazenamos em um arquivo
    //Argumentos: nome do arquivo onde vai salvar, objeto para salvar
    public static void salvarBloco(String nomeArquivo, BlocoDeNotas blocoParaSalvar) throws IOException {

        //usamos fileOutputStream para especificar qual será o arquivo de output, o arquivo no qual será salva a classe
        FileOutputStream arquivoParaSalvar = new FileOutputStream(new File(nomeArquivo));

        ObjectOutputStream objetoParaSalvar = new ObjectOutputStream(arquivoParaSalvar);

        objetoParaSalvar.writeObject(blocoParaSalvar);
    }
}
