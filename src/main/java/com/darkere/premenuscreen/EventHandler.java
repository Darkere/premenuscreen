package com.darkere.premenuscreen;

import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {
    public static boolean skip = false;

    @SubscribeEvent
    public void GuiOpenEvent(GuiOpenEvent event) {
        if(!(event.getGui() instanceof MainMenuScreen)|| !PreMenuScreen.CLIENT_CONFIG.getEnabled() || skip){
            return;
        }
        event.setGui(new PreMenuConfirmScreen());
    }
}
