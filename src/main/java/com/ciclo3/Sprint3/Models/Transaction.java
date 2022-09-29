package com.ciclo3.Sprint3.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
        @Table(name="Transactiones")
public class Transaction {
    //movimientoDinero

    @Id
    private Long idTransaction;
    @Column
    private String conceptTransaction;
    @Column
    private float amountTransaction;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Empleado EmployeeTransaction;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Empresa enterpriseTransaction;
    @Column
    private Date createdAtTransaction;
    @Column
    private Date updatedAtTransaction;


    public Transaction(Long idTransaction, String conceptTransaction, float amountTransaction, Date createdAtTransaction, Date updatedAtTransaction) {
        this.idTransaction = idTransaction;
        this.conceptTransaction = conceptTransaction;
        this.amountTransaction = amountTransaction;
        this.createdAtTransaction = createdAtTransaction;
        this.updatedAtTransaction = updatedAtTransaction;
    }

    public Transaction() {
    }

    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getConceptTransaction() {
        return conceptTransaction;
    }

    public void setConceptTransaction(String conceptTransaction) {
        this.conceptTransaction = conceptTransaction;
    }

    public float getAmountTransaction() {
        return amountTransaction;
    }

    public void setAmountTransaction(float amountTransaction) {
        this.amountTransaction = amountTransaction;
    }

    public Empleado getEmployeeTransaction() {
        return EmployeeTransaction;
    }

    public void setEmployeeTransaction(Empleado employeeTransaction) {
        EmployeeTransaction = employeeTransaction;
    }

    public Empresa getEnterpriseTransaction() {
        return enterpriseTransaction;
    }

    public void setEnterpriseTransaction(Empresa enterpriseTransaction) {
        this.enterpriseTransaction = enterpriseTransaction;
    }

    public Date getCreatedAtTransaction() {
        return createdAtTransaction;
    }

    public void setCreatedAtTransaction(Date createdAtTransaction) {
        this.createdAtTransaction = createdAtTransaction;
    }

    public Date getUpdatedAtTransaction() {
        return updatedAtTransaction;
    }

    public void setUpdatedAtTransaction(Date updatedAtTransaction) {
        this.updatedAtTransaction = updatedAtTransaction;
    }
}
