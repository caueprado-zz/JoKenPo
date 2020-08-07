package com.events.jokenpo.domain.game.computer;

import com.events.jokenpo.domain.action.Action;

@FunctionalInterface
public interface GameAction {

     Action play();
}
