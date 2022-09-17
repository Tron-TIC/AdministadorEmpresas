package com.example.Yerizk.services;

import com.example.Yerizk.dto.EmpresaDto;
import com.example.Yerizk.model.Empresa;
import com.example.Yerizk.repositories.RepositorioEmpresa;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private final  RepositorioEmpresa RepositorioEmpresa;
    private Long id;

    public EmpresaService(RepositorioEmpresa RepositorioEmpresa){
    this.RepositorioEmpresa=RepositorioEmpresa;
}

       public List<Empresa> ListarEmpresas() {
        return this.RepositorioEmpresa.findAll();
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

    public void  eliminarEmpresa (Integer id) {
        RepositorioEmpresa.deleteById(Long.valueOf(id));

    }








}
