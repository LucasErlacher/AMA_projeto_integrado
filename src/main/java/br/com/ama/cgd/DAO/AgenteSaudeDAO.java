package br.com.ama.cgd.DAO;

import br.com.ama.cdp.AgenteSaude;
import br.com.ama.cdp.HorarioAtendimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgenteSaudeDAO {
    private Connection conexao;

    //--------------------------------------- CRUD básico -----------------------------------------------

    public void insert(AgenteSaude agenteSaude){
        conexao = new ConnectionFactory().getConnection();

        String query = "";

        try{
            PreparedStatement ps = conexao.prepareStatement(query);

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void alter(AgenteSaude agenteSaude){
        conexao = new ConnectionFactory().getConnection();

        String query = "";

        try{
            PreparedStatement ps = conexao.prepareStatement(query);

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByCpf(String cpf){
        conexao = new ConnectionFactory().getConnection();

        String query = "";

        try{
            PreparedStatement ps = conexao.prepareStatement(query);

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getAll(){

    }
}
