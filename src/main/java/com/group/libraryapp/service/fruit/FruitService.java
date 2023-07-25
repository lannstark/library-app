package com.group.libraryapp.service.fruit;

import com.group.libraryapp.dto.fruit.FruitCreateRequest;
import com.group.libraryapp.repository.fruit.FruitRepository;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

  private final FruitRepository fruitRepository;

  public FruitService(FruitRepository fruitRepository) {
    this.fruitRepository = fruitRepository;
  }

  public void saveFruit(FruitCreateRequest request) {
    fruitRepository.saveFruit(request.getName(), request.getPrice(), request.getDate());
  }
}
