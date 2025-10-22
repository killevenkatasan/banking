package com.example.banking.Repository;

import com.example.banking.Entity.BankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankingRepository extends JpaRepository<BankingEntity, Long> {
    List<BankingEntity> findByActiveTrue();

    @Query("SELECT b FROM BankingEntity b WHERE b.active = true")
    List<BankingEntity> findAllActiveCustomers();
    List<BankingEntity> findByIncomeGreaterThan(Long amount);
}
