package com.morkva.model.dao;

import java.io.Serializable;

/**
 * Created by koros on 15.06.2015.
 */
public interface Identified<PK extends Serializable> {
    PK getId();
}
