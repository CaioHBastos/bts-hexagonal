package com.bancobts.apphexagonal.adapter.out.repository;

import com.bancobts.apphexagonal.adapter.out.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
