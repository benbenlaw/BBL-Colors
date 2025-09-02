package com.benbenlaw.colors;

import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.config.StartupConfig;
import com.benbenlaw.colors.config.WorldGenConfig;
import com.benbenlaw.colors.item.ColorsCreativeTab;
import com.benbenlaw.colors.item.ColorsItems;
import com.benbenlaw.colors.maps.StrippedLogMap;
import com.benbenlaw.colors.util.ColorHandler;
import com.benbenlaw.colors.worldgen.ColorsWorldGen;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.apache.logging.log4j.LogManager;

import java.awt.*;
import java.util.Map;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Colors.MOD_ID)
public class Colors{

    public static final String MOD_ID = "colors";
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public Colors(final IEventBus modEventBus, final ModContainer modContainer) {

        ColorsBlocks.BLOCKS.register(modEventBus);
        ColorsItems.ITEMS.register(modEventBus);
        ColorsCreativeTab.CREATIVE_TABS.register(modEventBus);

        ColorsWorldGen.PLACEMENTS.register(modEventBus);
        ColorsWorldGen.FEATURES.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.STARTUP, WorldGenConfig.SPEC, "bbl/colors/worldgen.toml");
        modContainer.registerConfig(ModConfig.Type.STARTUP, StartupConfig.SPEC, "bbl/colors/startup.toml");

        modEventBus.addListener(this::registerCapabilities);
        modEventBus.addListener(this::commonSetup);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.register(new ColorHandler());
        }

    }

    public void registerCapabilities(RegisterCapabilitiesEvent event) {
        //ClocheBlockEntities.registerCapabilities(event);
    }

    @EventBusSubscriber(modid = Colors.MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            //event.register(ClocheMenus.CLOCHE_MENU.get(), ClocheScreen::new);
        }
    }

    public void commonSetup(final FMLCommonSetupEvent event) {

        StrippedLogMap logMap = new StrippedLogMap();
        logMap.updateLogMaps();

        event.enqueueWork(() -> {

            for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.POPPY.entrySet()) {
                String poppyBlock = entry.getKey().replace("_poppy", "_potted_poppy");
                DeferredBlock<Block> block = ColorsBlocks.POTTED_POPPY.get(poppyBlock);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(entry.getValue().getId(), block);
            }

            for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.DANDELION.entrySet()) {
                String poppyBlock = entry.getKey().replace("_dandelion", "_potted_dandelion");
                DeferredBlock<Block> block = ColorsBlocks.POTTED_DANDELION.get(poppyBlock);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(entry.getValue().getId(), block);
            }
         });


        //ClocheMessages.registerNetworking(event);
    }

}
