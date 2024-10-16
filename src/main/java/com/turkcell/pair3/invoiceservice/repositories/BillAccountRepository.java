package com.turkcell.pair3.invoiceservice.repositories;

import com.turkcell.pair3.invoiceservice.entities.BillAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BillAccountRepository extends JpaRepository<BillAccount, Integer>{

    Optional<List<BillAccount>> findByCustomerId(Integer customerId);

    @Query("select b.id from BillAccount b where b.customerId = :customerId")
    Optional<List<Integer>> findIdsByCustomerId(Integer customerId);
}
