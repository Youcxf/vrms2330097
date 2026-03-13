package com.champsoft.vrms2330097.modules.registration.domain.model;

public record AgentRef(String value) {
    public AgentRef {
        if (value == null) throw new IllegalArgumentException("agentId is required");
        value = value.trim();
        if (value.isEmpty()) throw new IllegalArgumentException("agentId is required");
    }
}
