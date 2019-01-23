import org.junit.Test;

import java.io.File;
import src.*;
import static org.junit.Assert.*;

public class TestXYZ {
    Simulador simulador = new Simulador();
    @Test
    public void iniciaJogo() {
        File file = new File("random.txt");
        assertEquals(simulador.iniciaJogo(file),false);
    }

    @Test
    public void processaJogada() {
        assertEquals(simulador.processaJogada(0,0,4,4),false);
    }


}