package src.main.java;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Relogio {

    private int hora, minuto, segundo;

    public Relogio() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;

    }

    public Relogio(int hora, int minuto, int segundo) {
        this.configuraRelogio(hora, minuto, segundo);
    }

    public void configuraRelogio(int hora, int minuto, int segundo) {
        if ((hora >= 0 && hora <= 23) && (minuto >= 0 && minuto <= 59) && (segundo >= 0 && segundo <= 59)) {
            this.hora = hora;
            this.minuto = minuto;
            this.segundo = segundo;

        } else {
            this.hora = 0;
            this.minuto = 0;
            this.segundo = 0;
        }
    }

    public void reiniciaMeiaNoite() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }

    public String marcaIntervaloTempo(String tempoInicio, String tempoFim) {

        LocalTime inicio = LocalTime.parse(tempoInicio);
        LocalTime fim = LocalTime.parse(tempoFim);

        long horas = ChronoUnit.HOURS.between(inicio, fim);
        long minutos = ChronoUnit.MINUTES.between(inicio.plusHours(horas), fim);
        long segundos = ChronoUnit.SECONDS.between(inicio.plusHours(horas).plusMinutes(minutos), fim);

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);

    }

    public String imprimeHora() {

        return hora + ":" + minuto + ":" + segundo;

    }

    public void atualizaHoraLocal() {
        
        LocalTime agora = LocalTime.now();

        this.hora = agora.getHour();
        this.minuto = agora.getMinute();
        this.segundo = agora.getSecond();

    }
 
    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

}
