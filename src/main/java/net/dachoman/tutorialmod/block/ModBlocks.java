package net.dachoman.tutorialmod.block;

import net.dachoman.tutorialmod.TutorialMod;
import net.dachoman.tutorialmod.block.custom.MagicBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block PINK_JEWEL_BLOCK = registerBlock("pink_jewel_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .mapColor(MapColor.PINK)
                    .instrument(NoteBlockInstrument.BASEDRUM)));
    public static final Block RAW_PINK_JEWEL_BLOCK = registerBlock("raw_pink_jewel_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                    .mapColor(MapColor.DARK_DULL_PINK)
                    .instrument(NoteBlockInstrument.BASEDRUM)));
    public static final Block PINK_JEWEL_ORE = registerBlock("pink_jewel_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                     AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block PINK_JEWEL_DEEPSLATE_ORE = registerBlock("pink_jewel_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3,6),
                     AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));

    private static  Block registerBlock(String name, Block block) {

        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);

    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {

        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {

            entries.add(ModBlocks.PINK_JEWEL_BLOCK);
            entries.add(ModBlocks.RAW_PINK_JEWEL_BLOCK);

        });


    }

}
