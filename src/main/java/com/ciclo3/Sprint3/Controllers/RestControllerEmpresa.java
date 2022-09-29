package com.ciclo3.Sprint3.Controllers;


import com.ciclo3.Sprint3.Models.Empresa;
import com.ciclo3.Sprint3.Models.ObjectAnswer;
import com.ciclo3.Sprint3.Service.ServiceInterfaceEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerEmpresa {

    @Autowired
    ServiceInterfaceEmpresa serviceInterfaceEmpresa;

    @GetMapping("/ListaEmpresa")
    public ResponseEntity <List<Empresa>> getEmpresa(){
        return new ResponseEntity<>(serviceInterfaceEmpresa.getEmpresa(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/UnaEmpresa/{idEmpresa}")
    public ResponseEntity<Object> getEmpresaPath(@PathVariable Long idEmpresa) {
        try {
            Empresa EmpresaX = serviceInterfaceEmpresa.getOnlyOneEmpresa(idEmpresa);
            return new ResponseEntity<>(EmpresaX,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/CrearEmpresa")
    public ResponseEntity<String> PostCearEmpresa(@RequestBody Empresa EmpresaX) {
        try {
            String message = serviceInterfaceEmpresa.getCreateEmpresa(EmpresaX);
            return new ResponseEntity<>(message,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ActualizarEmpresa")
    public ResponseEntity<ObjectAnswer> putActuallizarEmpresa(@RequestBody Empresa EmpresaX) {
        try {
            Empresa EmpresaBD = serviceInterfaceEmpresa.getUpdateEmpresa(EmpresaX);
            return new ResponseEntity<>(new ObjectAnswer("Actualización Empresa Exitosa", EmpresaBD), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(new ObjectAnswer(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/EliminarEmpresa/{idEmpresa}")
    public ResponseEntity<String> EliminarEmpresa(@PathVariable Long idEmpresa) {
        try {
            String message = serviceInterfaceEmpresa.getDeleteEmpresa(idEmpresa);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
