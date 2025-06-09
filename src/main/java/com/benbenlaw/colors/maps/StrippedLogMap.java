package com.benbenlaw.colors.maps;

import com.benbenlaw.core.block.brightable.BrightLog;
import com.benbenlaw.core.util.ColorList;

import static com.benbenlaw.colors.block.ColorsBlocks.*;

public class StrippedLogMap {
    public void updateLogMaps() {

        System.out.println("Updating log maps...");

        for (String color : ColorList.COLORS) {
            BrightLog.updateLogStrippedMap(LOGS.get(color + "_log").get(), LOGS.get(color + "_stripped_log").get());
            BrightLog.updateWoodStrippedMap(WOOD.get(color + "_wood").get(), WOOD.get(color + "_stripped_wood").get());
            BrightLog.updateLogStrippedMap(BAMBOO.get(color + "_bamboo").get(), BAMBOO.get(color + "_stripped_bamboo").get());
        }
    }


}
