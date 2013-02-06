 
public interface VotingSystem extends java.rmi.Remote 
{ 
   
	public int initialise() throws java.rmi.RemoteException;

	public int register(int voterid) throws java.rmi.RemoteException; 

	public int castvote(String name,int voterid) throws java.rmi.RemoteException;

	public String[][] candidatelist() throws java.rmi.RemoteException;	

	public int votecount(String name) throws java.rmi.RemoteException;
 	
} 

