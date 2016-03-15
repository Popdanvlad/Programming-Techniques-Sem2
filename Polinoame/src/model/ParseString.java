package model;
public class ParseString {
	private String String1;
	private double coef;
	private int power;
	public void setString(String String1){
		this.String1=String1;
	}
	public Polynom convertToPolynom(String string){
		Polynom p = new Polynom();
		int select=0;
		if(string.length()!=0){
		for (String retTerm: string.split("\\+")){
			for (String retval: retTerm.split("x")){
				if(select==0){
					select=1;
					if(retval.charAt(0)=='-')
					{
						coef=-Double.parseDouble(retval.substring(1));
					}
					else
					{
					coef= Double.parseDouble(retval);
					}
				}
				else
				{
					retval = retval.replace("^", "");
					power=Integer.parseInt(retval);
					select=0;
					p.addTerm(coef, power);
				}
			}
			if(select==1){
				power=0;
				p.addTerm(coef, power);
			}
		}
		}
		return p;
	}
	public String convertToString(Polynom p){
		String s="";
		for(Term t:p.getPolinom()){
			s=s+t.getCoef();
			s=s+"x^";
			s=s+t.getPower();
			s=s+"+";
		}
		s = s.substring(0,s.length()-1);
		return s;
	}
}
