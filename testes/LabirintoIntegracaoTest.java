
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LabirintoIntegracaoTest {

    @Test
    void deveAdicionarPontosAoColetarTesouro() {

        // Preparação
        Posicao inicio = new Posicao(0, 0);
        Aventureiro jogador = new Aventureiro("Jogador", inicio);

        Tesouro tesouro = new Tesouro("Tesouro1", new Posicao(0, 1), 100);

        // Execução
        tesouro.efeito(jogador);

        // Verificação
        assertEquals(100, jogador.getPontos());
    }
    @Test
void deveDestruirParedeAoUsarPoder() {

    // Preparação
    Posicao inicio = new Posicao(1, 1);
    Aventureiro jogador = new Aventureiro("Jogador", inicio);

    char[][] labirinto = {
        {'.', '#', '.'},
        {'.', 'P', '.'},
        {'.', '.', '.'}
    };

    // Execução
    boolean resultado = jogador.usarPoder(labirinto);

    // Verificação
    assertEquals(true, resultado);
    assertEquals('.', labirinto[0][1]);
    assertEquals(1, jogador.getUsosDePoder());
}
}
