package com.events.jokenpo.mapper;

import com.events.jokenpo.domain.action.Action;
import com.events.jokenpo.response.ActionResponse;
import org.springframework.stereotype.Component;

@Component
public final class ActionMapper {

    public static ActionResponse toResponse(final Action action) {
        return null;
    }

    public static Action toModel(final ActionResponse actionResponse) {
        return null;
    }
}
