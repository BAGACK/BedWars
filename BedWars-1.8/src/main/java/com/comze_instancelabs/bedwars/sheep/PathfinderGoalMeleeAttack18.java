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

import net.minecraft.server.v1_8_R1.Entity;
import net.minecraft.server.v1_8_R1.EntityCreature;
import net.minecraft.server.v1_8_R1.EntityLiving;
import net.minecraft.server.v1_8_R1.PathfinderGoalMeleeAttack;

public class PathfinderGoalMeleeAttack18 extends PathfinderGoalMeleeAttack {

	EntityCreature b;
	
	public PathfinderGoalMeleeAttack18(EntityCreature entitycreature, double d0, boolean flag) {
		super(entitycreature, d0, flag);
		b = entitycreature;
	}
	
	public PathfinderGoalMeleeAttack18(EntityCreature entitycreature, Class c, double d0, boolean flag) {
		super(entitycreature, c, d0, flag);
		b = entitycreature;
	}

	@Override
	public void e() {
		b.getNavigation().a(b.getGoalTarget());
    }
	
}
