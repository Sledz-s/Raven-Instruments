package net.sl3dz.raveninstruments.client.gui.screen.instrument.gloriousdrum;

import net.sl3dz.raveninstruments.client.config.ModClientConfigs;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.note.label.INoteLabel;
import net.sl3dz.raveninstruments.client.gui.screen.options.instrument.partial.InstrumentOptionsScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GloriousDrumOptionsScreen extends InstrumentOptionsScreen {

    public GloriousDrumOptionsScreen(AratakisGreatAndGloriousDrumScreen screen) {
        super(screen);
    }
    

    @Override
    protected void saveLabel(INoteLabel newLabel) {
        if (newLabel instanceof GloriousDrumNoteLabel label) {
            ModClientConfigs.GLORIOUS_DRUM_LABEL_TYPE.set(label);
        }
    }

    @Override
    public INoteLabel[] getLabels() {
        return GloriousDrumNoteLabel.availableVals();
    }
    @Override
    public GloriousDrumNoteLabel getCurrentLabel() {
        return ModClientConfigs.GLORIOUS_DRUM_LABEL_TYPE.get();
    }

    @Override
    protected GloriousDrumMidiOptionsScreen midiOptionsScreen() {
        return new GloriousDrumMidiOptionsScreen(MIDI_OPTIONS, this, instrumentScreen);
    }
    
}
