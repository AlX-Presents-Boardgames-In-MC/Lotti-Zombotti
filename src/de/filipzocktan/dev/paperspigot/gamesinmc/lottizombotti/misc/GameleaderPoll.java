package de.filipzocktan.dev.paperspigot.gamesinmc.lottizombotti.misc;

import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GameleaderPoll {

    private HashMap<Player, Integer> votes = new HashMap<>();
    private List<Player> voted = new LinkedList<>();

    public GameleaderPoll(Collection<Player> players) {
        for (Player p : players) {
            votes.put(p, 0);
        }
    }

    public void vote(Player p) {
        if (voted.contains(p)) return;
        votes.compute(p, (player, integer) -> integer + 1);
        voted.add(p);
    }

    public static GameleaderPoll createPoll(Collection<Player> players) {
        return new GameleaderPoll(players);
    }

}
