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
package org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.Events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.CancellableEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.Weapons.Weapon;

/**
 *
 * @author Manuel Gauto
 */
public class PlayerHurtByPlayerEvent extends CancellableEvent{
    
    private Weapon weaponUsed;
    private Player victim;
    private Player damager;
    private Location location;
    private EntityDamageByEntityEvent event;
    
    /**
     * Default constructor
     *
     * @param weapon Weapon used to hurt the victim
     * @param victim Player killed
     * @param killer Player who killed
     * @param loc Location of death
     */
    public PlayerHurtByPlayerEvent(Object source, Weapon weapon, EntityDamageByEntityEvent event) {
        super(source);
        this.weaponUsed = weapon;
        this.victim = (Player) event.getEntity();
        this.damager = (Player) event.getDamager();
        this.location = ((Player) event.getEntity()).getLocation();
        this.event = event;
    }

    /**
     * Get the {@link Weapon} used to hurt the {@link Player}
     *
     * @return
     */
    public Weapon getWeaponUsed() {
        return this.weaponUsed;
    }

    /**
     * Get the {@link Player} that was hurt
     *
     * @return Player that was killed
     */
    public Player getVictim() {
        return this.victim;
    }

    /**
     * Get the {@link Player} that hurt the victim
     *
     * @return
     */
    public Player getDamager() {
        return this.damager;
    }

    /**
     * Get the {@link Location} where the {@link Player} was hurt
     *
     * @return
     */
    public Location getLocation() {
        return this.location;
    }
    
    public int getDamage(){
        return event.getDamage();
    }
    
    public void setDamage(int newDamage){
        event.setDamage(newDamage);
    }
}
