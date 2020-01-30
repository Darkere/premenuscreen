package com.darkere.premenuscreen;

import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import net.minecraft.client.gui.screen.ConfirmOpenLinkScreen;
import net.minecraft.client.gui.screen.ConfirmScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.Util;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.client.gui.widget.ExtendedButton;

import java.net.URI;
import java.net.URISyntaxException;


public class PreMenuConfirmScreen extends ConfirmScreen {
    Runnable run;
    StringTextComponent stringTextComponent = new StringTextComponent(PreMenuScreen.CLIENT_CONFIG.getBody());
    StringTextComponent link = new StringTextComponent(PreMenuScreen.CLIENT_CONFIG.getLink());
    StringTextComponent linktext = new StringTextComponent(PreMenuScreen.CLIENT_CONFIG.getLinkButtonText());
    URI uri;
    public PreMenuConfirmScreen(BooleanConsumer s, Runnable run) {
        super(s, new StringTextComponent(PreMenuScreen.CLIENT_CONFIG.getHeader()), new StringTextComponent("message2?"));
        this.run = run;
    }

    @Override
    protected void init() {
        if (link.getText().equals("")) {
            this.addButton(new Button(this.width / 2 - 100, this.height - 40, 200, 20, PreMenuScreen.CLIENT_CONFIG.getButtonText(), (x) -> run.run()));
        } else {
            this.addButton(new ExtendedButton(this.width / 2 - 175, this.height - 40, 150, 20, linktext.getText(),this::openLinkScreen));
            this.addButton(new ExtendedButton(this.width / 2 + 25, this.height - 40, 150, 20, PreMenuScreen.CLIENT_CONFIG.getButtonText(), (a)-> run.run()));
        }
        this.listLines.clear();
        this.listLines.addAll(this.font.listFormattedStringToWidth(this.stringTextComponent.getFormattedText(), this.width - 50));
    }


    private void openLinkScreen(Button b){
        try {
            uri = new URI(link.getText());
        } catch (URISyntaxException e) {
            link = new StringTextComponent("broken link");
            e.printStackTrace();
        }
        this.minecraft.displayGuiScreen(new ConfirmOpenLinkScreen((s) -> {
            if (s) {
                Util.getOSType().openURI(uri);
            } else {
                this.minecraft.displayGuiScreen(this);
            }
        }, link.getText(), false));

    }
}
