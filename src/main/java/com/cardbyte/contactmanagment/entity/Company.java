package com.cardbyte.contactmanagment.entity;

import com.cardbyte.contactmanagment.common.constant.SyncStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/*This class represent zoho or crm account module(which contain company or org related info) not regular account*/
@Table(name = "company")
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Company extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String userId;

    @Column
    private String zohoAccountID;

/*
    Company name should be unique
*/
    @Column(unique = true)
    private String name;

    @Column
    private String type;

    @Column
    private String industry;

    @Column
    private String website;

    @Column
    private String phoneNo;

    @Column
    private String address;

    @Column
    private String description;

    @Column
    private String contactPerson;

    @Column
    private Boolean isActive;

    @Column
    @Enumerated(EnumType.STRING)
    private SyncStatus syncStatus;

}
