package com.ciclo3.Sprint3.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Empleados")
public class Empleado {
    @Id
    private Long idEmpleado;
    @Column
    private String nombreEmpleado;
    @Column
    private String telefonoEmpleado;
    @Column
    private String emailEmpleado;


    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Roles.class,fetch = FetchType.EAGER)
    private List<Roles> rolesEmpleado;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Empresa empleadoEmpresa;
    @JsonProperty( access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany
    private List<Transaction> transactions;
    @Column
    private Date updatedAtEmpleado;
    @Column
    private Date createdAtEmpleado;

    public Empleado(Long idEmpleado, String nombreEmpleado, String telefonoEmpleado, String emailEmpleado, Date updatedAtEmpleado, Date createdAtEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.telefonoEmpleado = telefonoEmpleado;
        this.emailEmpleado = emailEmpleado;
        this.updatedAtEmpleado = updatedAtEmpleado;
        this.createdAtEmpleado = createdAtEmpleado;
    }

    public Empleado() {
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getEmailEmpleado() {
        return emailEmpleado;
    }

    public void setEmailEmpleado(String emailEmpleado) {
        this.emailEmpleado = emailEmpleado;
    }

    public List<Roles> getRolesEmpleado() {
        return rolesEmpleado;
    }

    public void setRolesEmpleado(List<Roles> rolesEmpleado) {
        this.rolesEmpleado = rolesEmpleado;
    }

    public Empresa getEmpleadoEmpresa() {
        return empleadoEmpresa;
    }

    public void setEmpleadoEmpresa(Empresa empleadoEmpresa) {
        this.empleadoEmpresa = empleadoEmpresa;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Date getUpdatedAtEmpleado() {
        return updatedAtEmpleado;
    }

    public void setUpdatedAtEmpleado(Date updatedAtEmpleado) {
        this.updatedAtEmpleado = updatedAtEmpleado;
    }

    public Date getCreatedAtEmpleado() {
        return createdAtEmpleado;
    }

    public void setCreatedAtEmpleado(Date createdAtEmpleado) {
        this.createdAtEmpleado = createdAtEmpleado;
    }
}


