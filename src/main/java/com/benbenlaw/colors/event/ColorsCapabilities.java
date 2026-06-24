package com.benbenlaw.colors.event;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.ColorsBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.Container;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.transfer.CombinedResourceHandler;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.VanillaContainerWrapper;

import javax.annotation.Nullable;

@EventBusSubscriber(modid = Colors.MOD_ID)
public class ColorsCapabilities {


    private static final DoubleBlockCombiner.Combiner<ChestBlockEntity, ResourceHandler<ItemResource>> CHEST_COMBINER_HANDLER = new DoubleBlockCombiner.Combiner<>() {
        @Override
        public ResourceHandler<ItemResource> acceptDouble(ChestBlockEntity chest1, ChestBlockEntity chest2) {
            return new CombinedResourceHandler<>(VanillaContainerWrapper.of(chest1), VanillaContainerWrapper.of(chest2));
        }

        @Override
        public ResourceHandler<ItemResource> acceptSingle(ChestBlockEntity chest) {
            return VanillaContainerWrapper.of(chest);
        }

        @Override
        public ResourceHandler<ItemResource> acceptNone() {
            return null;
        }
    };

    @SubscribeEvent
    private static void registerGenericItemHandlers(RegisterCapabilitiesEvent event) {

        ColorsBlocks.CHESTS.entrySet().forEach(entry -> {
            event.registerBlock(Capabilities.Item.BLOCK, (level, pos, state, blockEntity, side) ->
                    ((ChestBlock) state.getBlock()).combine(state, level, pos, true).apply(CHEST_COMBINER_HANDLER), entry.getValue().get());
        });


    }
}
