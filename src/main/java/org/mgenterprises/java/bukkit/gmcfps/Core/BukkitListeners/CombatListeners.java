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
package org.mgenterprises.java.bukkit.gmcfps.Core.BukkitListeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.FPSCore;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Events.PlayerHurtByPlayerEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Events.PlayerKilledByPlayerEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Sources.PlayerHurtByPlayerSource;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Sources.PlayerKilledByPlayerSource;
import org.mgenterprises.java.bukkit.gmcfps.Core.Weapons.Weapon;

/**
 *
 * @author Manuel Gauto
 */
public class CombatListeners implements Listener {

    private FPSCore core;

    public CombatListeners(FPSCore core) {
        this.core = core;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        EntityDamageEvent ede = event.getEntity().getLastDamageCause();
        if (ede instanceof EntityDamageByEntityEvent) {
            Entity killer = ((EntityDamageByEntityEvent) ede).getDamager();
            Entity victim = ((EntityDamageByEntityEvent) ede).getEntity();


            if (killer instanceof Player && victim instanceof Player) {
                Player pKiller = (Player) killer;
                Player pVictim = (Player) victim;
                if (core.getTeamManager().isParticipating(pVictim) && core.getTeamManager().isParticipating(pKiller)) {
                    firePlayerKilledByPlayerEvent(pKiller, pVictim);
                }
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
            Player pKiller = (Player) event.getDamager();
            Player pVictim = (Player) event.getEntity();
            if (core.getTeamManager().isParticipating(pVictim) && core.getTeamManager().isParticipating(pKiller)) {
                PlayerHurtByPlayerSource source = core.getEventManager().getPlayerHurtSource();
                Weapon w = core.getWeaponManager().getWeaponByType(((Player) event.getDamager()).getItemInHand().getType());
                PlayerHurtByPlayerEvent phpe = new PlayerHurtByPlayerEvent(source, w, event);
                source.fireEvent(phpe);
            }
        }
    }

    @EventHandler
    public void onPlayerRespawnEvent(PlayerRespawnEvent event){
        core.getSpawnManager().onPlayerRespawn(event);
    }
    
    private void firePlayerKilledByPlayerEvent(Player killer, Player victim) {
        Weapon w = core.getWeaponManager().getWeaponByName(killer.getItemInHand().getType().name());
        PlayerKilledByPlayerSource source = core.getEventManager().getPlayerKilledSource();
        PlayerKilledByPlayerEvent pkpe = new PlayerKilledByPlayerEvent(source, w, victim, killer, victim.getLocation());
        if (core.getTeamManager().isParticipating(victim) && core.getTeamManager().isParticipating(killer)) {
            source.fireEvent(pkpe);
        }
    }
}
