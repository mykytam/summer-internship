package com.softserve2020practice.repositories;

import com.softserve2020practice.models.Account;
import com.softserve2020practice.models.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAccountsByRole(Role role);

}
