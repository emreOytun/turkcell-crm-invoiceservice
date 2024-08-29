package com.turkcell.pair3.invoiceservice.entities;

import com.turkcell.pair3.core.entities.BaseEntity;
import com.turkcell.pair3.invoiceservice.enums.EnumAccountType;
import com.turkcell.pair3.core.enums.EnumState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "bill_accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillAccount extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "cutomer_id")
    private Integer customerId;

    @Column(name = "account_number")
    private Integer accountNumber;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private EnumAccountType accountType;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EnumState status;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "billAccount")
    private List<BillAddress> billAddressList;

}
