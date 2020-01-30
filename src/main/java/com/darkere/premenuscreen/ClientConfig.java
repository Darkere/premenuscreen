package com.darkere.premenuscreen;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
    private ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    private ForgeConfigSpec spec;
    ForgeConfigSpec.BooleanValue enable;
    ForgeConfigSpec.ConfigValue<String> header;
    ForgeConfigSpec.ConfigValue<String> body;
    ForgeConfigSpec.ConfigValue<String> button;
    ForgeConfigSpec.ConfigValue<String> link;



    ForgeConfigSpec.ConfigValue<String> linkButtonText;

    public ClientConfig() {
        enable = builder.comment("Should the screen appear on the next Start?").define("shouldappear",false);
        header = builder.comment("The Header of the Message").define("header","Put the Header here");
        body = builder.comment("The Body of the Message").define("body","Put the Body of the Message here. Use \n for newline");
        button = builder.comment("The Text on the Button").define("button","Button Text here");
        link = builder.comment("Optional: Adds a second button with a link that can be opened. Leave blank to disable the button").define("link","https://www.curseforge.com/minecraft/mc-mods/pre-menu-screen");
        linkButtonText = builder.comment("Text on the Link Button").define("linkButtonText","CurseForge Page");
        spec = builder.build();
    }

    public boolean getEnabled(){
        return enable.get();
    }

    public void disable(){
        enable.set(false);
    }
    public String getHeader(){
        return header.get();
    }
    public String getBody(){
        return body.get();
    }
    public String getButtonText(){
        return button.get();
    }
    public String getLink() {
        return link.get();
    }

    public String getLinkButtonText() {
        return linkButtonText.get();
    }


    public ForgeConfigSpec getSpec() {
        return spec;
    }



}
