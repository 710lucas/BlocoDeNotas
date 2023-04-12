import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.*;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class Testes {


    BlocoDeNotas bloco = new BlocoDeNotas();

    static final String stringTeste = "teste";
    Anotacao anot = new Anotacao(Testes.stringTeste);

    @BeforeEach
    public void init(){
        anot = new Anotacao(stringTeste);
    }

    @Test
    public void testeString() {
        assertEquals("teste", anot.getTexto());

        assertFalse(anot.getApagada());
        anot.setTexto("teste2");
        assertEquals("teste2", anot.getTexto());
    }

    @Test
    public void testeNumero() {
        anot.setNumero(123);
        assertEquals(123, anot.getNumero());
    }

    @Test
    public void testeApagar() {
        try {
            anot.apagar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertTrue(anot.getApagada());
    }


    @Test
    public void testeTemTexto() {

        anot.setTexto("teste2");

        assertTrue(anot.temTexto("2"));

        assertFalse(anot.temTexto("Five Nights at freddy's"));
    }

    @Test
    public void testeBloco(){
        bloco.adicionar(anot);
        assertTrue(bloco.getAnotacoes().contains(anot));
        Anotacao anot2 = new Anotacao("Teste123");
        assertFalse(bloco.getAnotacoes().contains(anot2));
        Anotacao anot3 = new Anotacao(stringTeste);
        assertFalse(bloco.getAnotacoes().contains(anot3));
    }

    @Test
    public void testeEditar(){
        BlocoDeNotas novoBloco = new BlocoDeNotas();
        novoBloco.adicionar(anot);
        anot.setNumero(novoBloco.getAnotacoes().indexOf(anot));

        anot.setTexto("teste2");
        assertEquals(anot.getTexto(), novoBloco.getAnotacoes().get(anot.getNumero()).getTexto());

        novoBloco.getAnotacoes().get(anot.getNumero()).setTexto("teste3");
        assertEquals(anot.getTexto(), novoBloco.getAnotacoes().get(anot.getNumero()).getTexto());

    }

    @Test
    public void testeBlocoApagar() throws Exception {
        BlocoDeNotas novoBloco = new BlocoDeNotas();
        novoBloco.adicionar(anot);
        anot.setNumero(novoBloco.getAnotacoes().indexOf(anot));

        novoBloco.getAnotacoes().get(anot.getNumero()).apagar();
        assertTrue(anot.getApagada());
    }

    @Test
    public void testeBlocoNumero(){
        BlocoDeNotas novoBloco = new BlocoDeNotas();
        novoBloco.adicionar(anot);
        anot.setNumero(novoBloco.getAnotacoes().indexOf(anot));
        assertEquals(anot.getNumero(), novoBloco.getAnotacoes().indexOf(anot));
    }





}
