package pi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {
    String url = "jdbc:mysql://localhost:3306/pidev";
    String user = "root";
    String pwd = "";


    Connection con;

    //3
    static DataBaseConfig instance;
    //1 rendre le constructeur prive
    private DataBaseConfig() {

        try {
            con = DriverManager.getConnection(url, user, pwd);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println("Probeleme de connexion");
        }
    }

    // 2 etape: de creer une methode static pour utiliser le const
    public static DataBaseConfig getinstance(){
        if(instance == null){
            instance =  new DataBaseConfig();
        }
        return instance;
    }

    public Connection getCon() {
        return con;
    }
}
