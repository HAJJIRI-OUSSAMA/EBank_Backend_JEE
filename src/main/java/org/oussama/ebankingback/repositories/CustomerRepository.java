package org.oussama.ebankingback.repositories;

import org.oussama.ebankingback.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
