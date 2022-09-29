package com.ciclo3.Sprint3.Controllers;

import com.ciclo3.Sprint3.Models.ObjectAnswer;
import com.ciclo3.Sprint3.Models.Transaction;
import com.ciclo3.Sprint3.Service.ServiceInterfaceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerTransaction {

    @Autowired
    ServiceInterfaceTransaction serviceInterfaceTransaction;

    @GetMapping("/ListaTransaction")
    public ResponseEntity <List<Transaction>> getTransaction(){
        return new ResponseEntity<>(serviceInterfaceTransaction.getTransaction(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/UnaTransaction/{idTransaction}")
    public ResponseEntity<Object> getTransactionPath(@PathVariable Long idTransaction) {
        try {
            Transaction TransactionX = serviceInterfaceTransaction.getOnlyOneTransaction(idTransaction);
            return new ResponseEntity<>(TransactionX,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/CrearTransaction")
    public ResponseEntity<String> PostCearTransaction(@RequestBody Transaction TransactionX) {
        try {
            String message = serviceInterfaceTransaction.getCreateTransaction(TransactionX);
            return new ResponseEntity<>(message,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ActualizarTransaction")
    public ResponseEntity<ObjectAnswer> putActualizarTransaction(@RequestBody Transaction TransactionX) {
        try {
            Transaction TransactionBD = serviceInterfaceTransaction.getUpdateTransaction(TransactionX);
            return new ResponseEntity<>(new ObjectAnswer("Actualización Transaction Exitosa", TransactionBD), HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(new ObjectAnswer(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/EliminarTransaction/{idTransaction}")
    public ResponseEntity<String> EliminarTransaction(@PathVariable Long idTransaction) {
        try {
            String message = serviceInterfaceTransaction.getDeleteTransaction(idTransaction);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
