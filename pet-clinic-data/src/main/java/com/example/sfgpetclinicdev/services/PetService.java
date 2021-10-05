package com.example.sfgpetclinicdev.services;

import com.example.sfgpetclinicdev.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
