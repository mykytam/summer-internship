package com.softserve2020practice.repositories;

import com.softserve2020practice.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
