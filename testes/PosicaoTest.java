import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class PosicaoTest {

    @Test
    void deveConsiderarIguaisPosicoesComMesmasCoordenadas() {

        Posicao posicao1 = new Posicao(2, 3);
        Posicao posicao2 = new Posicao(2, 3);

        assertEquals(posicao1, posicao2);
    }

    @Test
    void naoDeveDuplicarPosicoesIguaisEmHashSet() {

        Set<Posicao> posicoes = new HashSet<>();

        posicoes.add(new Posicao(2, 3));
        posicoes.add(new Posicao(2, 3));

        assertEquals(1, posicoes.size());
    }
}