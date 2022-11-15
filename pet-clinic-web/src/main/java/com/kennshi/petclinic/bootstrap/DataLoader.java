package com.kennshi.petclinic.bootstrap;

import com.kennshi.petclinic.model.Owner;
import com.kennshi.petclinic.model.Pet;
import com.kennshi.petclinic.model.PetType;
import com.kennshi.petclinic.model.Vet;
import com.kennshi.petclinic.services.OwnerService;
import com.kennshi.petclinic.services.PetTypeService;
import com.kennshi.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Stefan cel Mare street");
        owner1.setCity("Chisinau");
        owner1.setTelephone("123456789");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Ursu");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Lana");
        owner2.setLastName("Rhodes");
        owner2.setAddress("Stefan cel Mare street");
        owner2.setCity("Chisinau");
        owner2.setTelephone("123456789");

        Pet lanasPet = new Pet();
        lanasPet.setName("Leonea");
        lanasPet.setOwner(owner2);
        lanasPet.setBirthDate(LocalDate.now());
        lanasPet.setPetType(savedCatPetType);
        owner2.getPets().add(lanasPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Johnny");
        vet2.setLastName("Sins");

        vetService.save(vet2);

        System.out.println("Loaded Vets");


    }
}
