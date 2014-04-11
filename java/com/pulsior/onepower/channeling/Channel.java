package com.pulsior.onepower.channeling;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.client.OverlayHandler;
import com.pulsior.onepower.weave.Element;
import com.pulsior.onepower.weave.IWeave;
import com.pulsior.onepower.weave.Weave;

public class Channel{
	
	Element[] elements = new Element[]{Element.AIR, Element.FIRE, Element.WATER, Element.EARTH, Element.SPIRIT};
	
	/*The amount of power that can be drawn*/
	float maxPower;
	float amountOfDrawnPower;
	int selectedElement = 2;
	EntityPlayer player;
	
	/*The elements that are currently selected*/
	List<Element> elementsList = new ArrayList<Element>();
	
	
	public Channel(EntityPlayer player){
		/*Render GUI*/
		OverlayHandler.instance().toggleOverlay();

		this.player = player;
		maxPower = 10.0F;
		amountOfDrawnPower = 0;
	}
	
	public float getMaxPower(){
		return maxPower;
	}
	
	public void scroll(int d){
		selectedElement = selectedElement + d;
		
		if(selectedElement == 5){
			selectedElement = 0;
		}
		if(selectedElement == -1){
			selectedElement = 4;
		}
		
		System.out.println(selectedElement);
		OverlayHandler.instance().setSelected(selectedElement);
	}
	
	public void add(){
		elementsList.add( elements[selectedElement] );
	}
	
	public void cast(){
		for(Weave w : Weave.values() ){
			IWeave weave = w.getWeave();
			if(w.getRequiredPower() <= amountOfDrawnPower && weave.getElements().equals(elementsList) ){
				//weave.execute(caster)
			}
		}
	}
	
	/**
	 * Draw power to use in a weave
	 */
	public void drawPower(){
		amountOfDrawnPower = amountOfDrawnPower + 0.005F * maxPower;
		OverlayHandler.instance().updateLevelBar(amountOfDrawnPower / maxPower);
	}
	
	public void close(){
		/*Remove GUI*/
		OverlayHandler.instance().toggleOverlay();
		/*Clear list*/
		elementsList.clear();
		/*Remove references*/
		TheOnePower.removeChannel();
	}
	
}

