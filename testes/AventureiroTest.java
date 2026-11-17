import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AventureiroTest {

    @Test
    void naoDeveUsarPoderMaisDeDuasVezes() {

        Aventureiro aventureiro = new Aventureiro(
            "Jogador",
            new Posicao(1, 1)
        );

        char[][] labirinto = {
            {'.', '#', '.'},
            {'#', '.', '#'},
            {'.', '#', '.'}
        };

        boolean primeiroUso = aventureiro.usarPoder(labirinto);
        boolean segundoUso = aventureiro.usarPoder(labirinto);
        boolean terceiroUso = aventureiro.usarPoder(labirinto);

        assertTrue(primeiroUso);
        assertTrue(segundoUso);
        assertFalse(terceiroUso);
        assertEquals(0, aventureiro.getUsosDePoder());
    }

    @Test
    void naoDeveGastarPoderQuandoNaoHaParedeAoRedor() {

        Aventureiro aventureiro = new Aventureiro(
            "Jogador",
            new Posicao(1, 1)
        );

        char[][] labirinto = {
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
        };

        boolean resultado = aventureiro.usarPoder(labirinto);

        assertFalse(resultado);
        assertEquals(2, aventureiro.getUsosDePoder());
    }

    @Test
    void deveUsarPoderNaBordaSemCausarErroDeIndice() {

        Aventureiro aventureiro = new Aventureiro(
            "Jogador",
            new Posicao(0, 0)
        );

        char[][] labirinto = {
            {'.', '#', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
        };

        boolean resultado = aventureiro.usarPoder(labirinto);

        assertTrue(resultado);
        assertEquals('.', labirinto[0][1]);
        assertEquals(1, aventureiro.getUsosDePoder());
    }

    @Test
    void naoDeveContabilizarOMesmoTesouroDuasVezes() {

        Aventureiro aventureiro = new Aventureiro(
            "Jogador",
            new Posicao(0, 0)
        );

        Tesouro tesouro = new Tesouro(
            "Ouro",
            new Posicao(1, 1),
            100
        );

        aventureiro.coletarTesouro(tesouro);
        aventureiro.coletarTesouro(tesouro);

        assertEquals(100, aventureiro.getPontos());
    }
}