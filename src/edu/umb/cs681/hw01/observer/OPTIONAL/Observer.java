package edu.umb.cs681.hw01.observer.OPTIONAL;

@FunctionalInterface
public interface Observer<T> {
	//the very only abstract method in Observer. 
	public void update(Observable<T> obs, T event);
	
}