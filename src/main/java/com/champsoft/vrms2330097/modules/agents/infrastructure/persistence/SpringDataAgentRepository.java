package com.champsoft.vrms2330097.modules.agents.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAgentRepository extends JpaRepository<AgentJpaEntity, String> {
    boolean existsByNameIgnoreCase(String name);
}
