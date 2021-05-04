package de.warsteiner.ultimatejobs.utils.api.events;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerDataChangeEvent extends Event {
	
		private static HandlerList list = new HandlerList();
  
		public String uuid;
		public UUID id;
 
			public PlayerDataChangeEvent(String uuid) {
		 
				this.uuid = uuid;
				Bukkit.getPluginManager().callEvent(this);
			}

			public HandlerList getHandlers() {
				return list;
			}
			
			public String getUUID() {
				return uuid;
			}
			
		  public static HandlerList getHandlerList() {
				  return list;
		 } 
 
}