package ua.com.goit.gojava1.lslayer.hackit2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ua.com.goit.gojava1.lslayer.hackit2.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.actor.HumanControlledCharacter;
import ua.com.goit.gojava1.lslayer.hackit2.exception.HackitIOException;

public class ActorJDBCDAO {
    
    public Actor load(long newId) throws HackitIOException {
        Connection connection = null;
        Actor returnValue;
        String loadSQL = "SELECT actors.actor_name, actors.id FROM actors WHERE actors.id=?;";
        String loadSkillsSQL = "SELECT name, value FROM skills WHERE owner = ?;";
        String loadAttributesSQL = "SELECT name, value FROM attributes WHERE owner = ?;";
        PreparedStatement loadActor = null;
        PreparedStatement loadSkills = null;
        PreparedStatement loadAttributes = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                                                     "jdbc:postgresql://lslayer.tk:5432/goit", "goit", "goit");
            connection.setAutoCommit(false);
            loadActor = connection.prepareStatement(loadSQL);
            loadActor.setLong(1, newId);
            ResultSet result = loadActor.executeQuery();
            if (result.next()) {
                returnValue = new HumanControlledCharacter(result.getString(1));
                returnValue.setId(result.getLong(2));
            } else {
                throw new HackitIOException("Error while loading actor");
            }
            loadSkills = connection.prepareStatement(loadSkillsSQL);
            loadSkills.setLong(1, returnValue.getId());
            result = loadSkills.executeQuery();
            while (result.next()) {
                returnValue.addSkill(result.getString(1));
                if (result.getInt(2) > 1) returnValue.incSkill(result.getString(1), result.getInt(2));
            }
            loadAttributes = connection.prepareStatement(loadAttributesSQL);
            loadAttributes.setLong(1, returnValue.getId());
            result = loadAttributes.executeQuery();
            while (result.next()) {
                returnValue.addAttribute(result.getString(1), result.getString(2));
            }
            return returnValue;
        } catch (Exception e) {
            throw new HackitIOException("Error while loading actor", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new HackitIOException("Error while loading actor", e);
            }
        }
    }
    
    public void delete(long id) throws HackitIOException {
        Connection connection = null;
        PreparedStatement deleteActor = null;
        String deleteActorSQL = "DELETE FROM actors WHERE actors.id = ?;";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                                                     "jdbc:postgresql://lslayer.tk:5432/goit", "goit", "goit");
            connection.setAutoCommit(false);
            deleteActor = connection.prepareStatement(deleteActorSQL);
            deleteActor.setLong(1, id);
            deleteActor.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            throw new HackitIOException("Error while deleting actor", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new HackitIOException("Error while deleting actor", e);
            }
        }

    }

    public long save(Actor actor) throws HackitIOException {
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
            long returnValue = generatedKeys.getLong(1);
            for (Map.Entry<String, Integer> entry : actor.getSkills().entrySet()) {
                saveSkills.setLong(1, returnValue);
                saveSkills.setString(2, entry.getKey());
                saveSkills.setInt(3, entry.getValue());
                if (saveSkills.executeUpdate() == 0) {
                    throw new HackitIOException("Skill insertion failed, " + actor.getName() + " not added to base");
                }
            }
            for (Map.Entry<String, String> entry : actor.getAttributes().entrySet()) {
                saveAttributes.setLong(1, returnValue);
                saveAttributes.setString(2, entry.getKey());
                saveAttributes.setString(3, entry.getValue());
                if (saveAttributes.executeUpdate() == 0) {
                    throw new HackitIOException("Attribute insertion failed, " + actor.getName() + " not added to base");
                }
            }
            connection.commit();
            return returnValue;
            
        } catch (Exception e) {
            throw new HackitIOException("Error while loading actor", e);
        } finally {
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException e) {
                throw new HackitIOException("Error while loading actor", e);
            }
        }
    }
    
    public Actor update(Actor whom) throws HackitIOException {
        this.delete(whom.getId());
        long newId = this.save(whom);
        return this.load(newId);
    }
    
    public List<Actor> loadAll() throws HackitIOException {
        List<Actor> returnValue = new LinkedList<Actor>();
        Connection connection = null;
        PreparedStatement loadAllActors = null;
        String loadAllActorsSQL = "SELECT id FROM actors;";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                                                     "jdbc:postgresql://lslayer.tk:5432/goit", "goit", "goit");
            loadAllActors = connection.prepareStatement(loadAllActorsSQL);
            ResultSet result = loadAllActors.executeQuery();
            while (result.next()) {
                returnValue.add(this.load(result.getLong(1)));
            }
        } catch (Exception e) {
            throw new HackitIOException("Error while loading actor", e);
        }
        return null;


    }
    
    
}