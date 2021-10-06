package com.example.sfgpetclinicdev.services.map;

import com.example.sfgpetclinicdev.model.Vet;
import com.example.sfgpetclinicdev.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }
}
