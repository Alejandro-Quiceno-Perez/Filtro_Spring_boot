package com.riwi.Filtro_Spring_Boot.api.controllers;

import com.riwi.Filtro_Spring_Boot.api.dto.request.UserRequest;
import com.riwi.Filtro_Spring_Boot.api.dto.response.UserResponse;
import com.riwi.Filtro_Spring_Boot.domain.entities.User;
import com.riwi.Filtro_Spring_Boot.infrastructure.abstract_services.IUserService;
import com.riwi.Filtro_Spring_Boot.util.enums.SortType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
@Controller
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private final IUserService objIUserService;

    // SWAGGER
    @Operation(
            summary = "Muestra todos los usuarios con paginación y ORDENAR",
            description = "Muestra los usuarios en una lista, está configurado para mostrar 10 elementos por página."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios recuperada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "403", description = "acceso prohibido"),
            @ApiResponse(responseCode = "500", description = "Error Interno del Servidor. Por favor contacte con soporte")
    })
    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll (
                @RequestParam(defaultValue = "1") int page,
                @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.objIUserService.getAll(page - 1, size, SortType.NONE));
    }

    @Operation(
            summary = "Muestra los usuarios por id",
            description = "Muestra al usuario por el ID enviado o solicitado por ruta, el valor no puede ser menor que 1."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios recuperada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "403", description = "acceso prohibido"),
            @ApiResponse(responseCode = "500", description = "Error Interno del Servidor. Por favor contacte con soporte")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.objIUserService.getById(id));
    }

    @Operation(
            summary = "Crea un nuevo usuario",
            description = "crear un nuevo usuario ingresando los datos requeridos"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios recuperada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "403", description = "acceso prohibido"),
            @ApiResponse(responseCode = "500", description = "Error Interno del Servidor. Por favor contacte con soporte")
    })
    @PostMapping(path = "/create")
    public ResponseEntity<UserResponse> create(@Validated @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.objIUserService.create(request));
    }

    @Operation(
            summary = "Actualizar usuario",
            description = "Actualizar un usuario ingresando los datos requeridos"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios recuperada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "403", description = "acceso prohibido"),
            @ApiResponse(responseCode = "500", description = "Error Interno del Servidor. Por favor contacte con soporte")
    })
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<UserResponse> update (@Validated @RequestBody UserRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.objIUserService.update(request, id));
    }
}
