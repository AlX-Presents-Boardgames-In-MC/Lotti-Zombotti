package de.filipzocktan.dev.paperspigot.gamesinmc.lottizombotti.events;

import de.filipzocktan.dev.paperspigot.gamesinmc.lottizombotti.misc.GameleaderPoll;
import lombok.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class GameLeaderChosenEvent extends Event {
    private static Player p;
    private static HandlerList handlers = new HandlerList();

    public GameLeaderChosenEvent(Player p) {
        this.p = p;
    }

    public static Player getWinningPlayer() {
        return p;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
