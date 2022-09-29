package com.ciclo3.Sprint3.Service;

import com.ciclo3.Sprint3.Models.Empleado;
import com.ciclo3.Sprint3.Repositories.RepositoryEmpleado;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ServiceEmpleado implements ServiceInterfaceEmpleado {


    Date Today = new Date();

    @Autowired
    RepositoryEmpleado repositoryEmpleado;


    @Override
    public List<Empleado> getEmpleado() {
        return repositoryEmpleado.findAll();
    }

    @Override
    public Empleado getOnlyOneEmpleado(Long idEmpleado) throws Exception {

        Optional<Empleado> EmpleadoBD = repositoryEmpleado.findById(idEmpleado);
        if(EmpleadoBD.isPresent()){
            return EmpleadoBD.get() ;
        }
        throw new Exception("idEmpleado no asignado");
    }

    @Override
    public String getCreateEmpleado(Empleado EmpleadoIn) {

        Optional<Empleado> EmpleadoBD = repositoryEmpleado.findById(EmpleadoIn.getIdEmpleado());
        if (!EmpleadoBD.isPresent()){
            repositoryEmpleado.save(EmpleadoIn);
            return "Empleado Creada con Exito";
        }
        return ("Ese Id ya se encuentra registrado");

    }

    @Override
    public Empleado getUpdateEmpleado(Empleado EmpleadoIn) throws Exception {

        Empleado EmpleadoBD = getOnlyOneEmpleado(EmpleadoIn.getIdEmpleado());
        if (EmpleadoIn.getNombreEmpleado() != null && !EmpleadoIn.getNombreEmpleado().equals("")) {
            EmpleadoBD.setNombreEmpleado(EmpleadoIn.getNombreEmpleado());
        }

        if(EmpleadoIn.getEmailEmpleado()!=null && !EmpleadoIn.getEmailEmpleado().equals("")){
            EmpleadoBD.setEmailEmpleado(EmpleadoIn.getEmailEmpleado());
        }

        if(EmpleadoIn.getRolesEmpleado()!=null && !EmpleadoIn.getRolesEmpleado().equals("")){
            EmpleadoBD.setRolesEmpleado(EmpleadoIn.getRolesEmpleado());
        }

        if (EmpleadoIn.getTelefonoEmpleado() != null && !EmpleadoIn.getTelefonoEmpleado().equals("")) {
            EmpleadoBD.setTelefonoEmpleado(EmpleadoIn.getTelefonoEmpleado());
        }

        EmpleadoBD.setUpdatedAtEmpleado(Today);

        return repositoryEmpleado.save(EmpleadoBD);
    }

    @Override
    public String getDeleteEmpleado(Long idEmpleado) throws Exception {

        Optional<Empleado> EmpleadoBD = repositoryEmpleado.findById(idEmpleado);
        if (EmpleadoBD.isPresent()){
            repositoryEmpleado.deleteById(idEmpleado);
            return "Empleado Eliminada con Exito";
        }
        throw new Exception("Empleado no encontrada");
    }
}


