/*
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.comze_instancelabs.bedwars.sheep;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.Plugin;

import com.comze_instancelabs.minigamesapi.MinigamesAPI;

import net.minecraft.server.v1_7_R2.EntityTypes;

public class Register175 extends Register {

	public boolean registerEntities() {
		try {
			Class entityTypeClass = EntityTypes.class;

			Field c = entityTypeClass.getDeclaredField("c");
			c.setAccessible(true);
			HashMap c_map = (HashMap) c.get(null);
			c_map.put("Sheeep", Sheeep175.class);

			Field d = entityTypeClass.getDeclaredField("d");
			d.setAccessible(true);
			HashMap d_map = (HashMap) d.get(null);
			d_map.put(Sheeep175.class, "Sheeep");

			Field e = entityTypeClass.getDeclaredField("e");
			e.setAccessible(true);
			HashMap e_map = (HashMap) e.get(null);
			e_map.put(Integer.valueOf(91), Sheeep175.class);

			Field f = entityTypeClass.getDeclaredField("f");
			f.setAccessible(true);
			HashMap f_map = (HashMap) f.get(null);
			f_map.put(Sheeep175.class, Integer.valueOf(91));

			Field g = entityTypeClass.getDeclaredField("g");
			g.setAccessible(true);
			HashMap g_map = (HashMap) g.get(null);
			g_map.put("Sheeep", Integer.valueOf(91));

			return true;
		} catch (Exception ex) {
			MinigamesAPI.getAPI().getLogger().log(Level.WARNING, "exception", ex);
			return false;
		}
	}

	public Sheeep175 spawnSheep(Plugin m, final Location t, Player target, final int color) {
		final Object w = ((CraftWorld) t.getWorld()).getHandle();
		final Sheeep175 t_ = new Sheeep175((net.minecraft.server.v1_7_R2.World) ((CraftWorld) t.getWorld()).getHandle(), (net.minecraft.server.v1_7_R2.Entity) ((CraftPlayer) target).getHandle());

		Bukkit.getScheduler().runTask(m, new Runnable() {
			public void run() {
				// t_.id = Block.getById(35);
				// t_.data = color;
				((net.minecraft.server.v1_7_R2.World) w).addEntity(t_, CreatureSpawnEvent.SpawnReason.CUSTOM);
				t_.setColor(color);
				t_.setPosition(t.getX(), t.getY(), t.getZ());
			}
		});

		return t_;
	}
}
