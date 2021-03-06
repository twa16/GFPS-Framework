/*
 * The MIT License
 *
 * Copyright 2013 Chris.
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
import org.mgenterprises.java.bukkit.gmcfps.Core.InternalEvents.CancellableEvent;
import org.mgenterprises.java.bukkit.gmcfps.Core.Weapons.Weapon;

/**
 *
 * @author Chris
 */
public class WeaponFiredEvent extends CancellableEvent {
    private Player player;
    private Weapon weaponUsed;
    private Location location;
    
    /*
     * Default Constuctor
     * 
     * @param source
     * @param weapon
     * @param player
     * @param location
     */
    public WeaponFiredEvent(Object source, Weapon weapon, Player player, Location location){
        super(source);
        this.weaponUsed = weapon;
        this.player = player;
        this.location = location;
    }
    
    /*
     * Get the {@link Weapon} used by the {@link Player}
     *
     * @return
     */
    public Weapon getWeaponUsed(){
        return this.weaponUsed;
    }
    
    
    /*
     * Get the {@link Player} who triggered the event
     *
     * @return
     */
    public Player getPlayer(){
        return this.player;
    }
    
    /*
     * Get the {@link Location} of the {@link Player} who triggered the event
     *
     * @return
     */
    public Location getLocation(){
        return this.location;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(player);
        sb.append("\n  ");
        sb.append(weaponUsed.getName());
        sb.append("\n  ");
        sb.append(this.location);
        return sb.toString();
    }
}
