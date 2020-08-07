package com.events.jokenpo.domain.action;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NodeEntity
@NoArgsConstructor
public class Action {

    @Id @GeneratedValue @Getter private Long id;
    @Getter @Setter private String action;
    @Getter @Setter private String image;

    @Getter
    @Relationship(type = "DEFEAT")
    private Set<Action> defeat = new HashSet<>();

    public Action(final String action) {
        this.action = action;
    }

    public void defeat(final Action action) {
        defeat.add(action);
    }

    public boolean defeatAction(final Action action) {
        if(Objects.isNull(action)) throw new IllegalArgumentException();
        return this.getDefeat().stream()
                .anyMatch(currentAction ->
                        action.getAction().equals(currentAction.getAction()));
    }
}
