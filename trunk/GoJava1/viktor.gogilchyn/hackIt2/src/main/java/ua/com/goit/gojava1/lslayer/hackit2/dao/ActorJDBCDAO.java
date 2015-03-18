package ua.com.goit.gojava1.lslayer.hackit2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.com.goit.gojava1.lslayer.hackit2.domain.HackitIOException;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.Actor;
import ua.com.goit.gojava1.lslayer.hackit2.domain.actor.ActorFactory;

@Configuration
public class ActorJDBCDAO {
    
    @Autowired
    ActorFactory factory;

    @Autowired
    DataSource ds;

    @Bean
    public ActorJDBCDAO getActorJDBCDAO() {
        return this;
    }

    
    public Actor load(long newId) throws HackitIOException {
        Connection connection = null;
        String loadSQL = "SELECT actors.actor_name, actors.id FROM actors WHERE actors.id=?;";
        String loadSkillsSQL = "SELECT name, value FROM skills WHERE owner = ?;";
        String loadAttributesSQL = "SELECT name, value FROM attributes WHERE owner = ?;";
        PreparedStatement loadActor = null;
        PreparedStatement loadSkills = null;
        PreparedStatement loadAttributes = null;
        try {
            connection = ds.getConnection();
            connection.setAutoCommit(false);
            loadActor = connection.prepareStatement(loadSQL);
            loadActor.setLong(1, newId);
            ResultSet result = loadActor.executeQuery();
            if (result.next()) {
                factory.setActorName(result.getString(1));
                factory.setId(result.getLong(2));
            } else {
                throw new HackitIOException("Error while loading actor, no results");
            }
            loadSkills = connection.prepareStatement(loadSkillsSQL);
            loadSkills.setLong(1, factory.getId());
            result = loadSkills.executeQuery();
            while (result.next()) {
                factory.addSkill(result.getString(1));
                if (result.getInt(2) > 1)
                    factory.incSkill(result.getString(1), result.getInt(2));
            }
            loadAttributes = connection.prepareStatement(loadAttributesSQL);
            loadAttributes.setLong(1, factory.getId());
            result = loadAttributes.executeQuery();
            while (result.next()) {
                factory.addAttribute(result.getString(1), result.getString(2));
            }
            return factory.createActor();
        } catch (Exception e) {
//            logger.warn("Error", e);
            throw new HackitIOException("Error while loading actor, something with sql: " + e.getMessage(), e);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
//                logger.warn("Error", e);
                throw new HackitIOException("Error while loading actor: Error closing connection", e);
            }
        }
    }

    public void delete(long id) throws HackitIOException {
        Connection connection = null;
        PreparedStatement deleteActor = null;
        String deleteActorSQL = "DELETE FROM actors WHERE actors.id = ?;";
        try {
            connection = ds.getConnection();
            connection.setAutoCommit(false);
            deleteActor = connection.prepareStatement(deleteActorSQL);
            deleteActor.setLong(1, id);
            deleteActor.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            throw new HackitIOException("Error while deleting actor: " + e.getMessage(), e);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                throw new HackitIOException("Error while deleting actor: Closing connection", e);
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
            connection = ds.getConnection();
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
            
            //TODO Make save skill feature
            connection.commit();
            return returnValue;

        } catch (Exception e) {
            throw new HackitIOException("Error while saving actor", e);
        } finally {
            try {
                connection.rollback();
                connection.close();
            } catch (Exception e) {
                throw new HackitIOException("Error while saving actor", e);
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
            connection = ds.getConnection();
            loadAllActors = connection.prepareStatement(loadAllActorsSQL);
            ResultSet result = loadAllActors.executeQuery();
            while (result.next()) {
                returnValue.add(this.load(result.getLong(1)));
            }
        } catch (Exception e) {
            throw new HackitIOException("Error while loading actor: " + e.getMessage(), e);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
               throw new HackitIOException("Error while loading actor: " + e.getMessage(), e);
            }
        }
        return returnValue;

    }

    
    public List<Actor> load(int howMany, int offset) throws HackitIOException {
        List<Actor> returnValue = new LinkedList<Actor>();
        Connection connection = null;
        PreparedStatement loadFewActors = null;
        String loadFewActorsSQL = "SELECT id FROM actors LIMIT ? OFFSET ?;";
        try {
            connection = ds.getConnection();
            loadFewActors = connection.prepareStatement(loadFewActorsSQL);
            loadFewActors.setInt(1, howMany);
            loadFewActors.setInt(2, offset);
            ResultSet result = loadFewActors.executeQuery();
            while (result.next()) {
                returnValue.add(this.load(result.getLong(1)));
            }
        } catch (Exception e) {
            throw new HackitIOException("Error while loading actor", e);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
               throw new HackitIOException("Error while loading actor", e);
            }
        }
        return returnValue;

    }

}