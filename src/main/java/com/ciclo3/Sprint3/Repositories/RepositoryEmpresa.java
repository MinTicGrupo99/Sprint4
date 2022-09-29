package com.ciclo3.Sprint3.Repositories;

import com.ciclo3.Sprint3.Models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryEmpresa  extends JpaRepository<Empresa,Long> {
}
