package com.events.jokenpo;

import com.events.jokenpo.domain.action.Action;
import com.events.jokenpo.domain.game.computer.ComputerAction;
import lombok.val;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComputerActionTest {

    @Autowired
    private ComputerAction computerAction;

    @Test
    public void computerShouldPlayAnAction() {
//        val action = computerAction.play();
//        Assertions.assertThat(action).isNotNull();
//        Assertions.assertThat(action.getClass()).isEqualTo(Action.class);
    }
}
