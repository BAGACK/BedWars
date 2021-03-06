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
import java.util.logging.Level;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Sheep;
import org.bukkit.event.entity.EntityTargetEvent;

import com.comze_instancelabs.minigamesapi.MinigamesAPI;
import com.google.common.collect.Sets;

import net.minecraft.server.v1_10_R1.Entity;
import net.minecraft.server.v1_10_R1.EntityLiving;
import net.minecraft.server.v1_10_R1.EntitySheep;
import net.minecraft.server.v1_10_R1.GenericAttributes;
import net.minecraft.server.v1_10_R1.World;

public class Sheeep110 extends EntitySheep implements Sheeep {

	public Sheeep110(World world, Entity target) {
		super(world);
		this.locX = target.locX;
		this.locY = target.locY;
		this.locZ = target.locZ;
		try {
			Field b = this.goalSelector.getClass().getDeclaredField("b");
			b.setAccessible(true);
			b.set(this.goalSelector, Sets.newLinkedHashSet());
			this.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).setValue(128D);
			this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.37D);
		} catch (Exception e) {
			MinigamesAPI.getAPI().getLogger().log(Level.WARNING, "exception", e);
		}
		this.goalSelector.a(0, new PathfinderGoalMeleeAttack110(this, /*EntityHuman.class,*/ 1D, false));
		// this.goalSelector.a(0, new PathfinderGoalFollowParent(this, 1.1D));
		this.setGoalTarget((EntityLiving) target, EntityTargetEvent.TargetReason.OWNER_ATTACKED_TARGET, false);
		((Sheep) this.getBukkitEntity()).setTarget((LivingEntity) target.getBukkitEntity());
	}

	public Location getLocation() {
		return new Location(this.world.getWorld(), this.locX, this.locY, this.locZ);
	}

}
