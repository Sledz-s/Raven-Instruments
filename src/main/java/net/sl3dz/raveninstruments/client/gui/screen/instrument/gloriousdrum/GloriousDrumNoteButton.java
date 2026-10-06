package net.sl3dz.raveninstruments.client.gui.screen.instrument.gloriousdrum;

import net.sl3dz.raveninstruments.client.config.ModClientConfigs;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.note.NoteButton;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.note.NoteButtonRenderer;
import net.sl3dz.raveninstruments.networking.buttonidentifier.GloriousDrumNoteIdentifier;
import com.mojang.blaze3d.platform.InputConstants.Key;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GloriousDrumNoteButton extends NoteButton {

    public final GloriousDrumButtonType btnType;
    public final boolean isRight;

    public GloriousDrumNoteButton(GloriousDrumButtonType btnType, boolean isRight, AratakisGreatAndGloriousDrumScreen drumScreen) {
        super(
            btnType.getSound(),
            ModClientConfigs.GLORIOUS_DRUM_LABEL_TYPE.get().getLabelSupplier(),
            drumScreen
        );

        this.btnType = btnType;
        this.isRight = isRight;
    }

    @Override
    public GloriousDrumNoteIdentifier getIdentifier() {
        return new GloriousDrumNoteIdentifier(this);
    }


    public Key getKey() {
        return btnType.getKeys().getKey(isRight);
    }


    @Override
    protected NoteButtonRenderer initNoteRenderer() {
        return new NoteButtonRenderer(this, () ->
            instrumentScreen.getResourceFromRoot("note/label/" + switch (btnType) {
                case DON -> "don";
                case KA -> "ka_" + (isRight ? "right" : "left");
            }+".png", false)
        );
    }


    @Override
    public int getNoteOffset() {
        return (btnType == GloriousDrumButtonType.DON) ? 0 : 1;
    }
    
}
