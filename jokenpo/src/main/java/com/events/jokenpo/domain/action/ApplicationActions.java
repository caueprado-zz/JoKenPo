package com.events.jokenpo.domain.action;

import com.events.jokenpo.domain.action.repository.ActionRepository;
import com.events.jokenpo.exception.ActionAlreadyExistsException;
import com.events.jokenpo.exception.ActionNotFoundException;
import com.events.jokenpo.request.ActionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ApplicationActions {

    private final ActionRepository actionRepository;

    public Optional<Action> getAction(final String action) {
        return Optional.ofNullable(actionRepository.findByAction(action));
    }

    public List<Action> getActions() {
        return StreamSupport
                .stream(actionRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Action addAction(final ActionRequest actionRequest) {
        final String newAction = actionRequest.getActionName();
        if (getAction(newAction).isPresent()) {
            throw new ActionAlreadyExistsException();
        }
        final List<String> defeatActions = actionRequest.getDefeat();
        final Action action = new Action(newAction);
        for (String defeats : defeatActions) {
            Action currentAction = null;
            currentAction = getAction(defeats).orElse(null);
            if (!Objects.isNull(currentAction)) {
                action.defeat(currentAction);
            } else {
                action.defeat(new Action(defeats));
            }
        }
        return actionRepository.save(action);
    }

    public void removeAction(final String action) {
        getAction(action)
                .ifPresentOrElse(actionRepository::delete,
                () -> { throw new RuntimeException();
                });
    }

    public void updateAction(final ActionRequest actionRequest) {
        final Action currentAction = getAction(actionRequest.getActionName())
                .orElseThrow(ActionNotFoundException::new);

        actionRequest.getDefeat()
                .forEach(action -> {
                    Action actions = getAction(action)
                            .orElseThrow(ActionNotFoundException::new);
                    currentAction.defeat(actions);
                });
        actionRepository.save(currentAction);
    }

    public void removeAll() {
        actionRepository.deleteAll();
    }
}
