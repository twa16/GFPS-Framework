/*
 * The MIT License
 *
 * Copyright 2013 Manuel Gauto.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.mgenterprises.java.bukkit.gmcfps.Core.Weapons.Implementations;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.Weapons.ProjectileWeapon;
import org.mgenterprises.java.bukkit.gmcfps.Core.Weapons.WeaponManager;

/**
 *
 * @author Manuel Gauto
 */
public class BasicRocketLauncher extends ProjectileWeapon{

    private int velocityMulti = 2;
    private float explosionMulti = 2F;
    public BasicRocketLauncher(WeaponManager wm) {
        super(wm, "Launcher", Material.DIAMOND_AXE, Material.IRON_INGOT, EntityType.SMALL_FIREBALL, 100);
    }
    
    @Override
    public void onWeaponFire(Player p) {
        Projectile projectile = p.launchProjectile(SmallFireball.class);
        projectile.setVelocity(projectile.getVelocity().multiply(velocityMulti));
        p.playEffect(p.getLocation(), Effect.CLICK2, 20);
    }

    @Override
    public void onProjectileHitPlayer(EntityDamageByEntityEvent event) {
        World world = event.getEntity().getLocation().getWorld();
        world.createExplosion(event.getEntity().getLocation(), explosionMulti);
    }

    @Override
    public void onProjectileHit(ProjectileHitEvent event) {
        World world = event.getEntity().getLocation().getWorld();
        world.createExplosion(event.getEntity().getLocation(), explosionMulti);
    }
    
}
