import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

public class Anotacao implements Serializable {

    public static Scanner sc = new Scanner(System.in);
    private int numero;
    private String texto;
    private boolean apagada;
    private Date data;

    public Anotacao(String textoInformado){
        texto = textoInformado;
        apagada = false;
        data = new Date();
    }

    public void editar(){
        System.out.print("O texto que você irá editar é este: ");
        System.out.println(texto);
        System.out.println("Digite o texto que você deseja: ");
        texto = sc.nextLine();
    }

    public void apagar(){
        apagada = true;
    }

    public String getTexto(){
        return texto;
    }

    public int getNumero(){
        return numero;
    }

    public boolean getApagada(){
        return apagada;
    }

    public Date getData(){
        return data;
    }

    public void setNumero(int numeroDaAnotacao){
        numero = numeroDaAnotacao;
    }

}
