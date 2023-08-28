
package test.java;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import src.main.java.Relogio;
import java.time.LocalTime;

public class RelogioTest {
    
    @Test
    public void testIniciaRelogioComTempo() {
        Relogio relogio = new Relogio(15, 22, 37);

        assertEquals(15, relogio.getHora());
        assertEquals(22, relogio.getMinuto());
        assertEquals(37, relogio.getSegundo());
    }

    @Test
    public void testConfiguraRelogio() {
        Relogio relogio = new Relogio();
        
        relogio.configuraRelogio(15, 22, 37);

        assertEquals(15, relogio.getHora());
        assertEquals(22, relogio.getMinuto());
        assertEquals(37, relogio.getSegundo());
    }

    @Test
    public void testReiniciaMeiaNoite() {
        Relogio relogio = new Relogio(15, 22, 37);
        
        relogio.reiniciaMeiaNoite();

        assertEquals(00, relogio.getHora());
        assertEquals(00, relogio.getMinuto());
        assertEquals(00, relogio.getSegundo());

    }

    @Test
    public void testMarcaIntervaloTempo() {
        Relogio relogio = new Relogio();
        
        string resultado = relogio.marcaIntervaloTempo("12:35:20", "12:45:25");

        assertEquals("00:10:05", resultado);

    }

    @Test
    public void testImprimeHora() {
        Relogio relogio = new Relogio(12, 24, 48);

        string resultado = relogio.imprimeHora();

        assertEquals("12:24:48", resultado);

    }

    @Test
    public void testAtualizaHoraLocal() {
        Relogio relogio = new Relogio(12, 24, 48);

        relogio.atualizaHoraLocal();

        LocalTime agora = LocalTime.now();

        assertEquals(agora.getHour(), relogio.getHora());
        assertEquals(agora.getMinute(), relogio.getMinuto());
        assertEquals(agora.getSecond(), relogio.getSegundo());

    }

}
