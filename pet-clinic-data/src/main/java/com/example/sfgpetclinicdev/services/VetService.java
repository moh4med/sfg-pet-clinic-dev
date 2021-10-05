package com.example.sfgpetclinicdev.services;

import com.example.sfgpetclinicdev.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
