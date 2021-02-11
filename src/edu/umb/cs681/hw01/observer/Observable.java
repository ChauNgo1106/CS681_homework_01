package edu.umb.cs681.hw01.observer;

import java.util.LinkedList;

public abstract class Observable {

	private LinkedList<Observer> observers;
	protected boolean check;
	float quote;

	public Observable() {
		observers = new LinkedList<Observer>();
	}

	public void addObserver(Observer o) {
		System.out.println("New Observer created");
		this.observers.add(o);
	}

	public void deleteObserver(Observer o) {
		int index = observers.indexOf(o);
		// index of ArrayList starts at 0
		System.out.println("Observer at: " + (index + 2) + " is deleted");
		this.observers.remove(index + 1);
	}

	public void notifyObserver(Object event) {
		setChanged();

		// checking constraint
		if (observers.isEmpty()) {
			System.out.println("Observers is empty!");
			return;
		}

		if (hasChange() && event instanceof DJJA) {
			observers.forEach((Observer observer) -> {
				observer.update(this, event);
				this.printQuote();
			});
		}
		// done.
		clearChanged();
	}

	public void setChanged() {
		this.check = true;
	}

	protected void clearChanged() {
		this.check = false;
	}

	public boolean hasChange() {
		return this.check;
	}

	public void setQuote(float quote) {
		this.quote = quote;
	}

	public void printQuote() {
		System.out.println("Quote: " + this.quote);
	}

}
