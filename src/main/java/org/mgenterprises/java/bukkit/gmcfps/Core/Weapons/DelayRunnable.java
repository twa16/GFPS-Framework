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
package org.mgenterprises.java.bukkit.gmcfps.Core.Weapons;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.mgenterprises.java.bukkit.gmcfps.Core.FPSCore;

/**
 *
 * @author Manuel Gauto
 */
public class DelayRunnable implements Runnable {

    private FPSCore core;
    private Player p;
    private boolean enableClick;

    public DelayRunnable(FPSCore core, Player p, boolean click) {
        this.core = core;
        this.p = p;
        this.enableClick = click;
    }

    @Override
    public void run() {
        core.getWeaponManager().waiting.remove(p.getName());
        if (enableClick) {
            p.playEffect(p.getLocation(), Effect.CLICK1, 20);
        }
    }
}
