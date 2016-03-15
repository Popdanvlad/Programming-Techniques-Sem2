package operations;
import model.Polynom;
import model.Term;

public class Operations {
	//private Polynom p1;
	//private Polynom p2;
	private Polynom res;
	private Polynom resIntermediar;
	public Operations(){
		
	}
	public Polynom addition(Polynom p1, Polynom p2){
		boolean alreadyExists=false;
		res= new Polynom();
		for(Term t1:p1.getPolinom()){
		res.addTerm(t1.getCoef(), t1.getPower());
		}
		//res=p2;
		for(Term t1:p2.getPolinom()){
			alreadyExists=false;
			for(Term t2:res.getPolinom()){
				if(t1.getPower()==t2.getPower()){
					alreadyExists=true;
					t2.setCoef(t2.getCoef()+t1.getCoef());
				}
			}
			if(alreadyExists==false){
				res.addTerm(t1.getCoef(), t1.getPower());
			}
		}
		return res;
	}
	public Polynom substraction(Polynom p1, Polynom p2){
		boolean alreadyExists=false;
		res= new Polynom();
		for(Term t1:p1.getPolinom()){
			res.addTerm(t1.getCoef(), t1.getPower());
			}
		for(Term t2:p2.getPolinom()){
			alreadyExists=false;
			for(Term t1:res.getPolinom()){
				if(t1.getPower()==t2.getPower()){
					alreadyExists=true;
					t1.setCoef(t1.getCoef()-t2.getCoef());
				}
			}
			if(alreadyExists==false){
				res.addTerm(-t2.getCoef(), t2.getPower());
			}
		}
		return res;
	}
	public Polynom multiplication(Polynom p1, Polynom p2){
		resIntermediar= new Polynom();
		res = new Polynom();
		for(Term t2:p2.getPolinom()){
			for(Term t1:p1.getPolinom()){
				resIntermediar.addTerm(t1.getCoef()*t2.getCoef(),t1.getPower()+t2.getPower());
			}
			res=addition(res,resIntermediar);
			resIntermediar.getPolinom().clear();
		}
		return res;
	}
	
	public Polynom derive(Polynom p1){
		res= new Polynom();
		for(Term t1:p1.getPolinom()){
			if(t1.getPower()!=0){
			res.addTerm(t1.getCoef()*t1.getPower(), t1.getPower()-1);
			}
			else
			{
				res.addTerm(0, 0);
			}
		}
		return res;
	}
	public Polynom integrate(Polynom p1){
		res= new Polynom();
		for(Term t1:p1.getPolinom()){
			res.addTerm(t1.getCoef()/(t1.getPower()+1), t1.getPower()+1);
		}
		return res;
	}
	public String value(Polynom p1, Polynom p2){
		double res=0;
		for(Term t1:p1.getPolinom()){
			res+=t1.getCoef()*Math.pow(p2.getPolinom().get(0).getCoef(),t1.getPower());
		}
		return Double.toString(res);
		
	}
}