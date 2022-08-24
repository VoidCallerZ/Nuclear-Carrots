package com.VoidCallerZ.nc;

import com.VoidCallerZ.nc.registration.BlockRegistration;
import com.VoidCallerZ.nc.registration.ItemRegistration;
import com.VoidCallerZ.nc.setup.ClientSetup;
import com.VoidCallerZ.nc.setup.ModSetup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(NuclearCarrots.MODID)
public class NuclearCarrots
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "nc";

    public NuclearCarrots()
    {
        ModSetup.setup();
        BlockRegistration.init();
        ItemRegistration.init();

        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetup::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));
    }
}
