package de.filipzocktan.dev.paperspigot.gamesinmc.lottizombotti.misc;

import de.filipzocktan.dev.paperspigot.gamesinmc.lottizombotti.events.GameLeaderChosenEvent;
import de.filipzocktan.dev.paperspigot.gamesinmc.lottizombotti.events.GameLeaderPollStartedEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class GameleaderPoll {

    private HashMap<Player, Integer> votes = new HashMap<>();
    private List<Player> voted = new LinkedList<>();

    public GameleaderPoll(Collection<Player> players) {
        for (Player p : players) {
            votes.put(p, 0);
        }
        Bukkit.getServer().getPluginManager().callEvent(new GameLeaderPollStartedEvent(this));
    }

    public void vote(Player p) {
        if (voted.contains(p)) return;
        votes.compute(p, (player, integer) -> integer + 1);
        voted.add(p);
        if(voted.size() == Bukkit.getServer().getOnlinePlayers().size()) Bukkit.getServer().getPluginManager().callEvent(new GameLeaderChosenEvent(getHighestVotedPlayer()));

    }

    private Player getHighestVotedPlayer() {
        TreeMap<Integer, Player> tm = new TreeMap<>();
        for(Player p : votes.keySet()){
            tm.put(votes.get(p), p);
        }
        return tm.get(tm.descendingKeySet().last());
    }

    public static GameleaderPoll createPoll(Collection<Player> players) {
        return new GameleaderPoll(players);
    }

}
