package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

public class CafeController {
	private CafeModel model;
	private CafeView view;
	
	
	public CafeController(Connection con ,CafeView view) {
		this.model = new CafeModel(con);
		this.view = view;
	}
	
	public void displayALLCafeS() {
		List<CafeDTO> cafes = model.getCafes();
		view.displayCafes(cafes);
		
		
	}
}
