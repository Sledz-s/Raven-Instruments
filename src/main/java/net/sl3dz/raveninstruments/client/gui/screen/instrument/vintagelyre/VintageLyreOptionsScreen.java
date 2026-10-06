package net.sl3dz.raveninstruments.client.gui.screen.instrument.vintagelyre;

import net.sl3dz.raveninstruments.client.config.ModClientConfigs;
import net.sl3dz.raveninstruments.client.gui.screen.options.instrument.partial.SingleButtonOptionsScreen;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VintageLyreOptionsScreen extends SingleButtonOptionsScreen {

    public VintageLyreOptionsScreen(final VintageLyreScreen screen) {
        super(screen);
    }

    @Override
    protected String optionsLabelKey() {
        return "label.raveninstrument.vintage_lyre_options";
    }


    @Override
    protected AbstractButton constructButton() {
        return CycleButton.booleanBuilder(CommonComponents.OPTION_ON, CommonComponents.OPTION_OFF)
            .withInitialValue(ModClientConfigs.NORMALIZE_VINTAGE_LYRE.get())
            .withTooltip((value) -> Tooltip.create(Component.translatable("button.raveninstrument.normalize_vintage_lyre.tooltip")))
            .create(0, 0,
                getBigButtonWidth(), getButtonHeight(),
                Component.translatable("button.raveninstrument.normalize_vintage_lyre"), this::onNormalizeLyreChanged
            );
    }

    private void onNormalizeLyreChanged(CycleButton<Boolean> button, Boolean value) {
        ModClientConfigs.NORMALIZE_VINTAGE_LYRE.set(value);
    }
}