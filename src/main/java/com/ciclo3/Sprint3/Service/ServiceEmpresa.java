package com.ciclo3.Sprint3.Service;

import com.ciclo3.Sprint3.Models.Empresa;
import com.ciclo3.Sprint3.Repositories.RepositoryEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEmpresa implements  ServiceInterfaceEmpresa {

    Date Today = new Date();

    @Autowired
    RepositoryEmpresa repositoryEmpresa;


    @Override
    public List<Empresa> getEmpresa() {
        return repositoryEmpresa.findAll();
    }

    @Override
    public Empresa getOnlyOneEmpresa(Long idEmpresa) throws Exception {

        Optional<Empresa> EmpresaBD = repositoryEmpresa.findById(idEmpresa);
        if(EmpresaBD.isPresent()){
        return EmpresaBD.get() ;
        }
        throw new Exception("idEmpresa no asignado");
    }

    @Override
    public String getCreateEmpresa(Empresa empresaIn) {

        Optional<Empresa> EmpresaBD = repositoryEmpresa.findById(empresaIn.getIdEmpresa());
        if (!EmpresaBD.isPresent()){
            repositoryEmpresa.save(empresaIn);
            return "Empresa Creada con Exito";
        }
        return ("Ese Id ya se encuentra registrado");

    }

    @Override
    public Empresa getUpdateEmpresa(Empresa empresaIn) throws Exception {

        Empresa EmpresaBD = getOnlyOneEmpresa(empresaIn.getIdEmpresa());
        if (empresaIn.getNombreEmpresa() != null && !empresaIn.getNombreEmpresa().equals("")) {
            EmpresaBD.setNombreEmpresa(empresaIn.getNombreEmpresa());
        }

        if (empresaIn.getNitEmpresa() != null && !empresaIn.getNitEmpresa().equals("")) {
            EmpresaBD.setNitEmpresa(empresaIn.getNitEmpresa());
        }

        if (empresaIn.getDireccionEmpresa() != null && !empresaIn.getDireccionEmpresa().equals("")) {
            EmpresaBD.setDireccionEmpresa(empresaIn.getDireccionEmpresa());
        }

        if (empresaIn.getTelefonoEmpresa() != null && !empresaIn.getTelefonoEmpresa().equals("")) {
            EmpresaBD.setTelefonoEmpresa(empresaIn.getTelefonoEmpresa());
        }

        EmpresaBD.setUpdatedAtEmpresa(Today);

        return repositoryEmpresa.save(EmpresaBD);
    }

    @Override
    public String getDeleteEmpresa(Long idEmpresa) throws Exception {

        Optional<Empresa> EmpresaBD = repositoryEmpresa.findById(idEmpresa);
        if (EmpresaBD.isPresent()){
            repositoryEmpresa.deleteById(idEmpresa);
            return "Empresa Eliminada con Exito";
        }
        throw new Exception("Empresa no encontrada");
    }
}
