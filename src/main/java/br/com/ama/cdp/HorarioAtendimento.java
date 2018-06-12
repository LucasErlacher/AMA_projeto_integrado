/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ama.cdp;

import com.sun.org.apache.xpath.internal.operations.Equals;
import org.joda.time.LocalTime;
import org.postgresql.util.PGInterval;

public class HorarioAtendimento implements Comparable<HorarioAtendimento> {
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    private PGInterval intervalo;
    private String diaSemana;

    public void setHoraInicio(String hora){
        String[] time = hora.split(":");
        horaInicio = new LocalTime(Integer.parseInt(time[0]),
                                   Integer.parseInt(time[1]),
                                   Integer.parseInt(time[2]));

    }

    public void setHoraFinal(String hora){
        String[] time = hora.split(":");
        horaFinal = new LocalTime(Integer.parseInt(time[0]),
                                  Integer.parseInt(time[1]),
                                  Integer.parseInt(time[2]));

    }

    public void setIntervalo(String intervalo){
        String[] tokens = intervalo.split(":");

        PGInterval novo_intervalo = new PGInterval();

        novo_intervalo.setHours(Integer.parseInt(tokens[0]));
        novo_intervalo.setMinutes(Integer.parseInt(tokens[1]));
        novo_intervalo.setSeconds(Integer.parseInt(tokens[2]));

        this.intervalo = novo_intervalo;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public LocalTime getHoraInicio(){
        return horaInicio;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public PGInterval getIntervalo(){
        return intervalo;
    }

    public long getHoraInicioMilisseconds(){
        long hora = 0;
        hora += horaInicio.getHourOfDay() * 3600000;
        hora += horaInicio.getMinuteOfHour() * 60000;
        hora += horaInicio.getSecondOfMinute() * 1000;
        return hora;
    }

    public long getHoraFinalMilisseconds(){
        long hora = 0;
        hora += horaFinal.getHourOfDay() * 3600000;
        hora += horaFinal.getMinuteOfHour() * 60000;
        hora += horaFinal.getSecondOfMinute() * 1000;
        return hora;
    }

    public long getIntervaloMilisseconds(){
        long hora = 0;

        hora += intervalo.getHours() * 3600000;
        hora += intervalo.getMinutes() * 60000;
        hora += intervalo.getSeconds() * 1000;
        return hora;
    }

    @Override
    public int compareTo(HorarioAtendimento ha) {
        //horaInicio, horaFinal, intervalo,diaSemana;

        if(ha.getDiaSemana().equals(this.diaSemana) &&
           ha.getHoraFinal().isEqual(this.horaFinal) &&
           ha.getHoraInicio().isEqual(this.horaInicio)){
            return 0;
        }

        return -1;
    }
}
