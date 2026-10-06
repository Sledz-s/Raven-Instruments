package net.sl3dz.raveninstruments.client.gui.screen.instrument.floralzither;

import net.sl3dz.raveninstruments.RavenInstrumentsMod;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.InstrumentThemeLoader;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.grid.GridInstrumentScreen;
import net.sl3dz.raveninstruments.client.gui.screen.options.instrument.partial.InstrumentOptionsScreen;
import net.sl3dz.raveninstruments.sound.NoteSound;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FloralZitherScreen extends GridInstrumentScreen {
    public static final ResourceLocation INSTRUMENT_ID = new ResourceLocation(RavenInstrumentsMod.MODID, "floral_zither");

    @Override
    public ResourceLocation getInstrumentId() {
        return INSTRUMENT_ID;
    }

    
    @Override
    public NoteSound[] getInitSounds() {
        return ((FloralZitherOptionsScreen)optionsScreen).getPreferredSoundType().getSoundArr().get();
    }

    @Override
    protected InstrumentOptionsScreen initInstrumentOptionsScreen() {
        return new FloralZitherOptionsScreen(this);
    }

    
    public static final InstrumentThemeLoader THEME_LOADER = new InstrumentThemeLoader(INSTRUMENT_ID);
    @Override
    public InstrumentThemeLoader getThemeLoader() {
        return THEME_LOADER;
    }
    
}
