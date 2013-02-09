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
package org.mgenterprises.java.bukkit.gmcfps.Core;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mgenterprises.java.bukkit.gmcfps.Core.Weapons.Weapon;

/**
 *
 * @author Manuel Gauto
 */
public class PlayerKill {
    private Weapon weaponUsed;
    private Player victim;
    private Player killer;
    private Location location;
    
    public PlayerKill(Weapon weapon, Player victim, Player killer, Location loc){
        this.weaponUsed = weapon;
        this.victim = victim;
        this.killer = killer;
        this.location = loc;
    }
    
    public Weapon getWeaponUsed(){
        return this.weaponUsed;
    }
    
    public Player getVictim(){
        return this.victim;
    }
    
    public Player getKiller(){
        return this.killer;
    }
    
    public Location getKillLocation(){
        return this.location;
    }
}
