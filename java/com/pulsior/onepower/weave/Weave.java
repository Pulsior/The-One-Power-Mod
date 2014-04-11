package com.pulsior.onepower.weave;

public enum Weave {
	
	FIREBALL(new FireballWeave(), 4.5F);
	
	private Weave(IWeave weave, float requiredPower){
		this.requiredPower = requiredPower;
		this.weave = weave;
	}
	
	private float requiredPower;
	private IWeave weave;
	
	public float getRequiredPower(){
		return requiredPower;
	}
	
	public IWeave getWeave(){
		return weave;
	}
}

