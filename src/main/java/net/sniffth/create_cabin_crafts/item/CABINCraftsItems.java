package net.sniffth.create_cabin_crafts.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sniffth.create_cabin_crafts.CreateCABINCrafts;
import net.sniffth.create_cabin_crafts.item.saws.CustomSaw;

public class CABINCraftsItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateCABINCrafts.MODID);

    public static final DeferredItem<Item> SAW_BLADE = ITEMS.register("saw_blade",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRILL_HEAD = ITEMS.register("drill_head",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> KINETIC_MECHANISM = ITEMS.register("kinetic_mechanism",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INCOMPLETE_KINETIC_MECHANISM = ITEMS.register("incomplete_kinetic_mechanism",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SEALED_MECHANISM = ITEMS.register("sealed_mechanism",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INCOMPLETE_SEALED_MECHANISM = ITEMS.register("incomplete_sealed_mechanism",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> REINFORCED_MECHANISM = ITEMS.register("reinforced_mechanism",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INCOMPLETE_REINFORCED_MECHANISM = ITEMS.register("incomplete_reinforced_mechanism",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LOGISTIC_MECHANISM = ITEMS.register("logistic_mechanism",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> INCOMPLETE_LOGISTIC_MECHANISM = ITEMS.register("incomplete_logistic_mechanism",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_LEAD = ITEMS.register("raw_lead",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LEAD_INGOT = ITEMS.register("lead_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LEAD_PLATE = ITEMS.register("lead_sheet",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LEAD_NUGGET = ITEMS.register("lead_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RUBBER = ITEMS.register("rubber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CURED_RUBBER = ITEMS.register("cured_rubber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<CustomSaw> STONE_SAW = ITEMS.register("stone_saw",
            () -> new CustomSaw(new Item.Properties().durability(131)));
    public static final DeferredItem<CustomSaw> IRON_SAW = ITEMS.register("iron_saw",
            () -> new CustomSaw(new Item.Properties().durability(250)));
    public static final DeferredItem<CustomSaw> DIAMOND_SAW = ITEMS.register("diamond_saw",
            () -> new CustomSaw(new Item.Properties().durability(1561)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
