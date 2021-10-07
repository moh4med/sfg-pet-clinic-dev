package com.example.sfgpetclinicdev.bootstrap;

import com.example.sfgpetclinicdev.model.*;
import com.example.sfgpetclinicdev.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count=petTypeService.findAll().size();
        if(count==0){
            loadData();
        }

    }


    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType petDogSaved = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType petCatSaved = petTypeService.save(cat);


        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality radiologySaved=specialityService.save(radiology);
        Speciality surgerySaved=specialityService.save(surgery);
        Speciality dentistrySaved=specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("MiamiAddress1");
        owner1.setCity("NewYork1");
        owner1.setTelephone("01234567891");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(petDogSaved);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthdate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("MiamiAddress2");
        owner2.setCity("NewYork2");
        owner2.setTelephone("01234567892");
        Pet owner2Pet = new Pet();
        owner2Pet.setPetType(petCatSaved);
        owner2Pet.setOwner(owner2);
        owner2Pet.setBirthdate(LocalDate.now());
        owner2Pet.setName("just cat name");
        owner2.getPets().add(owner2Pet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiologySaved);
        vet1.getSpecialities().add(dentistrySaved);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(surgerySaved);
        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
