package com.champsoft.vrms2330097.modules.agents.api.mapper;

import com.champsoft.vrms2330097.modules.agents.api.dto.AgentResponse;
import com.champsoft.vrms2330097.modules.agents.domain.model.Agent;

public class AgentApiMapper {
    public static AgentResponse toResponse(Agent a) {
        return new AgentResponse(
                a.id().value(),
                a.name(),
                a.role().name(),
                a.status().name()
        );
    }
}
