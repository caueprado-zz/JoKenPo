package com.events.jokenpo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultiGameRequest {

    private List<GameRequest> multigame;
}
