package com.cardbyte.contactmanagment.repository;

import com.cardbyte.contactmanagment.entity.Account;
import com.cardbyte.contactmanagment.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{



}
