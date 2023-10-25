package com.cardbyte.contactmanagment.entity;

import com.cardbyte.contactmanagment.common.constant.ActionType;
import com.cardbyte.contactmanagment.common.constant.ContactType;
import com.cardbyte.contactmanagment.common.constant.SyncStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Table(name = "contact")
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Contact extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String zohoContactId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String phoneNo;

    @Column
    private String address;

    @Column
    private String companyId;

    @Column
    private String jobTitle;

    @Column
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @Column
    private Boolean isActive;

    @Column
    private String notes;

    @Column
    @Enumerated(EnumType.STRING)
    private SyncStatus syncStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private ActionType actionType;

}
