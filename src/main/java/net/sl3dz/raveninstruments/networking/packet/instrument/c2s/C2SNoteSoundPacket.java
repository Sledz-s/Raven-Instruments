package net.sl3dz.raveninstruments.networking.packet.instrument.c2s;

import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.note.NoteButton;
import net.sl3dz.raveninstruments.networking.packet.instrument.NoteSoundMetadata;
import net.sl3dz.raveninstruments.networking.packet.instrument.util.NoteSoundPacketUtil;
import net.sl3dz.raveninstruments.sound.NoteSound;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * A C2S packet notifying the server that a
 * specific {@link NoteSound} should be played in the level
 */
public class C2SNoteSoundPacket extends C2SNotePacket<NoteSound> {

    public C2SNoteSoundPacket(NoteSound sound, NoteSoundMetadata meta) {
        super(sound, meta);
    }
    @OnlyIn(Dist.CLIENT)
    public C2SNoteSoundPacket(NoteButton noteButton, NoteSound sound, int pitch) {
        super(noteButton, sound, pitch);
    }

    public C2SNoteSoundPacket(FriendlyByteBuf buf) {
        super(buf);
    }

    @Override
    protected void writeSound(FriendlyByteBuf buf) {
        sound.writeToNetwork(buf);
    }
    @Override
    protected NoteSound readSound(FriendlyByteBuf buf) {
        return NoteSound.readFromNetwork(buf);
    }

    protected void sendPlayNotePackets(final ServerPlayer player) {
        NoteSoundPacketUtil.sendPlayerPlayNotePackets(player, sound, meta);
    }
}