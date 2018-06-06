package br.com.ama.application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.ama.cdp.AgenteSaude;
import br.com.ama.cdp.ESexo;
import br.com.ama.cdp.EUsuario;
import br.com.ama.cdp.HorarioAtendimento;
import br.com.ama.cgd.DAO.AgenteSaudeDAO;
import br.com.ama.cgd.DAO.ConnectionFactory;
import br.com.ama.cgd.DAO.HorarioAtendimentoDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tarcisio
 */
public class Main {
    public static void main(String[] args){

        AgenteSaude as = new AgenteSaude(1,"13989292714","12345678", Calendar.getInstance(), "Caio", "caio@gmail.com",
                EUsuario.AGENTESAUDE, ESexo.MASCULINO, "87655431");

        ArrayList<HorarioAtendimento> al = (ArrayList<HorarioAtendimento>) new HorarioAtendimentoDAO().getAll();
        //ArrayList<HorarioAtendimento> al = (ArrayList<HorarioAtendimento>) new AgenteSaudeDAO().getHorarioAtendimento(as);

        for (HorarioAtendimento ha:
             al) {
            System.out.println(ha.getHoraInicio().toString() + " " + ha.getHoraFinal().toString() + " " + ha.getDiaSemana());
        }
    }
}
