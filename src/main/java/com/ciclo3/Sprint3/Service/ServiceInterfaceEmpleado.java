package com.ciclo3.Sprint3.Service;

import com.ciclo3.Sprint3.Models.Empleado;
import com.ciclo3.Sprint3.Models.ObjectAnswer;
import com.ciclo3.Sprint3.Service.ServiceInterfaceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

public interface ServiceInterfaceEmpleado {

    public List<Empleado> getEmpleado();

    public Empleado getOnlyOneEmpleado(Long idEmpleado) throws Exception;

    public String getCreateEmpleado(Empleado EmpleadoIn);

    public Empleado getUpdateEmpleado(Empleado EmpleadoIn) throws Exception;

    public String getDeleteEmpleado(Long idEmpleado) throws Exception;

}