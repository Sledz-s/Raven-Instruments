package net.sl3dz.raveninstruments.networking;

import net.minecraft.server.level.ServerPlayer;

@FunctionalInterface
public interface OpenInstrumentPacketSender {
    void send(final ServerPlayer player);
}