package com.piratesgaming.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public final class PiratesScreen extends Screen {
 private final Screen parent; private String section="HOME";
 public PiratesScreen(Screen parent){super(Text.literal("Pirates Client"));this.parent=parent;}
 @Override protected void init(){build();}
 private void build(){
  add(25,65,175,"⚔ PvP",()->section="PVP"); add(25,101,175,"▣ HUD",()->section="HUD"); add(25,137,175,"✚ Crosshair",()->section="CROSSHAIR"); add(25,173,175,"◆ Visuals",()->section="VISUALS"); add(25,209,175,"♜ Custom Capes",()->section="CAPES"); add(25,245,175,"⌨ Keybinds",()->section="KEYBINDS");
  if(section.equals("HOME")){ add(235,90,320,"⚔ PvP",()->section="PVP"); add(235,130,320,"▣ HUD",()->section="HUD"); add(235,170,320,"✚ Crosshair",()->section="CROSSHAIR"); add(235,210,320,"◆ Visuals",()->section="VISUALS"); add(235,250,320,"♜ Custom Capes",()->section="CAPES"); add(235,290,320,"⌨ Keybinds",()->section="KEYBINDS"); add(235,335,320,"🏴‍☠ PIRATES MODE: "+(PiratesClient.piratesMode?"ON":"OFF"),()->PiratesClient.piratesMode=!PiratesClient.piratesMode); }
  else if(section.equals("PVP")){toggle(235,95,"Motion Blur",()->PiratesClient.motionBlur=!PiratesClient.motionBlur,()->PiratesClient.motionBlur); toggle(400,95,"Particles",()->{},()->false); toggle(235,135,"Animations",()->{},()->false); toggle(400,135,"Zoom",()->{},()->false);}
  else if(section.equals("HUD")){toggle(235,95,"Boss Bar",()->PiratesClient.bossBar=!PiratesClient.bossBar,()->PiratesClient.bossBar); toggle(400,95,"Scoreboard",()->PiratesClient.scoreboard=!PiratesClient.scoreboard,()->PiratesClient.scoreboard); toggle(235,135,"Armor HUD",()->{},()->true); toggle(400,135,"FPS / CPS / Ping",()->{},()->true);}
  else if(section.equals("CAPES")){toggle(235,95,"Custom Capes",()->PiratesClient.customCapes=!PiratesClient.customCapes,()->PiratesClient.customCapes);}
  else if(section.equals("KEYBINDS")){add(235,95,320,"/keybinds save <1-5>",()->{});add(235,135,320,"/keybinds load <1-5>",()->{});add(235,175,320,"/keybinds delete <1-5>",()->{});}
  else if(section.equals("CROSSHAIR")){add(235,95,320,"Smooth Crosshair Editor",()->{});}
  add(25,320,120,"← Back",()->section="HOME");
 }
 private void add(int x,int y,int w,String s,Runnable r){addDrawableChild(ButtonWidget.builder(Text.literal(s),b->{r.run();clearAndInit();}).dimensions(x,y,w,30).build());}
 private void toggle(int x,int y,String s,Runnable r,java.util.function.BooleanSupplier v){add(x,y,150,s+" ["+(v.getAsBoolean()?"ON":"OFF")+"]",r);}
 protected void clearAndInit(){clearChildren();init();}
 @Override public void render(DrawContext c,int mx,int my,float d){c.fill(0,0,width,height,0xE90A0F18);c.fill(0,0,215,height,0xF00B101A);c.fill(215,0,width,55,0xF0121B2B);c.drawTextWithShadow(textRenderer,"🏴‍☠ PIRATES CLIENT",25,25,0x55BFFF);c.drawTextWithShadow(textRenderer,section,235,25,0xFFFFFF);MinecraftClient mc=MinecraftClient.getInstance();String server=mc.getCurrentServerEntry()==null?"Not Connected":mc.getCurrentServerEntry().address;int online=mc.getNetworkHandler()==null?0:mc.getNetworkHandler().getPlayerList().size();c.drawTextWithShadow(textRenderer,"Server: "+server+"  •  Online: "+online,230,height-18,0xB7C8D9);super.render(c,mx,my,d);}
 @Override public void close(){if(client!=null)client.setScreen(parent);}
}
