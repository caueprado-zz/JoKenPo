package com.events.jokenpo.request;

import com.events.jokenpo.domain.action.Action;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActionUpdateRequest {

    private Action action;
}
