package net.sl3dz.raveninstruments.networking.packet.instrument.util;

import net.sl3dz.raveninstruments.sound.held.HeldNoteSound;

/**
 * Different from {@link HeldNoteSound.Phase}!
 * Represents the packet state of a held note sound.
 */
public enum HeldSoundPhase {
    ATTACK, RELEASE
}
