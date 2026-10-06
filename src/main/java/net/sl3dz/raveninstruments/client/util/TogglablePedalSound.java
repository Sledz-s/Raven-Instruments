package net.sl3dz.raveninstruments.client.util;

import net.sl3dz.raveninstruments.client.config.enumType.SoundType;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TogglablePedalSound<T extends SoundType> {

    public final T enabled, disabled;

    public TogglablePedalSound(final T enabled, final T disabled) {
        this.enabled = enabled;
        this.disabled = disabled;
    }

}