package com.group.libraryapp.controller.fruit;

import com.group.libraryapp.dto.fruit.FruitCreateRequest;
import com.group.libraryapp.service.fruit.FruitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController {

  private final FruitService fruitService;

  public FruitController(FruitService fruitService) {
    this.fruitService = fruitService;
  }

  @PostMapping("/fruit")
  public void saveFruit(@RequestBody FruitCreateRequest request) {
    fruitService.saveFruit(request);
  }

}
