package com.revature.model;

public class Player {
	
	private long id;
	private String name;
	private long num;
	private String psition;
	private double battingAverage;
	
	//autogenned getters, setters, constructor, toString:
	
	public Player(long id, String name, long num, String position, double battingAverage) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.position = position;
		this.battingAverage = battingAverage;
	}
	
	//Required for Jackson
	public Player() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getBattingAverage() {
		return battingAverage;
	}
	public void setBattingAverage(double battingAverage) {
		this.battingAverage = battingAverage;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", num=" + num + ", position=" + position + ", battingAverage="
				+ battingAverage + "]";
	}

}
