package com.ciclo3.Sprint3.Repositories;

import com.ciclo3.Sprint3.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTransaction extends JpaRepository<Transaction, Long> {
}
