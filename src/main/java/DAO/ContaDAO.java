package DAO;

import projeto.Conta;
import java.sql.*;

public class ContaDAO {
    
    
    public Connection Conectar(){
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Gerenciador", "postgres", "nathan" );
        } catch (ClassNotFoundException | SQLException ex){
        }
        return con;        
    }
    
    
    public void Desconectar(Connection con) {
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException e) {
        }
    }
    
    public void Salvar(Conta nova) {
        Connection con = Conectar();
        try {
            String inserir = "insert into conta(nome, email, cpf, banco, saldo) values (?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(inserir);
            stm.setString(1, nova.getNome());
            stm.setString(2, nova.getEmail());
            stm.setString(3, nova.getCpf());
            stm.setString(4, nova.getBanco());  
            stm.setString(5, nova.getSaldo());
            stm.execute();                                           
        } catch (SQLException e) {
        } finally{
            Desconectar(con);
        }
    }
        
    public void Editar(Conta conta, int id){
        Connection con = Conectar();
        try {
            String editar = "update conta set nome = ?, email = ?, cpf = ?, banco = ?, saldo = ? where id ="+id;
            PreparedStatement stm = con.prepareStatement(editar);
            stm.setString(1, conta.getNome());
            stm.setString(2, conta.getEmail());
            stm.setString(3, conta.getCpf());
            stm.setString(4, conta.getBanco());
            stm.setString(5, conta.getSaldo());
            stm.execute();
        } catch (SQLException e) {
        } finally{
            Desconectar(con);
        }
        
    }
        
    public ResultSet ConsultarTodas() {
        ResultSet rs = null;
        Connection con = Conectar();
        try {
            String consulta = "select * from conta order by id";
            PreparedStatement pstm = con.prepareStatement(consulta);
            rs = pstm.executeQuery();
        } catch (SQLException e) {
        } finally{
            Desconectar(con);
        }
        return rs;
    } 
    
    public ResultSet Consultar(int id) {
        ResultSet rs = null;
        Connection con = Conectar();
        try {
            String consulta = "select * from conta where id =" + id;
            PreparedStatement pstm = con.prepareStatement(consulta);
            rs = pstm.executeQuery();
        } catch (SQLException e) {
        } finally{
            Desconectar(con);
        }
        return rs;
    }
        
    public void Excluir(int id) {
        Connection con = Conectar();
        try {
            String exclui = "delete from conta where id =" + id;
            PreparedStatement pstm = con.prepareStatement(exclui);
            pstm.executeQuery();
        } catch (SQLException e) {
        } finally {
            Desconectar(con);
        }
    }
    
     
  }