package net.sl3dz.raveninstruments.client;

import net.sl3dz.raveninstruments.RavenInstrumentsMod;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.InstrumentScreenRegistry;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.djemdjemdrum.DjemDjemDrumScreen;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.floralzither.FloralZitherScreen;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.gloriousdrum.AratakisGreatAndGloriousDrumScreen;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.nightwind_horn.NightwindHornScreen;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.InstrumentScreen;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.ukelele.UkuleleScreen;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.vintagelyre.VintageLyreScreen;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.windsonglyre.WindsongLyreScreen;
import net.sl3dz.raveninstruments.item.clientExtensions.ModItemPredicates;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.model.SeparateTransformsModel;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Map;
import java.util.function.Supplier;

@EventBusSubscriber(value = Dist.CLIENT, bus = Bus.MOD, modid = RavenInstrumentsMod.MODID)
public class ClientInitiator {

    private static final Map<ResourceLocation, Supplier<? extends InstrumentScreen>> INSTRUMENTS = Map.of(
        WindsongLyreScreen.INSTRUMENT_ID, WindsongLyreScreen::new,
        VintageLyreScreen.INSTRUMENT_ID, VintageLyreScreen::new,
        FloralZitherScreen.INSTRUMENT_ID, FloralZitherScreen::new,
        AratakisGreatAndGloriousDrumScreen.INSTRUMENT_ID, AratakisGreatAndGloriousDrumScreen::new,
        NightwindHornScreen.INSTRUMENT_ID, NightwindHornScreen::new,

        UkuleleScreen.INSTRUMENT_ID, UkuleleScreen::new,
        DjemDjemDrumScreen.INSTRUMENT_ID, DjemDjemDrumScreen::new
    );

    @SubscribeEvent
    public static void initClient(final FMLClientSetupEvent event) {
        ModArmPose.load();
        ModItemPredicates.register();

        InstrumentScreenRegistry.register(INSTRUMENTS);
    }

    @SubscribeEvent
    public static void modelLoadEvent(final ModelEvent.RegisterGeometryLoaders event) {
        event.register("separate_transforms", SeparateTransformsModel.Loader.INSTANCE);
    }

}
