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
package org.mgenterprises.java.bukkit.gmcfps.Core.Scores;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mgenterprises.java.bukkit.gmcfps.Core.Weapons.Weapon;

/**
 *
 * @author Manuel Gauto
 */
public class PlayerKillFactory {
    private Weapon weaponUsed;
    private Player victim;
    private Player killer;
    private Location location;
    
    public void setWeapon(Weapon weapon){
        this.weaponUsed = weapon;
    }
    
    public void setVictim(Player victim){
        this.victim = victim;
    }
    
    public void setKiller(Player killer){
        this.killer = killer;
    }
    
    public void setLocation(Location location){
        this.location = location;
    }
    
    public PlayerKill build(){
        PlayerKill pk = new PlayerKill(weaponUsed, victim, killer, location);
        return pk;
    }
}
