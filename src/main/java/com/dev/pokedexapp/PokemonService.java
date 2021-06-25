package com.dev.pokedexapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Optional<Pokemon> getById(long id){
        return pokemonRepository.findById(id);
    }

    public Iterable<Pokemon> getAll() {
        return pokemonRepository.findAll();
    }

    public List<Pokemon> getAll(int from, int to){
        Pageable pageable = PageRequest.of(from, to);
        return pokemonRepository.findAll(pageable).getContent();
    }

    public Pokemon add(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    public void deleteById(long id){
        pokemonRepository.deleteById(id);
    }

}
