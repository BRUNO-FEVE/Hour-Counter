import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

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
            //JDBC horas1 = new JDBC("123", "123", "asda att");
            //horas1.insertHours(conn);
            JDBC horas = new JDBC("123");
            ArrayList<Object[]> hoursList = new ArrayList<>();
            hoursList = horas.loadHours(conn);
            for (Object[] row : hoursList) {
                System.out.println(Arrays.toString(row));
            }
            // System.out.println(horas);
            // System.out.println("Conectado!");
            //System.out.println("RA: " + horas.getRa() + "\nHoras: " + horas.getHours() + "\nDescrição: " + horas.getDesc() + "\nid:"  + horas.getId_hours());
             // pessoa2 = new JDBC("12", "123");
            // System.out.println(pessoa2.loadLogin(conn));
             //System.out.println(pessoa2);
            // System.out.println("Conectado!");
            //System.out.println("Nome: " + pessoa2.getName() + "\nSenha: " + pessoa2.getPassword() + "\nRA: " + pessoa2.getRa() + "\nArea: " + pessoa2.getArea() + "\nProjeto: " + pessoa2.getProject() + "\nEntidade: " + pessoa2.getEntity() + "\nid:"  + pessoa2.getId());
            
        
        
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
