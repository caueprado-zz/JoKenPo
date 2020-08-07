package com.events.jokenpo.resource.controller;

import com.events.jokenpo.domain.game.GameService;
import com.events.jokenpo.request.GameRequest;
import com.events.jokenpo.request.MultiGameRequest;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("play")
@RequiredArgsConstructor
public class JokenpoGameController {

    private final GameService gameService;

    @PostMapping("single")
    @ApiOperation(value = "single player jokenpo game", tags = "Game")
    public ResponseEntity<String> singlePlayer(@RequestBody final GameRequest gameRequest) {
        return new ResponseEntity<String>(gameService.singlePlayer(gameRequest), HttpStatus.OK);
    }

    @PostMapping("dual")
    @ApiOperation(value = "two player jokenpo game", tags = "Game")
    public ResponseEntity<String> dualPlayer(@RequestBody final MultiGameRequest gameRequest) {
        return new ResponseEntity<String>(gameService.dualPlayer(gameRequest), HttpStatus.OK);
    }

    @PostMapping("three")
    @ApiOperation(value = "three player jokenpo game", tags = "Game")
    public ResponseEntity<String> threePlayer(@RequestBody final MultiGameRequest gameRequest) {
        return new ResponseEntity<String>(gameService.threePlayer(gameRequest), HttpStatus.OK);
    }
}
