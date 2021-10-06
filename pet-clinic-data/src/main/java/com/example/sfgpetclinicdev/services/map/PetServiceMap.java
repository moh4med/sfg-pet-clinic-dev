package com.example.sfgpetclinicdev.services.map;

import com.example.sfgpetclinicdev.model.Pet;
import com.example.sfgpetclinicdev.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet,Long> implements PetService {

}
