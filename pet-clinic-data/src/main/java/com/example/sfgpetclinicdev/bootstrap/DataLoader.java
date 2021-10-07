package com.example.sfgpetclinicdev.bootstrap;

import com.example.sfgpetclinicdev.model.Owner;
import com.example.sfgpetclinicdev.model.Pet;
import com.example.sfgpetclinicdev.model.PetType;
import com.example.sfgpetclinicdev.model.Vet;
import com.example.sfgpetclinicdev.services.OwnerService;
import com.example.sfgpetclinicdev.services.PetService;
import com.example.sfgpetclinicdev.services.PetTypeService;
import com.example.sfgpetclinicdev.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    public DataLoader(OwnerService ownerService, PetService petService, VetService vetService,PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;

    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog=new PetType();
        dog.setName("dog");
        PetType petDogSaved=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("cat");
        PetType petCatSaved=petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("MiamiAddress1");
        owner1.setCity("NewYork1");
        owner1.setTelephone("01234567891");

        Pet mikesPet=new Pet();
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
        Pet owner2Pet=new Pet();
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

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
