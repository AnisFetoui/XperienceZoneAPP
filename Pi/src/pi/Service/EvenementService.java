package pi.Service;



import pi.config.DataBaseConfig;
import pi.model.Evenement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pi.IService.IEvent;


public class EvenementService implements IEvent {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public EvenementService() {
        connection = DataBaseConfig.getinstance().getCon();
    }

    public List<Evenement> findAll(){
        List<Evenement> evenements=new ArrayList<>();
        String sql = "SELECT * FROM evenement";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Evenement evenement=new Evenement();
                evenement.setIdEvenement (result.getInt("id_event"));
                evenement.setNomEvenement (result.getString("nom_event"));
                evenements.add(evenement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return evenements;
    }
    
    @Override
    public Evenement findById(int idEvenement){

        String sql = "SELECT * FROM evenement where id_event=? ";
        Evenement evenement=new Evenement();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idEvenement);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {

                evenement.setIdEvenement (result.getInt("id_event"));
                evenement.setNomEvenement (result.getString("nom_event"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return evenement ;
    }

   
}
