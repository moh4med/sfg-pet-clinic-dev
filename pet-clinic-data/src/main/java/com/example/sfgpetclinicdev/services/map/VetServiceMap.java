package com.example.sfgpetclinicdev.services.map;

import com.example.sfgpetclinicdev.model.Speciality;
import com.example.sfgpetclinicdev.model.Vet;
import com.example.sfgpetclinicdev.services.SpecialityService;
import com.example.sfgpetclinicdev.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpecialty = specialityService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(object);
    }
}
