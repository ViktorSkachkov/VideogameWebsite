package com.example.demo.controller;

import com.example.demo.business.cases.videogames.*;
import com.example.demo.configuration.security.isauthenticated.IsAuthenticated;
import com.example.demo.domain.Videogame;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000/", allowedHeaders = "*")
@RequestMapping("/videogames")
@RequiredArgsConstructor
public class VideogameController {
    private final GetVideogamesUseCase getVideogamesUseCase;
    private final GetVideogameUseCase getVideogameUseCase;
    private final AddVideogameUseCase addVideogameUseCase;
    private final UpdateVideogameUseCase updateVideogameUseCase;
    private final DeleteVideogameUseCase deleteVideogameUseCase;
    private final GetFeaturedVideogamesUseCase getFeaturedVideogamesUseCase;
    private final GetUpcomingVideogamesUseCase getUpcomingVideogamesUseCase;

    @IsAuthenticated
    @RolesAllowed({"ROLE_EMPLOYEE", "ROLE_CUSTOMER"})
    @GetMapping("")
    public List<Videogame> GetVideogames() {
        return getVideogamesUseCase.GetVideogames();
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_EMPLOYEE", "ROLE_CUSTOMER"})
    @GetMapping("/featured")
    public List<Videogame> GetFeatured() {
        return getFeaturedVideogamesUseCase.GetFeaturedVideogames();
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_EMPLOYEE", "ROLE_CUSTOMER"})
    @GetMapping("/upcoming")
    public List<Videogame> GetUpcoming() { return getUpcomingVideogamesUseCase.GetUpcomingVideogames(); }

    @IsAuthenticated
    @RolesAllowed({"ROLE_EMPLOYEE", "ROLE_CUSTOMER"})
    @GetMapping("/{id}")
    public Videogame GetVideogame(@PathVariable(value = "id") final int id) {
        return getVideogameUseCase.GetVideogame(id);
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_EMPLOYEE"})
    @PostMapping("")
    public Videogame AddVideogame(@RequestBody @Valid Videogame videogame) {
        return addVideogameUseCase.AddVideogame(videogame);
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_EMPLOYEE"})
    @DeleteMapping("/{id}")
    public Videogame DeleteVideogame(@PathVariable(value = "id") final int id) {
        return deleteVideogameUseCase.DeleteVideogame(id);
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_EMPLOYEE"})
    @PutMapping("")
    public Videogame UpdateVideogame(@RequestBody @Valid Videogame videogame) {
        return updateVideogameUseCase.UpdateVideogame(videogame);
    }
}