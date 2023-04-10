import static org.junit.Assert.*;

public class Testes {

    public static void main(String[] args){

        System.out.println("inicio dos testes");
        BlocoDeNotas bloco = new BlocoDeNotas();

        final String stringTeste = "teste";

        Anotacao anot = new Anotacao(stringTeste);

        assertEquals("teste", anot.getTexto());

        assertEquals(false, anot.getApagada());

        anot.setNumero(123);

        assertEquals(123, anot.getNumero());

        try {
            anot.apagar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertEquals(true, anot.getApagada());


        anot.setTexto("teste2");
        assertEquals("teste2", anot.getTexto());
        assertEquals(true, anot.temTexto("2"));

        assertEquals(false, anot.temTexto("Five Nights at freddy's"));

        System.out.println("fim dos testes");


    }

}
