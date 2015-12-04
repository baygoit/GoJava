package model;

import java.io.Serializable;

/**
 * Created by root on 04.11.15.
 */
public abstract class AbstractEntity implements Serializable, Cloneable {

    private Integer id;

    public AbstractEntity() {}
    public AbstractEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}