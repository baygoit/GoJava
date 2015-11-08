package com.morkva.model.dao;


/**
 * Created by koros on 06.06.2015.
 */
public interface DAOFactory<Context> {

    Context getContext() throws PersistException;

    DAO getDao(Context context, Class dtoClass) throws PersistException;


}
