package com.yipeekiyaay.inventorypause.utils;

import net.minecraft.client.gui.screen.ingame.*;

public class ScreenHelper {
    // private static final ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

    public static boolean isConfiguredScreen(Object screen) {
        return isInventory(screen) || isCraftingTable(screen) || isShulkerBox(screen) || isChest(screen);
    }

    private static boolean isInventory(Object screen) {
        return screen instanceof AbstractInventoryScreen;
    }

    private static boolean isCraftingTable(Object screen) {
        return screen instanceof CraftingScreen;
    }

    private static boolean isShulkerBox(Object screen) {
        return screen instanceof ShulkerBoxScreen;
    }

    private static boolean isChest(Object screen) {
        return screen instanceof GenericContainerScreen;
    }

//    private static boolean isCustomMenu(Object screen) {
//        for (String s : config.customScreens) {
//            if(screen.getClass().getName().equals(s)) {
//                return true;
//            }
//        }
//        return false;
//    }
}
