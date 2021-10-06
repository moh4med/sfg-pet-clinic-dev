package com.example.sfgpetclinicdev.services.map;

import com.example.sfgpetclinicdev.model.Owner;
import com.example.sfgpetclinicdev.services.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
