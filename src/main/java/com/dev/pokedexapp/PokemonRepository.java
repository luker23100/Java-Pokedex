package com.dev.pokedexapp;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends PagingAndSortingRepository<Pokemon, Long> {

}
