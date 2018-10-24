package com.simplifiers.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("hello")
	public String hello() {
		return "Hello world";
	}
	
	
	@GetMapping("get")
	public Model get() {
		ModelSignal modelSignal = new ModelSignal("Current_available_max", 16, 8);
		ModelSignal modelSignal2 = new ModelSignal("Current_drawn_actl", 8, 8);
		ModelSignal[] modelSignals = {modelSignal, modelSignal2};
		Model model = new Model("Current_Data", "hs", modelSignals);
		return model;
	}
}

class Model {
	String name;
	String busName;
	ModelSignal[] signals;
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
	public ModelSignal(String genericName, int bitPosition, int bitSize) {
		super();
		this.genericName = genericName;
		this.bitPosition = bitPosition;
		this.bitSize = bitSize;
	}	
}