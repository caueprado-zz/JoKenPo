package com.events.jokenpo.domain.action.repository;

import com.events.jokenpo.domain.action.Action;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends Neo4jRepository<Action, Long> {

    Action findByAction(final String action);
}
