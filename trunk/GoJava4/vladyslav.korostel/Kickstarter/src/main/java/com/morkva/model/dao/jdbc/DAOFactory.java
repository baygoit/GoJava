package com.morkva.model.dao.jdbc;

import com.morkva.entities.Quote;
import com.morkva.model.dao.DAO;
import com.morkva.model.dao.PersistException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by koros on 06.06.2015.
 */
public interface DAOFactory<Context> {

    Context getContext() throws PersistException;

    DAO getDao(Context context, Class dtoClass) throws PersistException;


}
