package com.group.libraryapp.domain.hospital;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalCardController {

  private final AnimalCardService animalCardService;

  public AnimalCardController(AnimalCardService animalCardService) {
    this.animalCardService = animalCardService;
  }

  @PostMapping("/animal-card")
  public void saveAnimalCard(@RequestBody AnimalCardCreateRequest request) {
    animalCardService.createNew(request);
  }

  @GetMapping("/animal-card")
  public List<AnimalCardResponse> findAll() {
    return animalCardService.findAll();
  }

}
