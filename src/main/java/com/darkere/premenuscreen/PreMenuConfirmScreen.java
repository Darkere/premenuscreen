package com.darkere.premenuscreen;

import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import net.minecraft.client.gui.screen.ConfirmScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.StringTextComponent;

public class PreMenuConfirmScreen extends ConfirmScreen {
    Runnable run;
    StringTextComponent stringTextComponent = new StringTextComponent(PreMenuScreen.CLIENT_CONFIG.getBody());

    public PreMenuConfirmScreen(BooleanConsumer s,Runnable run) {
        super(s,new StringTextComponent(PreMenuScreen.CLIENT_CONFIG.getHeader()),new StringTextComponent("message2?"));
        this.run = run;
    }

    @Override
    protected void init() {
        this.addButton(new Button(this.width/2 - 100,200,200,20,PreMenuScreen.CLIENT_CONFIG.getButtonText(),(x)-> run.run()));
        this.listLines.clear();
        this.listLines.addAll(this.font.listFormattedStringToWidth(this.stringTextComponent.getFormattedText(), this.width - 50));
    }
}
