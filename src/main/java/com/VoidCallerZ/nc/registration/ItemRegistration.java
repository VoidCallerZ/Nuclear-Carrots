package com.VoidCallerZ.nc.registration;

import com.VoidCallerZ.nc.setup.ModSetup;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.VoidCallerZ.nc.NuclearCarrots.MODID;

public class ItemRegistration
{
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void init()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
    }

    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.NUCLEAR_CARROTS_TAB);

    public static final RegistryObject<Item> NUCLEAR_CARROT = ITEMS.register("nuclear_carrot", () -> new Item(ITEM_PROPERTIES));

    public static final RegistryObject<Item> URANIUM_ORE = fromBlock(BlockRegistration.URANIUM_ORE);
    public static final RegistryObject<Item> DEEPSLATE_URANIUM_ORE = fromBlock(BlockRegistration.DEEPSLATE_URANIUM_ORE);

    private static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block)
    {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }
}
