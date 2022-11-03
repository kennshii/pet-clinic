package com.kennshi.petclinic.services;

import com.kennshi.petclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
