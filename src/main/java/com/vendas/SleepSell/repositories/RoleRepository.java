package com.vendas.SleepSell.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vendas.SleepSell.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByAuthority(String authority);
}
