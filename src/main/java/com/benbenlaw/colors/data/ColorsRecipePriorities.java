package com.benbenlaw.colors.data;

import com.benbenlaw.colors.Colors;
import com.benbenlaw.colors.block.ColorsBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.RecipePrioritiesProvider;

import java.util.concurrent.CompletableFuture;

public class ColorsRecipePriorities extends RecipePrioritiesProvider {
    public ColorsRecipePriorities(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Colors.MOD_ID);
    }

    @Override
    protected void start() {
        ColorsBlocks.CHESTS.entrySet().forEach(entry -> add(entry.getKey(), 100));
        ColorsBlocks.CRAFTING_TABLE.entrySet().forEach(entry -> add(entry.getKey(), 100));
    }
}