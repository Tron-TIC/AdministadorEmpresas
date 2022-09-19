package com.example.Yerizk.controllers;

import com.example.Yerizk.services.EmpresaService;
import com.example.Yerizk.services.EmpleadoService;
import com.example.Yerizk.model.Empresa;
import com.example.Yerizk.model.MovimientoDinero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MovimientoDineroController {

    private final EmpleadoService EmpleadoService;
    private final EmpresaService EmpresaService;
    

    public MovimientoDineroController(EmpresaService EmpresaService, EmpleadoService EmpleadoService){
        this.EmpresaService = EmpresaService;
        this.EmpleadoService = EmpleadoService;
    }

    @GetMapping("/enterprises/movimientos")
    public ResponseEntity<List<MovimientoDinero>> ListarEmpresas(){
        return ResponseEntity.ok().body(this.EmpresaService.ListarMovimientos());
    }

    @PostMapping("/enterprises/movements")
    public MovimientoDinero crearMovimiento(@RequestBody MovimientoDinero Movimiento)
    {
        return EmpresaService.saveMovimiento(Movimiento);
    }

    @PutMapping("/enterprises/movements/{id}")
    public ResponseEntity<MovimientoDinero> MovimientoDineroUpdate (@RequestBody MovimientoDinero Movimiento)
    {
    return ResponseEntity.ok().body(this.EmpresaService.updateMovimiento(Movimiento));
    }

    @DeleteMapping("/enterprises/movements/{id}")
    public void eliminar(@PathVariable("id") Integer id)
    {
        EmpresaService.eliminarMovimiento(id);
    }
}