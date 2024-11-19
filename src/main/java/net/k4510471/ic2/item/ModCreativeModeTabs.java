package net.k4510471.ic2.item;

import net.k4510471.ic2.IndustrialCraft2;
import net.k4510471.ic2.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IndustrialCraft2.MOD_ID);

    public static final Supplier<CreativeModeTab> IC2_BLOCKS_TAB = CREATIVE_MODE_TABS.register("ic2_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TIN_BLOCK))
                    .title(Component.translatable("creativetab.ic2.blocks"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.TIN_BLOCK);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> IC2_ITEMS_TAB = CREATIVE_MODE_TABS.register("ic2_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIN_INGOT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(IndustrialCraft2.MOD_ID, "ic2_blocks_tab"))
                    .title(Component.translatable("creativetab.ic2.items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.TIN_INGOT);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
