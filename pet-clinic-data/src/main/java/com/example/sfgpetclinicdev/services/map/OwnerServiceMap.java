package com.example.sfgpetclinicdev.services.map;

import com.example.sfgpetclinicdev.model.Owner;

public class OwnerServiceMap extends AbstractMapService<Owner,Long>{
    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }
}
