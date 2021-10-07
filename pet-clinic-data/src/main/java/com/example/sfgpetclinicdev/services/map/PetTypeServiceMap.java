package com.example.sfgpetclinicdev.services.map;

import com.example.sfgpetclinicdev.model.PetType;
import com.example.sfgpetclinicdev.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType,Long> implements PetTypeService {

}
