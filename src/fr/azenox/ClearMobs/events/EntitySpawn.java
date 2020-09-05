package fr.azenox.ClearMobs.events;

import java.util.ArrayList;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import fr.azenox.ClearMobs.utils.Config;

public class EntitySpawn implements Listener {
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@EventHandler
	public void entitySpawn(EntitySpawnEvent e){
		
		Entity ent = e.getEntity();
		

		ArrayList<String> entities = (ArrayList<String>) Config.getFile().getList("PreventSpawn");
		
		String ent_name = ent.getType().getName().replaceAll("Craft", "");
		
		if(entities.contains(ent_name)){
			e.setCancelled(true);
		}
		
		
	}

}
