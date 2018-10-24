package com.simplifiers.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("hello")
	public Model get() {
		ModelSignal modelSignal = new ModelSignal("Current_available_max", 16, 8);
		ModelSignal modelSignal2 = new ModelSignal("Current_drawn_actl", 8, 8);
		ModelSignal[] modelSignals = {modelSignal, modelSignal2};
		Model model = new Model("Current_Data", "hs", modelSignals);
		return model;
	}
	
	@RequestMapping("someMoreHello")
	public Model someMoreHello() {
		ModelSignal modelSignal = new ModelSignal("Current_available_max", 16, 8);
		ModelSignal modelSignal2 = new ModelSignal("Current_drawn_actl", 8, 8);
		ModelSignal[] modelSignals = {modelSignal, modelSignal2};
		Model model = new Model("Current_Data", "hs", modelSignals);
		return model;
		
	}
	
	@RequestMapping("test")
	public String test() {
		return "Test";
	}
}

class Model {
	String name;
	String busName;
	ModelSignal[] signals;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public ModelSignal[] getSignals() {
		return signals;
	}
	public void setSignals(ModelSignal[] signals) {
		this.signals = signals;
	}
	public Model(String name, String busName, ModelSignal[] signals) {
		super();
		this.name = name;
		this.busName = busName;
		this.signals = signals;
	}
}

class ModelSignal {
	String genericName;
	int bitPosition;
	int bitSize;
	
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	public int getBitPosition() {
		return bitPosition;
	}
	public void setBitPosition(int bitPosition) {
		this.bitPosition = bitPosition;
	}
	public int getBitSize() {
		return bitSize;
	}
	public void setBitSize(int bitSize) {
		this.bitSize = bitSize;
	}
	public ModelSignal(String genericName, int bitPosition, int bitSize) {
		super();
		this.genericName = genericName;
		this.bitPosition = bitPosition;
		this.bitSize = bitSize;
	}	
}