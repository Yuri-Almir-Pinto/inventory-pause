package com.yipeekiyaay.inventorypause;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Inventorypausemod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("inventorypausemod");

	@Override
	public void onInitialize() {

		LOGGER.info("Inventory Pause Mod initiating! Thank you for installing me! :>");
	}
}