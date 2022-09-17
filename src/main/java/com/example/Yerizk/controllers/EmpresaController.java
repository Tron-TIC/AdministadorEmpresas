package com.example.Yerizk.controllers;


import com.example.Yerizk.dto.EmpresaDto;
import com.example.Yerizk.model.Empresa;
import com.example.Yerizk.services.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {

    private final EmpresaService EmpresaService;


    public EmpresaController(EmpresaService EmpresaService){this.EmpresaService = EmpresaService;}

    @GetMapping("/enterprise")
    public ResponseEntity<List<Empresa>>ListarEmpresas()
    {
        return ResponseEntity.ok().body(this.EmpresaService.ListarEmpresas());
    }


    @PostMapping ("/enterprise/crear")
    public EmpresaDto crearEmpresa(@RequestBody EmpresaDto Empresa)
    {
        return EmpresaService.save(Empresa);
    }

    @PutMapping("/enterprise/Actualizar")
    public ResponseEntity<Empresa> EmpresaUpdate (@RequestBody EmpresaDto Empresa)
    {
    return ResponseEntity.ok().body(this.EmpresaService.UpdateEmpresa(Empresa));
    }
    @DeleteMapping("/enterprise/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        EmpresaService.eliminarEmpresa(id);
    }


    }


