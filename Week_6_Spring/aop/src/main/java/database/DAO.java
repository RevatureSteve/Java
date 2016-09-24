package database;

public class DAO {

	// Joinpoint (an Aspect could potentially sneak in here)
	public SessionFactory getSessionFactory(){
		System.out.println("SessionFactory sf = new Configuration()"
				+ ".configure().buildSessionFactory()");
		//Integer.parseInt("hsfaglj"); // exception
		return new SessionFactory();
	}
	
	public String getSomething(int i){
		System.out.println(""+i);
		return ""+i;
	}
	
	public String getSomething(String i){
		System.out.println(""+i);
		return ""+i;
	}
	
	public void getSomethingElse(int i, int y){
		System.out.println(""+i+""+y);
	}
	
}
