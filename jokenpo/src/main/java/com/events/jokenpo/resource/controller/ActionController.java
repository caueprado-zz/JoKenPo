package com.events.jokenpo.resource.controller;

import com.events.jokenpo.mapper.ActionMapper;
import com.events.jokenpo.exception.ActionNotFoundException;
import com.events.jokenpo.domain.action.Action;
import com.events.jokenpo.request.ActionRequest;
import com.events.jokenpo.response.ActionResponse;
import com.events.jokenpo.domain.action.ApplicationActions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api("Action")
@RestController
@RequestMapping("actions")
@RequiredArgsConstructor
public class ActionController {

    private final ApplicationActions applicationActions;

    @GetMapping
    @ApiOperation(value = "get all jokenpo actions", tags = "Action")
    public List<ActionResponse> getActions() {
        return applicationActions.getActions()
                .stream()
                .map(ActionMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("{actionId}")
    @ApiOperation(value = "Get a Jokenpo action", tags = "Action")
    public ActionResponse getAction(@PathVariable final String actionId) {
        final Action responseAction = applicationActions.getAction(actionId)
                .orElseThrow(ActionNotFoundException::new);
        return new ActionResponse(responseAction.getAction());
    }

    @PostMapping
    @ApiOperation(value = "Create a new Jokenpo action", tags = "Action")
    public Action addAction(@RequestBody final ActionRequest action) {
        return applicationActions.addAction(action);
    }

    @PutMapping
    @ApiOperation(value = "Update a Jokenpo action", tags = "Action")
    public void updateAction(@RequestBody final ActionRequest actionRequest) {
        applicationActions.updateAction(actionRequest);
    }

    @DeleteMapping("{actionId}")
    @ApiOperation(value = "Delete a Jokenpo action", tags = "Action")
    public void removeAction(@PathVariable String actionId) {
        applicationActions.removeAction(actionId);
    }

    @DeleteMapping("/delete-all")
    @ApiOperation(value = "Delete all jokenpo actions", tags = "Action")
    public void removeAction() {
        applicationActions.removeAll();
    }
}
