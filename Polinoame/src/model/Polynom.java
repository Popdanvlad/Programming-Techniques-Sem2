package model;
import java.util.ArrayList;

public class Polynom {
	private ArrayList<Term> polinom = new ArrayList();
	public void addTerm(double coef,int power){
		polinom.add(new Term(coef,power));
	}
	public ArrayList<Term> getPolinom() {
		return polinom;
	}
	public void setPolinom(ArrayList<Term> polinom) {
		this.polinom = polinom;
	}
	public void displayPolynom(){
		for(Term t1:polinom){
			System.out.println(""+t1.getCoef()+" "+ t1.getPower()+"\n");
		}
	}
}
