package com.softserve2020practice.repositories;

import com.softserve2020practice.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
