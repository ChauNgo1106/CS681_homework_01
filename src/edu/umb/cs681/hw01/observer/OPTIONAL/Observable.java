package edu.umb.cs681.hw01.observer.OPTIONAL;
import java.util.LinkedList;

import edu.umb.cs681.hw01.observer.OPTIONAL.DJJA;


public class Observable<T> {
	private LinkedList<Observer<T>> observers;
	protected boolean check;
	float quote;

	public Observable() {
		observers = new LinkedList<Observer<T>>();
	}

	public void addObserver(Observer<T> o) {
		System.out.println("Observer created");
		this.observers.add(o);
	}

	public void deleteObserver(Observer<T> o) {
		int index = observers.indexOf(o);
		// index of ArrayList starts at 0
		System.out.println("Observer at: " + (index + 2) + " is deleted");
		this.observers.remove(index + 1);
	}

	public void notifyObserver(T event) {
		setChanged();

		// checking constraint
		if (observers.isEmpty()) {
			System.out.println("Observers is empty!");
			return;
		}

		if (hasChange()) {
			observers.forEach((Observer<T> observer) -> {
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
