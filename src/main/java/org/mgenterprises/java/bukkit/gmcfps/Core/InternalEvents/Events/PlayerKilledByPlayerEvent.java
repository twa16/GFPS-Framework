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

import java.util.EventObject;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mgenterprises.java.bukkit.gmcfps.Core.Weapons.Weapon;

/**
 * Object used to carry information about a particular kill.
 *
 * @author Manuel Gauto
 */
public class PlayerKilledByPlayerEvent extends EventObject {

    private Weapon weaponUsed;
    private Player victim;
    private Player killer;
    private Location location;

    /**
     * Default constructor
     *
     * @param weapon Weapon used to kill the victim
     * @param victim Player killed
     * @param killer Player who killed
     * @param loc Location of death
     */
    public PlayerKilledByPlayerEvent(Object source, Weapon weapon, Player victim, Player killer, Location loc) {
        super(source);
        this.weaponUsed = weapon;
        this.victim = victim;
        this.killer = killer;
        this.location = loc;

    }

    /**
     * Get the {@link Weapon} used to kill the {@link Player}
     *
     * @return
     */
    public Weapon getWeaponUsed() {
        return this.weaponUsed;
    }

    /**
     * Get the {@link Player} that was killed
     *
     * @return Player that was killed
     */
    public Player getVictim() {
        return this.victim;
    }

    /**
     * Get the {@link Player} that killed the victim
     *
     * @return
     */
    public Player getKiller() {
        return this.killer;
    }

    /**
     * Get the {@link Location} where the {@link Player} was killed
     *
     * @return
     */
    public Location getKillLocation() {
        return this.location;
    }
}
