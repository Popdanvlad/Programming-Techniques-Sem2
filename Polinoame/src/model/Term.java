package model;

public class Term {
	private double coef;
	private int power;
	public Term(double coef,int power){
		this.coef=coef;
		this.power=power;
	}
	public double getCoef(){
		return coef;
	}
	public int getPower(){
		return power;
	}
	public void setCoef(double coef){
		this.coef=coef;
	}
	public void setPoser(int power){
		this.power=power;
	}
}
