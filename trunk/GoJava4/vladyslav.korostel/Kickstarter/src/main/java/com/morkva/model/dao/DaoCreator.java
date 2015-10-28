package com.morkva.model.dao;

/**
 * Created by koros on 09.06.2015.
 */
public interface DaoCreator<Context> {
    DAO create(Context context);
}
