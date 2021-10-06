package com.example.sfgpetclinicdev.services;

import com.example.sfgpetclinicdev.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
