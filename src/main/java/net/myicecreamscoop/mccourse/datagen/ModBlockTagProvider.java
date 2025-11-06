package net.myicecreamscoop.mccourse.datagen;

import net.myicecreamscoop.mccourse.MCCourseMod;
import net.myicecreamscoop.mccourse.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLACK_OPAL_BLOCK.get())
                .add(ModBlocks.RAW_BLACK_OPAL_BLOCK.get())
                .add(ModBlocks.BLACK_OPAL_ORE.get())
                .add(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE.get())
                .add(ModBlocks.BLACK_OPAL_END_ORE.get())
                .add(ModBlocks.BLACK_OPAL_NETHER_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.BLACK_OPAL_ORE.get())
                .add(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE.get())
                .add(ModBlocks.BLACK_OPAL_STAIRS.get())
                .add(ModBlocks.BLACK_OPAL_SLAB.get())
                .add(ModBlocks.BLACK_OPAL_PRESSURE_PLATE.get())
                .add(ModBlocks.BLACK_OPAL_BUTTON.get())
                .add(ModBlocks.BLACK_OPAL_WALL.get())
                .add(ModBlocks.BLACK_OPAL_FENCE.get())
                .add(ModBlocks.BLACK_OPAL_BLOCK.get())
                .add(ModBlocks.BLACK_OPAL_TRAPDOOR.get())
                .add(ModBlocks.BLACK_OPAL_DOOR.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.BLACK_OPAL_FENCE.get());
        tag(BlockTags.WALLS)
        .add(ModBlocks.BLACK_OPAL_WALL.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.BLACK_OPAL_FENCE_GATE.get());

        this.tag(BlockTags.DOORS)
                .add(ModBlocks.BLACK_OPAL_DOOR.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BLACK_OPAL_END_ORE.get())
                .add(ModBlocks.BLACK_OPAL_NETHER_ORE.get());
        this.tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.BLACK_OPAL_TRAPDOOR.get());

    }
}