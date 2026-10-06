package net.sl3dz.raveninstruments.item;

import net.sl3dz.raveninstruments.capability.instrumentOpen.InstrumentOpenProvider;
import net.sl3dz.raveninstruments.client.ModArmPose;
import net.sl3dz.raveninstruments.networking.OpenInstrumentPacketSender;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class WindInstrumentItem extends InstrumentItem {

    public WindInstrumentItem(OpenInstrumentPacketSender onOpenRequest) {
        super(onOpenRequest);
    }
    public WindInstrumentItem(OpenInstrumentPacketSender onOpenRequest, Properties properties) {
        super(onOpenRequest, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {

            @Override
            public @Nullable HumanoidModel.ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack) {
            return (
                (entityLiving instanceof Player player)
                ? (InstrumentOpenProvider.isOpen(player) && InstrumentOpenProvider.isItem(player))
                    ? ModArmPose.PLAYING_WIND_INSTRUMENT
                    : null
                : null
            );
            }

        });
    }

}
