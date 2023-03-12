package com.r2ha.blackjack.adapter.in.console;

import com.r2ha.blackjack.domain.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class GameDisplayTest {
    private final InputStream originalSystemmIn = System.in;

    private void provideInput(String input) {
        byte[] inputBytes = input.getBytes();
        ByteArrayInputStream testIn = new ByteArrayInputStream(inputBytes);
        System.setIn(testIn); // reading from System.in will consume our input;
    }

    @AfterEach
    public void restoreSystemInput() {
        System.setIn(originalSystemmIn);
    }

    @Test
    void gamePlays() {
        provideInput("\nS\n"); // simulates typing: Enter, S, Enter
        // Starts the game with an empty String array for the arguments.
        Game.main(new String[0]);
    }
}
