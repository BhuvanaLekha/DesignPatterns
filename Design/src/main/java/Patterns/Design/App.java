package Patterns.Design;
public final class App extends EmployeeFactoryy implements Cloneable
{
   public App()
   {  
  System.out.println("object created");
   }
public static void main(String[] args)
{
	App s = new App();
	App s1=s;   // singleton
	App s2;
try {
s.createEmployee("Abc","fulltime", 100);
s2 = (App) s.clone();   // prototype pattern
System.out.println(s2);

} catch (CloneNotSupportedException e1) {

e1.printStackTrace();
}  


EmployeeFactoryy ef1 = new EmployeeFactoryy();

Employeee e= ef1.createEmployee("jahnavi", "fulltime", 1000000000);
Employeee e1= ef1.createEmployee("bhuvana", "fulltime", 1000000000);
System.out.println(e.toSring());
System.out.println(e1.toSring());

}

}
abstract class  Employeee
{
 String name;
  String type;
 int sal;
public abstract String toSring(); // template pattern
}
class FTEE extends Employeee
{


public FTEE(String namee, String typee, int sall)
{  super();
name  =namee;
type = typee;
sal = sall;

}
public  String toSring()                                      // Factory Method
{

return String.format(name + " " + type+" "+sal );
}

}
class PTEE extends Employeee // Abstract Factory design
{
public PTEE(String namee, String typee, int sall)
{   super();
name  =namee;
type = typee;
sal = sall;

}
public  String toSring()
{

return String.format(name + " " + type+" "+sal );
}

}
class EmployeeFactoryy  
{    
  public Employeee createEmployee(String name, String type,  int sal){
     if(type.equals("fulltime"))
        return new FTEE(name,type,sal);                     //Strategy pattern
     else if(type.equals("parttime"))
        return new PTEE(name,type,sal);
     else
        return null;
  }
 
}