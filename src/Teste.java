import java.sql.SQLException;
import java.sql.Connection;

public class Teste {
    public static void main(String[] args){
        Connection conn = null;
        try{
            ConectDB db = new ConectDB();
            conn = db.conect();
            JDBC pessoa = new JDBC("Gabriel", "senha123", "20.008.22-8", "Dev", "TI", "Projeto");
            pessoa.insert(conn);
            System.out.println(pessoa);
            System.out.println("Conectado!");
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
