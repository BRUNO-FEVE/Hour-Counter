import java.sql.SQLException;

import back.sql.ConectDB;
import back.sql.JDBC;
import java.sql.Connection;

public class Test_sql {
    public static void main(String[] args){
        Connection conn = null;
        try{
            ConectDB db = new ConectDB();
            conn = db.conect();
            /*JDBC pessoa = new JDBC("Gabriel", "senha123", "20.00822-8", "Dev", "TI", "Projeto");
            pessoa.insertLogin(conn);
            System.out.println(pessoa);
            System.out.println("Conectado!");*/
            /*JDBC horas = new JDBC("3", "2", "Feito att");
            horas.insertHours(conn);
            System.out.println(horas);
            System.out.println("Conectado!");*/
            JDBC pessoa2 = new JDBC("12", "123");
            System.out.println(pessoa2.loadLogin(conn));
            System.out.println(pessoa2);
            System.out.println("Conectado!");
            System.out.println("Nome: " + pessoa2.getName() + "\nSenha: " + pessoa2.getPassword() + "\nRA: " + pessoa2.getRa() + "\nArea: " + pessoa2.getArea() + "\nProjeto: " + pessoa2.getProject() + "\nEntidade: " + pessoa2.getEntity() + "\nid:"  + pessoa2.getId());
            
        
        
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e1){
                    System.out.print(e1.getStackTrace());
                }
            }
        }
}
}
