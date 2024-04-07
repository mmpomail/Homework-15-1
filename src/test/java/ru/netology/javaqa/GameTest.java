package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(11, "First", 55);
    Player player2 = new Player(12, "Second", 79);
    Player player3 = new Player(13, "Third", 83);
    Player player4 = new Player(14, "Fourth", 55);

    Game play = new Game();

    @Test
    public void firstPlayerStrongerThanSecond() {
        play.register(player3);
        play.register(player1);

        int expected = 1;
        int actual = play.round("Third", "First");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerWeakerThanSecond() {
        play.register(player1);
        play.register(player2);

        int expected = 2;
        int actual = play.round("First", "Second");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playersWithSameStrength() {
        play.register(player1);
        play.register(player4);

        int expected = 0;
        int actual = play.round("First", "Fourth");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        play.register(player3);
        play.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            play.round("Second", "Fourth");
        });
    }

    @Test
    public void secondPlayerNotRegistered() {
        play.register(player1);
        play.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            play.round("First", "Third");
        });
    }

    @Test
    public void noOnePlayerRegistered() {
        play.register(player2);
        play.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            play.round("First", "Fourth");
        });
    }
}
