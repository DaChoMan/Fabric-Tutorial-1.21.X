package net.dachoman.tutorialmod.item;

import net.dachoman.tutorialmod.TutorialMod;
import net.dachoman.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup PINK_JEWEL_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_jewel_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_JEWEL))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_jewel_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.PINK_JEWEL);
                        entries.add(ModItems.RAW_PINK_JEWEL);

                    }).build());

    public static final ItemGroup PINK_JEWEL_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_jewel_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_JEWEL_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_jewel_blocks"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModBlocks.PINK_JEWEL_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_JEWEL_BLOCK);

                    }).build());


    public static void registerItemGroups() {

        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);

    }

}
