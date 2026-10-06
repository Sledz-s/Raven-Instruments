package net.sl3dz.raveninstruments.client.config.enumType;

import net.sl3dz.raveninstruments.sound.RISounds;
import net.sl3dz.raveninstruments.sound.NoteSound;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public enum ZitherSoundType implements SoundType {
    OLD(() -> RISounds.ZITHER_OLD_NOTE_SOUNDS),
    NEW(() -> RISounds.ZITHER_NEW_NOTE_SOUNDS);

    private Supplier<NoteSound[]> soundArr;
    private ZitherSoundType(final Supplier<NoteSound[]> soundType) {
        this.soundArr = soundType;
    }

    @Override
    public Supplier<NoteSound[]> getSoundArr() {
        return soundArr;
    }
}