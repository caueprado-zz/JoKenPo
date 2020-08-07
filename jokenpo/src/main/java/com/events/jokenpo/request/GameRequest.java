package com.events.jokenpo.request;

import com.events.jokenpo.domain.action.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameRequest {

    private String player;
    private Action action;
}
