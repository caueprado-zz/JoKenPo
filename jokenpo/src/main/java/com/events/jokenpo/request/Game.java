package com.events.jokenpo.request;

import com.events.jokenpo.domain.action.Action;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    private UUID uuid;
    private String player;
    private Action action;
}
