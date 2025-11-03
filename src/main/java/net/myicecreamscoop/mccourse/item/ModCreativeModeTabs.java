package net.myicecreamscoop.mccourse.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.myicecreamscoop.mccourse.MCCourseMod;
import net.myicecreamscoop.mccourse.block.ModBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);

    public static final Supplier<CreativeModeTab> MCCOURSE_ITEM_GROUP =
            CREATIVE_MODE_TABS.register("mccourse_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mccourse.mccourse_items_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.BLACK_OPAL);
                        pOutput.accept(ModItems.RAW_BLACK_OPAL);
                        pOutput.accept(ModBlocks.BLACK_OPAL_BLOCK);
                        pOutput.accept(ModBlocks.RAW_BLACK_OPAL_BLOCK);
                        pOutput.accept(ModBlocks.BLACK_OPAL_ORE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_END_ORE);
                        pOutput.accept(ModBlocks.BLACK_OPAL_NETHER_ORE);
                        pOutput.accept(ModItems.CHAINSAW);
                        pOutput.accept(ModBlocks.MAGIC_BLOCK);
                        pOutput.accept(ModBlocks.BLACK_OPAL_STAIRS);
                        pOutput.accept(ModBlocks.BLACK_OPAL_SLAB);

                    })
                    .icon(()-> new ItemStack(ModItems.BLACK_OPAL.get()))
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
