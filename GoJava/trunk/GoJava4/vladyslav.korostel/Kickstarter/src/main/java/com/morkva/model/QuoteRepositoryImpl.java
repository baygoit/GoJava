package com.morkva.model;

import com.morkva.entities.Quote;
import com.morkva.model.dao.DAOFactory;
import com.morkva.model.dao.PersistException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by koros on 15.06.2015.
 */
public class QuoteRepositoryImpl implements QuoteRepository {

    public QuoteRepositoryImpl(DAOFactory<Connection> factory) {
        this.factory = factory;
    }

    DAOFactory<Connection> factory;

    @Override
    public Quote getRandomQuote() {
        Quote quote = null;
        try {
            List list = factory.getDao(factory.getContext(), Quote.class).getByCustomQuery(
                    "SELECT * FROM quotes ORDER BY RAND() LIMIT 0,1;");
            quote = (Quote) list.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersistException e) {
            e.printStackTrace();
        }
        return quote;
    }
}
