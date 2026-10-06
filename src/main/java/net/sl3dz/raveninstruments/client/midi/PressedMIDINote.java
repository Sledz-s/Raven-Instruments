package net.sl3dz.raveninstruments.client.midi;

import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.note.NoteButton;
import net.sl3dz.raveninstruments.sound.NoteSound;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public record PressedMIDINote(
    int notePitch,
    NoteButton pressedNote,
    NoteSound sound
) {}
