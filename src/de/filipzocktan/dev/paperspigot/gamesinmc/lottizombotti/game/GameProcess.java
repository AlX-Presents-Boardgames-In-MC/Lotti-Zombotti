package de.filipzocktan.dev.paperspigot.gamesinmc.lottizombotti.game;

import org.bukkit.entity.Player;

import java.util.LinkedList;
import java.util.List;

public class GameProcess {

    public static class ReadyPhase {
        private static List<Player> readyPlayers = new LinkedList<>();

        public static boolean makePlayerReady(Player p) {
            if (readyPlayers.contains(p)) return false;
            readyPlayers.add(p);
            return true;
        }

        public static boolean makePlayerUnready(Player p) {
            if (!readyPlayers.contains(p)) return false;
            readyPlayers.remove(p);
            return true;
        }

        public static int getReadyPlayersCount() {
            return readyPlayers.size();
        }
    }

    public static class PrepPhase {


    }

}
