package de.filipzocktan.dev.paperspigot.gamesinmc.lottizombotti.events;

import de.filipzocktan.dev.paperspigot.gamesinmc.lottizombotti.misc.GameleaderPoll;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class GameLeaderPollStartedEvent extends Event {

    protected static Inventory inventory;
    protected static GameleaderPoll poll;

    private static HandlerList handlers = new HandlerList();

    public GameLeaderPollStartedEvent(GameleaderPoll gameleaderPoll) {
        inventory = Bukkit.getServer().createInventory(null, 9, "Wählt euren Spielleiter.");
        poll = gameleaderPoll;
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            if (!p.getScoreboardTags().contains("spectator")) {
                inventory.addItem(getPlayerHead(p));
            }
        }

    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    private ItemStack getPlayerHead(Player player) {
        ItemStack itemStack_re = new ItemStack(Material.PLAYER_HEAD, 0);
        SkullMeta skullMeta = (SkullMeta) itemStack_re.getItemMeta();
        skullMeta.setPlayerProfile(player.getPlayerProfile());
        skullMeta.setDisplayName(player.getDisplayName());
        itemStack_re.setItemMeta(skullMeta);
        return itemStack_re;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static class InventoryListener implements Listener {

        @EventHandler
        public void onInvItemClicked(InventoryClickEvent ev) {
            if (ev.getClickedInventory().equals(GameLeaderPollStartedEvent.inventory)) {
                ev.setCancelled(true);
                poll.vote(((SkullMeta)inventory.getItem(ev.getSlot()).getItemMeta()).getOwningPlayer().getPlayer());
                inventory.getItem(ev.getSlot()).setAmount(1);
            }
        }
    }

}
