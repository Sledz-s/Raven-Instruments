package net.sl3dz.raveninstruments;

import net.sl3dz.raveninstruments.item.GIItems;
import net.sl3dz.raveninstruments.networking.GIPacketHandler;
import net.sl3dz.raveninstruments.networking.buttonidentifier.DjemDjemDrumNoteIdentifier;
import net.sl3dz.raveninstruments.networking.buttonidentifier.GloriousDrumNoteIdentifier;
import net.sl3dz.raveninstruments.networking.buttonidentifier.NoteButtonIdentifiers;
import net.sl3dz.raveninstruments.networking.buttonidentifier.NoteGridButtonIdentifier;
import net.sl3dz.raveninstruments.sound.RISounds;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main class of the Raven Instruments mod
 * 
 * @author StavWasPlayZ
 */
@Mod(RavenInstrumentsMod.MODID)
public class RavenInstrumentsMod
{
    public static final String MODID = "raveninstrument";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);


    public RavenInstrumentsMod()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        GIPacketHandler.registerPackets();
        NoteButtonIdentifiers.register(
            NoteGridButtonIdentifier.class,
            GloriousDrumNoteIdentifier.class,
            DjemDjemDrumNoteIdentifier.class
        );

        GIItems.register(bus);
        // ModBlocks.register(bus);
        // ModBlockEntities.register(bus);

        RISounds.register(bus);
        RICreativeModeTabs.regsiter(bus);
    }
}
