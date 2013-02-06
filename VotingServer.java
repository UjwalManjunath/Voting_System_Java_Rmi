 
import java.rmi.Naming;

public class VotingServer 
{

	public VotingServer() 
	{
	     	try 
		{
	       		VotingSystem c = new VotingImpl();
	       		Naming.rebind("rmi://localhost:1099/VotingService", c);
		} 
		catch (Exception e) 
		{
		       System.out.println("Trouble: " + e);
		}
	}

	public static void main(String args[])
	{
		new VotingServer();
	}
}


