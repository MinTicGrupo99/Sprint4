package com.ciclo3.Sprint3.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Empresas")
public class Empresa {

    @Id
    private Long idEmpresa;
    @Column
    private String nombreEmpresa;
    @Column
    private String nitEmpresa;
    @Column
    private String telefonoEmpresa;
    @Column
    private String direccionEmpresa;

    @OneToMany(mappedBy = "enterpriseTransaction")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "empleadoEmpresa")
    private List<Empleado> empleados;
    @Column
    private Date createdAtEmpresa;
    @Column
    private Date updatedAtEmpresa;


    public Empresa(Long idEmpresa, String nombreEmpresa, String nitEmpresa, String telefonoEmpresa, String direccionEmpresa, Empleado empleadoEmpresa, Date createdAtEmpresa, Date updatedAtEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.nitEmpresa = nitEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.createdAtEmpresa = createdAtEmpresa;
        this.updatedAtEmpresa = updatedAtEmpresa;
    }

    public Empresa() {
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }



    public Date getCreatedAtEmpresa() {
        return createdAtEmpresa;
    }

    public void setCreatedAtEmpresa(Date createdAtEmpresa) {
        this.createdAtEmpresa = createdAtEmpresa;
    }

    public Date getUpdatedAtEmpresa() {
        return updatedAtEmpresa;
    }

    public void setUpdatedAtEmpresa(Date updatedAtEmpresa) {
        this.updatedAtEmpresa = updatedAtEmpresa;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
