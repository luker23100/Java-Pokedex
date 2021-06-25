package com.dev.pokedexapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokedex/pokemons")
public class PokemonController {

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public Iterable<Pokemon> getAll(){
        return pokemonService.getAll();
    }

    @GetMapping("/page")
    public List<Pokemon> getFromTo(@RequestParam int from, @RequestParam int to){
        return pokemonService.getAll(from, to);
    }

    @GetMapping("/{id}")
    public Optional<Pokemon> getById(@PathVariable long id){
        return pokemonService.getById(id);
    }

    @PostMapping
    public Pokemon addPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.add(pokemon);
    }

    @PutMapping
    public Pokemon updatePokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.add(pokemon);
    }

    @DeleteMapping("/{id}")
    public void deletePokemonById(@RequestParam long id) {
        pokemonService.deleteById(id);
    }

}
