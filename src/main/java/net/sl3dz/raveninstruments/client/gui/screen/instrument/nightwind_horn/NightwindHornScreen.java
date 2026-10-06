package net.sl3dz.raveninstruments.client.gui.screen.instrument.nightwind_horn;

import net.sl3dz.raveninstruments.RavenInstrumentsMod;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.InstrumentThemeLoader;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.grid.HeldGridInstrumentScreen;
import net.sl3dz.raveninstruments.sound.RISounds;
import net.sl3dz.raveninstruments.sound.held.HeldNoteSound;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NightwindHornScreen extends HeldGridInstrumentScreen {
    public static final ResourceLocation INSTRUMENT_ID = new ResourceLocation(RavenInstrumentsMod.MODID, "nightwind_horn");

    @Override
    public ResourceLocation getInstrumentId() {
        return INSTRUMENT_ID;
    }

    @Override
    public HeldNoteSound[] getInitHeldNoteSounds() {
        return RISounds.NIGHTWIND_HORN;
    }


    @Override
    public int columns() {
        return 2;
    }

    @Override
    protected void renderInstrumentBackground(final GuiGraphics gui) {
        final int clefX = grid.getX() - getNoteSize() + 8;

        renderClef(gui, 0, clefX, "treble");
        renderClef(gui, 1, clefX, "bass");

        for (int i = 0; i < columns(); i++)
            renderStaff(gui, i);
    }


    public static final InstrumentThemeLoader THEME_LOADER = new InstrumentThemeLoader(INSTRUMENT_ID);
    @Override
    public InstrumentThemeLoader getThemeLoader() {
        return THEME_LOADER;
    }
    
}
