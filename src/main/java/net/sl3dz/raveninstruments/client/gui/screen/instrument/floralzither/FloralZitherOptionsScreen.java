package net.sl3dz.raveninstruments.client.gui.screen.instrument.floralzither;

import net.sl3dz.raveninstruments.client.config.ModClientConfigs;
import net.sl3dz.raveninstruments.client.config.enumType.ZitherSoundType;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.InstrumentScreen;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.grid.GridInstrumentScreen;
import net.sl3dz.raveninstruments.client.gui.screen.options.instrument.partial.SoundTypeOptionsScreen;
import net.sl3dz.raveninstruments.client.util.TogglablePedalSound;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FloralZitherOptionsScreen extends SoundTypeOptionsScreen<ZitherSoundType> {
    private static final String SOUND_TYPE_KEY = "button.raveninstrument.zither.soundType",
        OPTIONS_LABEL_KEY = "label.raveninstrument.zither_options";
    
    public FloralZitherOptionsScreen(final GridInstrumentScreen screen) {
        super(screen);
    }
    

    @Override
    protected String soundTypeButtonKey() {
        return SOUND_TYPE_KEY;
    }
    @Override
    protected String optionsLabelKey() {
        return OPTIONS_LABEL_KEY;
    }


    @Override
    protected ZitherSoundType getInitSoundType() {
        return ModClientConfigs.ZITHER_SOUND_TYPE.get();
    }

    @Override
    protected ZitherSoundType[] values() {
        return ZitherSoundType.values();
    }

    @Override
    public TogglablePedalSound<ZitherSoundType> midiPedalListener() {
        return new TogglablePedalSound<>(ZitherSoundType.NEW, ZitherSoundType.OLD);
    }



    @Override
    protected void saveSoundType(ZitherSoundType soundType) {
        ModClientConfigs.ZITHER_SOUND_TYPE.set(soundType);
    }

    @Override
    protected boolean isValidForSet(InstrumentScreen screen) {
        return screen instanceof FloralZitherScreen;
    }
}
