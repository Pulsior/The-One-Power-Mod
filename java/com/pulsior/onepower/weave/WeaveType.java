package com.pulsior.onepower.weave;

public enum WeaveType {
	
	SNOWBALL(new SnowballWeave() ),
	FIREBALL(new FireballWeave() );
	
	private WeaveType(IWeave weave){
		this.weave = weave;
	}
	
	private IWeave weave;	
	public IWeave getIWeave(){
		return weave;
	}
}

