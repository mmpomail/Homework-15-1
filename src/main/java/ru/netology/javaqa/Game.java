package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> registered = new ArrayList<>();

    public void register(Player player) {
        registered.add(player);
    }


    public int round(String name1, String name2) {

        Player firstPlayer = null;
        Player secondPlayer = null;

        for (Player player : registered) {
            if (player.getName().equals(name1)) {
                firstPlayer = player;
            } else if (player.getName().equals(name2)) {
                secondPlayer = player;
            } else {
                throw new NotRegisteredException(
                        "Игрок(и) не зарегистрирован(ы)"
                );
            }

        }

        if (firstPlayer.getStrength() > secondPlayer.getStrength()) {
            return 1;
        }
        if (secondPlayer.getStrength() > firstPlayer.getStrength()) {
            return 2;
        }
        return 0;
    }
}
