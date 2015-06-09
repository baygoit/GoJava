package com.morkva.model.dao.jdbc;

import com.morkva.model.dao.DAO;

/**
 * Created by koros on 09.06.2015.
 */
public interface DaoCreator<Context> {
    DAO create(Context context);
}
