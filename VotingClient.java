
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming; 
import java.rmi.RemoteException; 
import java.net.MalformedURLException; 
import java.rmi.NotBoundException; 
import java.util.Arrays;

 
public class VotingClient 
{ 

	public static int nvoter;
	public static int nvotes;
	public static String [][]cand;
	public static int [][]voter;
	public static void main(String[] args) 
	{ 
	        try 
		{ 
			VotingSystem c = (VotingSystem)Naming.lookup("rmi://localhost/VotingService"); 
                        int temp=c.initialise() ;
			if(temp==0)
    				System.out.println("Succesfull");
	    		else
	    			System.out.println("Failed");	
            		System.out.println( "Welcome");

	    		while(true)
			{
				System.out.println("**************************************************************************"); 
				System.out.println(" 1.Register \n 2.Cast Vote \n 3.Candidate List \n 4.Vote Count \n 5.Exit");
		 		System.out.println("**************************************************************************"); 
            			System.out.println("Enter your choice");  
	 	 		try
				{
					InputStreamReader isr = new InputStreamReader(System.in);
					BufferedReader br = new BufferedReader(isr);
					String s1 = br.readLine();
	        			int input1=Integer.parseInt(s1);
	  				switch(input1)
					{
						case 1: System.out.println("Enter your voterid");
						String s2 = br.readLine();
	      		        		int input2=Integer.parseInt(s2);
						int temp1=c.register(input2);
						if(temp1==0) 
							System.out.println(" Successfully registered");
						else if(temp1==1) 
							System.out.println(" Voterid also exists!");
						else 
							System.out.println("error try again!!");
						break;

						case 2:	System.out.println("Enter the name of the candidate:");
						String s3= br.readLine();
						System.out.println("Enter your VoterID:");
						String s4= br.readLine();
						int input3=Integer.parseInt(s4);
						int temp2=c.castvote(s3.toUpperCase(),input3);
						if(temp2==0) 
							System.out.println("Successfuly voted");
						else if(temp2==1) 
							System.out.println("Candidate added successfully and voted");
						else if(temp2==2)
							System.out.println("Voter not registered Please register");
						else if(temp2==3) 
							System.out.println("You have already voted. duplicate votes not counted.");
						else if(temp2==4)
							System.out.println("Error please try again");
						break;

						case 3: String [][]temp5=c.candidatelist();
							if(temp5[0][0]==null) 
							{
								System.out.println(" no canditate exists ");
								break;
							}
							for (int i1=0; i1<temp5.length; i1++) 
							{
								if(temp5[i1][0]==null)
								{
									break;
								}
								for (int j1=0; j1<temp5[i1].length; j1++) 
								{
									if(temp5[i1][j1]!=null)
					   				     System.out.print(" " + temp5[i1][j1]);
									else	
										break;
								}
					
							System.out.println("");
		 					}

							break;
	
						case 4:System.out.println("Enter the name of the candidate:");
						String s5= br.readLine();
						int temp3=c.votecount(s5.toUpperCase());
						if(temp3!=-1) 
							System.out.println("total vote for selected candidate:"+temp3);
						else 
							System.out.println("Candidate not present");
						break;
	
						case 5: System.exit(0);
						default: System.out.println("invalid input");
			
					}
				}
				catch(Exception ex)
				{ 
					System.out.println("Please enter a valid input"); 
					continue;
				}
	  
			}		      
		} 
	        catch (MalformedURLException murle) 
		{ 
			System.out.println(); 
		        System.out.println("MalformedURLException"); 
			System.out.println(murle); 
	        } 
		catch (RemoteException re) 
		{ 
			System.out.println(); 
			System.out.println("RemoteException"); 
			System.out.println(re); 
		} 
		catch (NotBoundException nbe) 
		{ 
			System.out.println(); 
			System.out.println("NotBoundException"); 
            		System.out.println(nbe); 
		} 
		catch (java.lang.ArithmeticException ae) 
		{ 
			System.out.println(); 
        		System.out.println("java.lang.ArithmeticException"); 
            		System.out.println(ae); 
        	}
 		catch(IOException ex)
		{ 
			System.out.println(ex);
		} 

	} 
} 

