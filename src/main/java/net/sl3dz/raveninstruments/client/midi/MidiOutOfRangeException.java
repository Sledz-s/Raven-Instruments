package net.sl3dz.raveninstruments.client.midi;

public class MidiOutOfRangeException extends Exception {
    
    public MidiOutOfRangeException() {
        super("MIDI note is out of allowed range");
    }

}
