package ua.com.goit.gojava1.lslayer.hackit2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitIOException;

public class DAOConnectionManager {
    
    public Actor load(int id) {
        Connection connection = null;
        String loadSQL = "SELECT actors.actor_name, actors.id FROM actors WHERE actors.id=?;";
        PreparedStatement loadActor = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                                                     "jdbc:postgresql://lslayer.tk:5432/goit", "goit", "goit");
            connection.setAutoCommit(false);
            loadActor = connection.prepareStatement(loadSQL);
            loadActor.setLong(1, id);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        return null;
    }

    public void save(Actor actor) {
        Connection connection = null;
        PreparedStatement saveActor = null;
        String actorSQL = "INSERT INTO actors (actor_name) VALUES (?) RETURNING actors.id;";
        PreparedStatement saveSkills = null;
        String skillSQL = "INSERT INTO skills (owner, name, value) VALUES (?, ?, ?)";
        PreparedStatement saveAttributes = null;
        String atributeSQL = "INSERT INTO attributes (owner, name, value) VALUES (?, ?, ?);";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                                                     "jdbc:postgresql://lslayer.tk:5432/goit", "goit", "goit");
            connection.setAutoCommit(false);
            saveActor = connection.prepareStatement(actorSQL);
            saveSkills = connection.prepareStatement(skillSQL);
            saveAttributes = connection.prepareStatement(atributeSQL);
            saveActor.setString(1, actor.getName());
            ResultSet generatedKeys = saveActor.executeQuery();
            if (!generatedKeys.next()) {
                throw new HackitIOException("Actor insertion failed, " + actor.getName() + " not added to base");
            }
            actor.setId(generatedKeys.getLong(1));
            for (Map.Entry<String, Integer> entry : actor.getSkills().entrySet()) {
                saveSkills.setLong(1, actor.getId());
                saveSkills.setString(2, entry.getKey());
                saveSkills.setInt(3, entry.getValue());
                if (saveSkills.executeUpdate() == 0) {
                    throw new HackitIOException("Skill insertion failed, " + actor.getName() + " not added to base");
                }
            }
            for (Map.Entry<String, String> entry : actor.getAttributes().entrySet()) {
                saveAttributes.setLong(1, actor.getId());
                saveAttributes.setString(2, entry.getKey());
                saveAttributes.setString(3, entry.getValue());
                if (saveAttributes.executeUpdate() == 0) {
                    throw new HackitIOException("Attribute insertion failed, " + actor.getName() + " not added to base");
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.commit();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}