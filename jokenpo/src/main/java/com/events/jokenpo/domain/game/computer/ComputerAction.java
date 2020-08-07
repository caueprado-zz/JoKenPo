package com.events.jokenpo.domain.game.computer;

import com.events.jokenpo.domain.action.Action;
import com.events.jokenpo.domain.action.ApplicationActions;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class ComputerAction implements GameAction {

    private final ApplicationActions applicationActions;

    @Override
    public Action play() {
        List<Action> actions = applicationActions.getActions();
        int possibleActions = actions.size();
        Random random = new Random();
        int nextAction = random.nextInt(possibleActions);
        if (nextAction<1) nextAction = nextAction*-1;
        System.out.println(nextAction+"");
        return actions.get(nextAction);
    }
}
