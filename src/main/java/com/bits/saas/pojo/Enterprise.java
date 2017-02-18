package com.bits.saas.pojo;

import java.io.Serializable;

/**
 * Created by buppala on 10/02/2017.
 */
public class Enterprise implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6996729021334219361L;
	private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
