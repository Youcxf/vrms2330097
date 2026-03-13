package com.champsoft.vrms2330097.modules.agents.infrastructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "agents")
public class AgentJpaEntity {
    @Id
    public String id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String role;

    @Column(nullable = false)
    public String status;
}
