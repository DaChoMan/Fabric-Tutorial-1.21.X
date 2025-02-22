package net.dachoman.tutorialmod.item;

import net.dachoman.tutorialmod.TutorialMod;
import net.dachoman.tutorialmod.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PINK_JEWEL = registerItem("pink_jewel", new Item(new Item.Settings()));
    public static final Item RAW_PINK_JEWEL = registerItem("raw_pink_jewel", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));


    private  static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);

    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {

            entries.add(PINK_JEWEL);
            entries.add(RAW_PINK_JEWEL);

        });

    }

}
