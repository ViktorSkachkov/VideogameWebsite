package com.example.demo.controller;

import com.example.demo.business.cases.additions.*;
import com.example.demo.configuration.security.isauthenticated.IsAuthenticated;
import com.example.demo.domain.Addition;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/additions")
@RequiredArgsConstructor
public class AdditionController {
    private final GetAdditionsUseCase getAdditionsUseCase;
    private final GetAdditionUseCase getAdditionUseCase;
    private final AddAdditionUseCase addAdditionUseCase;
    private final DeleteAdditionUseCase deleteAdditionUseCase;
    private final UpdateAdditionUseCase updateAdditionUseCase;

    @IsAuthenticated
    @RolesAllowed({"ROLE_EMPLOYEE", "ROLE_CUSTOMER"})
    @GetMapping("")
    public List<Addition> GetAdditions() {
        return getAdditionsUseCase.GetAdditions();
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_EMPLOYEE", "ROLE_CUSTOMER"})
    @GetMapping("/{id}")
    public Addition GetAddition(@PathVariable(value = "id") final int id) {
        return getAdditionUseCase.GetAddition(id);
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_EMPLOYEE"})
    @PostMapping("")
    public Addition AddAddition(@RequestBody @Valid Addition addition) {
        return addAdditionUseCase.AddAddition(addition);
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_EMPLOYEE"})
    @PutMapping("")
    public Addition UpdateAddition(@RequestBody @Valid Addition addition) {
        return updateAdditionUseCase.UpdateAddition(addition);
    }

    @IsAuthenticated
    @RolesAllowed({"ROLE_EMPLOYEE"})
    @DeleteMapping("/{id}")
    public Addition DeleteAddition(@PathVariable(value = "id") final int id) {
        return deleteAdditionUseCase.DeleteAddition(id);
    }
}