package com.darkere.premenuscreen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("premenuscreen")
public class PreMenuScreen
{
    // Directly reference a log4j logger.
    public static ClientConfig CLIENT_CONFIG = new ClientConfig();

    public PreMenuScreen() {
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG.getSpec());
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void GuiOpenEvent(GuiOpenEvent event) {
        if(!(event.getGui() instanceof MainMenuScreen)|| !PreMenuScreen.CLIENT_CONFIG.getEnabled()){
            return;
        }
        PreMenuScreen.CLIENT_CONFIG.disable();
        event.setGui(new PreMenuConfirmScreen((s)->{},() -> Minecraft.getInstance().displayGuiScreen(null)));
    }
}
