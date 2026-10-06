package net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.note.grid;

import net.sl3dz.raveninstruments.client.config.ModClientConfigs;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.InstrumentScreen;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.grid.GridInstrumentScreen;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.grid.NoteGrid;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.note.NoteButton;
import net.sl3dz.raveninstruments.client.gui.screen.instrument.partial.note.NoteButtonRenderer;
import net.sl3dz.raveninstruments.client.keyMaps.InstrumentKeyMappings;
import net.sl3dz.raveninstruments.networking.buttonidentifier.NoteGridButtonIdentifier;
import net.sl3dz.raveninstruments.sound.NoteSound;
import net.sl3dz.raveninstruments.util.LabelUtil;
import com.mojang.blaze3d.platform.InputConstants.Key;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NoteGridButton extends NoteButton {
    private static final ResourceLocation[] GRID_LABELS = new ResourceLocation[LabelUtil.ABC.length];
    static {
        for (int i = 0; i < LabelUtil.ABC.length; i++) {
            GRID_LABELS[i] = InstrumentScreen.getInternalResourceFromGlob(
                "note/label/grid/" + Character.toLowerCase(LabelUtil.ABC[i]) + ".png"
            );
        }
    }


    public final int row, column;

    public NoteGridButton(int row, int column, GridInstrumentScreen instrumentScreen) {
        super(
            getSoundFromArr(instrumentScreen, instrumentScreen.getInitSounds(), row, column),
            GridInstrumentScreen.getInitLabelSupplier(), instrumentScreen
        );
        
        this.row = row;
        this.column = column;
    }
    /**
     * Creates a button for an SSTI-type instrument
     */
    public NoteGridButton(int row, int column, GridInstrumentScreen instrumentScreen,
            int pitch) {
        super(instrumentScreen.getInitSounds()[0], instrumentScreen.getInitLabelSupplier(), instrumentScreen, pitch);

        this.row = row;
        this.column = column;
    }

    public GridInstrumentScreen gridInstrument() {
        return (GridInstrumentScreen) instrumentScreen;
    }


    public void updateSoundArr() {
        final NoteGrid grid = gridInstrument().noteGrid;
        final NoteSound[] sounds = grid.getNoteSounds();

        setSound(gridInstrument().isSSTI() ? sounds[0]
            : sounds[posToIndex()]
        );
    }

    /**
     * @return The position of this button ({@link NoteGridButton#row}, {@link NoteGridButton#column})
     * as an array index
     */
    public int posToIndex() {
        return row + NoteGrid.getFlippedColumn(column, gridInstrument().columns()) * gridInstrument().rows();
    }
    /**
     * Evaluates the sound at the current position.
     * Meant for static initialization of sounds.
     * @param sounds The sound array of the instrument
     * @see NoteGridButton#posToIndex
     */
    protected static NoteSound getSoundFromArr(GridInstrumentScreen gridInstrument, NoteSound[] sounds, int row, int column) {
        return sounds[row + NoteGrid.getFlippedColumn(column, gridInstrument.columns()) * gridInstrument.rows()];
    }


    public Key getKey() {
        return InstrumentKeyMappings.GRID_INSTRUMENT_MAPPINGS[column][row];
    }


    @Override
    public NoteGridButtonIdentifier getIdentifier() {
        return new NoteGridButtonIdentifier(this);
    }


    @Override
    protected NoteButtonRenderer initNoteRenderer() {
        return new NoteButtonRenderer(this, this::getLabelTexture);
    }
    protected int getLabelTextureRow() {
        return ModClientConfigs.ACCURATE_NOTES.get() ? getABCOffset() : (row % GRID_LABELS.length);
    }

    protected ResourceLocation getLabelTextureAt(final int row) {
        return GRID_LABELS[row];
    }
    protected ResourceLocation getLabelTexture() {
        return getLabelTextureAt(getLabelTextureRow());
    }


    @Override
    public int getNoteOffset() {
        return row + column * gridInstrument().rows();
    }
}
