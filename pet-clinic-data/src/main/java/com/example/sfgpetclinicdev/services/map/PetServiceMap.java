package com.example.sfgpetclinicdev.services.map;

import com.example.sfgpetclinicdev.model.Pet;

public class PetServiceMap extends AbstractMapService<Pet,Long>{
    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }
}
