package com.example.Yerizk.services;

import com.example.Yerizk.dto.EmpresaDto;
import com.example.Yerizk.model.Empresa;
import com.example.Yerizk.model.MovimientoDinero;
import com.example.Yerizk.repositories.RepositorioEmpresa;
import com.example.Yerizk.repositories.RepositorioMovimientoDinero;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private final  RepositorioEmpresa RepositorioEmpresa;
    private final RepositorioMovimientoDinero RepositorioMovimientoDinero;
    private Long id;

    public EmpresaService(RepositorioEmpresa RepositorioEmpresa, RepositorioMovimientoDinero RepositorioMovimientoDinero){
      this.RepositorioEmpresa=RepositorioEmpresa;
      this.RepositorioMovimientoDinero = RepositorioMovimientoDinero;
    }

    public List<Empresa> ListarEmpresas() {
      return this.RepositorioEmpresa.findAll();
    }

    public List<MovimientoDinero> ListarMovimientos(){
      return this.RepositorioMovimientoDinero.findAll();
    }

    public  EmpresaDto save(EmpresaDto Empresa) {
      Empresa nuevaEmpresa = new Empresa();
      nuevaEmpresa.setTelefono(Empresa.getTelefono());
      nuevaEmpresa.setDireccion(Empresa.getDireccion());
      nuevaEmpresa.setNit(Empresa.getNit());
      nuevaEmpresa.setNombre(Empresa.getNombre());
      this.RepositorioEmpresa.save(nuevaEmpresa);
      return Empresa;
    }

    public MovimientoDinero saveMovimiento(MovimientoDinero movimientoDinero){
      MovimientoDinero nuevoMovimiento = new MovimientoDinero();
      nuevoMovimiento.setMontoDinero(movimientoDinero.getMontoDinero());
      nuevoMovimiento.setMontoPositivo(movimientoDinero.getMontoPositivo());
      nuevoMovimiento.setMontoNegativo(movimientoDinero.getMontoNegativo());
      nuevoMovimiento.setUsuarioEncargado(movimientoDinero.getUsuarioEncargado());
      this.RepositorioMovimientoDinero.save(nuevoMovimiento);
      return movimientoDinero;
    }

    public Empresa UpdateEmpresa (EmpresaDto Empresa){
      Optional<Empresa> EmpresaUpdate = this.RepositorioEmpresa.findById(Empresa.getId());
      if(EmpresaUpdate.isPresent()){
        EmpresaUpdate.get().setTelefono(Empresa.getTelefono());
        EmpresaUpdate.get().setDireccion(Empresa.getDireccion());
        EmpresaUpdate.get().setNit(Empresa.getNit());
        EmpresaUpdate.get().setNombre(Empresa.getNombre());
        this.RepositorioEmpresa.save(EmpresaUpdate.get());
        return EmpresaUpdate.get();

      }
      return new Empresa();
    }

    public MovimientoDinero updateMovimiento(MovimientoDinero movimientoDinero){
      Optional<MovimientoDinero> MovimientoUpdate = this.RepositorioMovimientoDinero.findById(movimientoDinero.getId());
      if(MovimientoUpdate.isPresent()){
        MovimientoUpdate.get().setMontoDinero(movimientoDinero.getMontoDinero());
        MovimientoUpdate.get().setMontoPositivo(movimientoDinero.getMontoPositivo());
        MovimientoUpdate.get().setMontoNegativo(movimientoDinero.getMontoNegativo());
        MovimientoUpdate.get().setUsuarioEncargado(movimientoDinero.getUsuarioEncargado());
        this.RepositorioMovimientoDinero.save(MovimientoUpdate.get());
        return MovimientoUpdate.get();
      }
      return new MovimientoDinero();
    }

    public void  eliminarEmpresa (Integer id) {
      RepositorioEmpresa.deleteById(Long.valueOf(id));

    }

    public void  eliminarMovimiento (Integer id) {
      RepositorioMovimientoDinero.deleteById(Long.valueOf(id));

    }








}
