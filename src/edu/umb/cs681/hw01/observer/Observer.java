package edu.umb.cs681.hw01.observer;

@FunctionalInterface
public interface Observer {
	//the very only abstract method in Observer. 
	public void update(Observable obs, Object event);
	
}
