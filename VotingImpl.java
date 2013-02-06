import java.util.*;
import java.lang.*;

public class VotingImpl extends java.rmi.server.UnicastRemoteObject implements VotingSystem 
{ 
	
	public VotingImpl() throws java.rmi.RemoteException 
	{ 
	        super(); 
	} 

	public int initialise() throws java.rmi.RemoteException 
	{
		try
		{
			System.out.println ("intializing to zero");
			VotingClient cc= new VotingClient();
			cc.nvoter=0;
			cc.nvotes=0;
			cc.cand = new String[10][2];
			cc.voter=new int[100][2];
			return 0;
		}
		catch(Exception ex)
		{
		return 1;
		}
	}

	public int register(int voterid) throws java.rmi.RemoteException 
	{
		try
		{
			VotingClient cc1= new VotingClient();
			int i=0;
			System.out.println ("Registering");
			while(cc1.voter[i][0]!='\0')
			{
				if(cc1.voter[i][0]==voterid)
				{
					System.out.println ("voter id info already exists");
					return 1;
				}
			i++;
			}

			System.out.println ("successfully registered");
			cc1.nvoter++;
			cc1.voter[i][0]=voterid;
			cc1.voter[i][1]=0;
			return 0;
		}
		catch(Exception ex)
		{
			System.out.println (ex);
			return 2;
		}	
	}


	public int castvote(String s,int votid) throws java.rmi.RemoteException 
	{
		try
		{
			int i=0,j=0;
			VotingClient cc2=new VotingClient();
			while(cc2.voter[i][0]!='\0')
			{
				if(cc2.voter[i][0]==votid)
				{
					if( cc2.voter[i][1]==0)
					{
						while(cc2.cand[j][0]!=null)
						{
							if(cc2.cand[j][0].equals(s))
							{
								int t=Integer.parseInt(cc2.cand[j][1]);
								t++;
								cc2.cand[j][1]=Integer.toString(t);
								System.out.println("vote count incresed by one for the selesvted candidate");	
								return 0;	   
							}	
							j++;        
						}
						cc2.cand[j][0]=s;
						cc2.cand[j][1]="1";
						cc2.voter[i][1]=1;
						System.out.println("new candidate added and set vote count set to 1");
						return 1;		 
					}
					else return 3;
				}
				i++;
			}  
			System.out.println("voter id not found");
			return 2;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return 4;
		}			
	}


	public String[][] candidatelist() throws java.rmi.RemoteException
	{
		VotingClient cc3=new VotingClient();
		System.out.println("Sending candidate list");
		return(cc3.cand);
	}


	public int votecount(String name) throws java.rmi.RemoteException 
	{
		try
		{
			int j=0;
			VotingClient cc3=new VotingClient();
			while(cc3.voter[j][0]!='\0')
			{
				if(cc3.cand[j][0].equals(name))
				{
					System.out.println(" vote count for candidate requested ");
					int t=Integer.parseInt(cc3.cand[j][1]);
					return(t);
				}
				j++;
			}
			System.out.println(" i m here");
			int t1=-1;
			return(t1);
		}
		catch(Exception Ex)
		{ 
			return -1;
		}
	}

}











































 
 

