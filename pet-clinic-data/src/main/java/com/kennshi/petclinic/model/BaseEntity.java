package com.kennshi.petclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;


}
