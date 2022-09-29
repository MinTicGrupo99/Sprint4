package com.ciclo3.Sprint3.Service;

import com.ciclo3.Sprint3.Models.Empresa;

import java.util.List;

public interface ServiceInterfaceEmpresa {

    public List<Empresa> getEmpresa();

    public Empresa getOnlyOneEmpresa(Long idEmpresa) throws Exception;

    public String getCreateEmpresa(Empresa empresaIn);

    public Empresa getUpdateEmpresa(Empresa empresaIn) throws Exception;

    public String getDeleteEmpresa(Long idEmpresa) throws Exception;

}
