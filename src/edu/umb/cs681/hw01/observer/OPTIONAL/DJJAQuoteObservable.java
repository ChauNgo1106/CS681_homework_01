package edu.umb.cs681.hw01.observer.OPTIONAL;

import edu.umb.cs681.hw01.observer.OPTIONAL.DJJA;


public class DJJAQuoteObservable extends Observable<DJJA> {
	
	public static void main(String[] args) {
		DJJAQuoteObservable soo = new DJJAQuoteObservable();
		
		soo.addObserver( (Observable<DJJA> o , DJJA event) ->{
			System.out.println("***********************Observer 1*********************** ");
		});
	
		soo.setQuote(0.1F);
		soo.notifyObserver(new DJJA(0.1F));
		
		soo.setQuote(0.2F);
		soo.notifyObserver(new DJJA(0.2F));
		
		soo.setQuote(0.3F);
		soo.notifyObserver(new DJJA(0.3F));
		System.out.println();
		
		soo.addObserver( (Observable<DJJA> o , DJJA event) ->{
			System.out.println("***********************Observer 2*********************** ");
		});
		
		soo.deleteObserver((Observable<DJJA> o , DJJA event) ->{
			System.out.println("Delete");
		});
		
		soo.setQuote(1.2F);
		soo.notifyObserver(new DJJA(1.2F));
		
		soo.setQuote(1.1F);
		soo.notifyObserver(new DJJA(1.0F));
		
	}

	
}