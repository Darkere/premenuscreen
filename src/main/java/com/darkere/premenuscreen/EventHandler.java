package com.darkere.premenuscreen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public void GuiOpenEvent(GuiOpenEvent event) {
        if(!(event.getGui() instanceof MainMenuScreen)|| !PreMenuScreen.CLIENT_CONFIG.getEnabled()){
            return;
        }
        PreMenuScreen.CLIENT_CONFIG.disable();
        event.setGui(new PreMenuConfirmScreen((s)->{},() -> Minecraft.getInstance().displayGuiScreen(null)));
    }
}
