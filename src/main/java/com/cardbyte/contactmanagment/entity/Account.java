package com.cardbyte.contactmanagment.entity;

import com.cardbyte.contactmanagment.common.constant.AccountType;
import com.cardbyte.contactmanagment.common.constant.SyncStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/*This class represent cardbyte account*/
@Table(name = "account")
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Account extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String userId;

    @Column
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column
    private String zohoAccountID;

    @Column
    private Boolean isActive;

    @Column
    private Boolean isIntegrated;

    @Column
    @Enumerated(EnumType.STRING)
    private SyncStatus syncStatus;



}
