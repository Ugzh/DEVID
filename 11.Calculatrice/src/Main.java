import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //new Calculator();
        Connection dbConnexion;

        try{
            String url = "jdbc:mysql://localhost:3306/spa";
            dbConnexion = DriverManager.getConnection(url, "root","");
            System.out.println("Connecté");
            //modifPers(dbConnexion, 10,"Thevenin", "Ugo");
            //deletePers(dbConnexion, 11);
            /*ArrayList<Personne> allPers = getAllPers(dbConnexion);
            allPers.forEach(e-> System.out.println(e.getId() + " " + e.getFirstname() + " " + e.getLastname()));*/
            Personne personne = getPers(dbConnexion, 1);
            if(personne != null)
                System.out.println(personne.getFirstname());
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    /*private static void getAllPers(Connection connection) throws SQLException {
        String sql = "SELECT * FROM personne";
        Statement smt = connection.createStatement();
        ResultSet rs = smt.executeQuery(sql);

        while(rs.next()){
            String infos = rs.getLong("personne_id") + "|";
            infos += rs.getString("lastname") + "|";
            infos += rs.getString("firstname") + "|";
            System.out.println(infos);
        }
        rs.close();smt.close();
    }*/

    /*private static void getPers(Connection connection, long id) throws SQLException {
        String sql = "SELECT * FROM personne WHERE personne_id= ?;";
        PreparedStatement ps = connection.prepareStatement(sql); // Pour preparer le remplacement du ? par notre ID
        ps.setLong(1,id); // le 1 correspond au premier '?'
        ResultSet rs = ps.executeQuery(); // On ne passe rien en paramètre
        String infos = rs.next() ? rs.getLong("personne_id")+"|"+rs.getString("lastname")+"|"+rs.getString("firstname") : "Id :"+id+" n'existe pas";
        rs.close();ps.close();
        System.out.println(infos);
    }*/

    private static void addPers(Connection connection, String lastname, String firstname) throws SQLException{
        String sql = "INSERT INTO personne(lastname, firstname) VALUES (?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,lastname);
        ps.setString(2,firstname);
        int row = ps.executeUpdate();
        String infos = (row == 1) ? " a bien été sauvegardé" : " n'a pas été sauvegardé";
        System.out.println(lastname+" "+firstname+infos);
        ps.close();
    }

    private static void deletePers(Connection connection, long id) throws SQLException{
        String sql = "DELETE FROM personne WHERE personne_id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setLong(1,id);
        ps.executeUpdate();
        int row = ps.executeUpdate();
        String infos = (row != 0) ? " n'a pas été supprimé":" a bien été supprimé" ;
        System.out.println(id+" "+infos);
        ps.close();
    }

    /*private static void modifPers(Connection connection, long id, String lastname, String firstname) throws SQLException{
        String sql = "UPDATE personne SET lastname=?, firstname=? WHERE personne_id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,lastname);
        ps.setString(2,firstname);
        ps.setLong(3,id);
        ps.executeUpdate();
        int row = ps.executeUpdate();
        String infos = (row == 1) ? " a bien été modifié" : " n'a pas été modifié";
        System.out.println(lastname+" "+firstname+infos);
        ps.close();
    }*/

    private static ArrayList<Personne> getAllPers(Connection connection) throws SQLException{
        ArrayList<Personne> listPersonne = new ArrayList<>();
        String sql = "SELECT * FROM personne";
        Statement smt = connection.createStatement();
        ResultSet rs = smt.executeQuery(sql);

        while(rs.next()){
            Personne personne = new Personne();
            personne.setId(rs.getLong("personne_id"));
            personne.setFirstname(rs.getString("firstname"));
            personne.setLastname(rs.getString("lastname"));
            listPersonne.add(personne);
        }
        rs.close();smt.close();
        return listPersonne;
    }

    private static Personne getPers(Connection connection, long id) throws SQLException{
        Personne personne = null;

        String sql = "SELECT * FROM personne WHERE personne_id= ?;";
        PreparedStatement ps = connection.prepareStatement(sql); // Pour preparer le remplacement du ? par notre ID
        ps.setLong(1,id); // le 1 correspond au premier '?'
        ResultSet rs = ps.executeQuery(); // On ne passe rien en paramètre

        if(rs.next()){
            personne = new Personne();
            personne.setId(rs.getLong("personne_id"));
            personne.setFirstname(rs.getString("firstname"));
            personne.setLastname(rs.getString("lastname"));
        }

        return personne;

    }

    private static boolean modifPers(Connection connection, Personne personne) throws SQLException{
        String sql = "UPDATE personne SET lastname=?, firstname=? WHERE personne_id=?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,personne.getLastname());
        ps.setString(2, personne.getFirstname());
        ps.setLong(3,personne.getId());
        ps.executeUpdate();

        ps.close();
        return ps.executeUpdate() == 1;
    }

    private static long addPer(Connection connection, Personne personne) throws  SQLException{
        String sql = "INSERT INTO personne(lastname, firstname) VALUES (?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,personne.getLastname());
        ps.setString(2,personne.getLastname());
        ps.executeUpdate();
        ps.close();

        return personne.getId();
    }
}