package com.events.jokenpo.domain.game;

import com.events.jokenpo.domain.action.Action;
import com.events.jokenpo.domain.action.ApplicationActions;
import com.events.jokenpo.exception.ActionNotFoundException;
import com.events.jokenpo.domain.game.computer.ComputerAction;
import com.events.jokenpo.request.GameRequest;
import com.events.jokenpo.request.MultiGameRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameService {

    private final ComputerAction computerAction;

    private final ApplicationActions applicationActions;

    public String singlePlayer(final GameRequest gameRequest) {
        final Action computerAction = this.computerAction.play();
        log.info("computerAction: " + computerAction.getAction());
        Action requestAction = gameRequest.getAction();
        Action playerAction = applicationActions.getAction(requestAction.getAction())
                .orElseThrow(ActionNotFoundException::new);

        String playerName = gameRequest.getPlayer();
        log.info("Player {}, Action {}", playerName, playerAction.getAction());
        if (playerAction.defeatAction(computerAction)) {
            return String.format(playerName, playerAction.getAction());
        }
        return "Computer Wins";
    }

    public String dualPlayer(final MultiGameRequest gameRequest) {
        final List<GameRequest> gameRequestList = gameRequest.getMultigame();
        GameRequest gameRequest1 = gameRequestList.get(0);
        GameRequest gameRequest2 = gameRequestList.get(1);

        val player1Action = gameRequest1.getAction();
        val action1 = applicationActions.getAction(player1Action.getAction())
                .orElseThrow(ActionNotFoundException::new);

        val player2Action = gameRequest2.getAction();
        val action2 = applicationActions.getAction(player2Action.getAction())
                .orElseThrow(ActionNotFoundException::new);
        if (action1.defeatAction(action2)) {
            return "Player 1 Wins";
        }

        return "Player 2 Wins";
    }

    public String threePlayer(final MultiGameRequest gameRequest) {
        return "";
    }
}
