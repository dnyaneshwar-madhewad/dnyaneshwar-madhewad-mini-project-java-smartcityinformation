import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
class Cityinformation implements Serializable
{

	int Cityid;
	String name;
	int Rent;
	long contact_no;
	String email_id;
	String location;
	String type;
	
	
	public Cityinformation(int Cityid, String name, int Rent, long contact_no, String email_id, String location, String type)
	{
		this.Cityid = Cityid;
		this.name = name;
		this.Rent = Rent;
		this.contact_no = contact_no;
		this.email_id = email_id;
		this.location=location;
		this.type=type;
	}
	
	public String toString()
	{
     	return "\n\n  Deatails are below : " + "\n  Cityid: " + this.Cityid + "\n  Name: " + this.name + "\n  Rent: " + this.Rent + "\n  Contact No: " + this.contact_no + "\n  Email-id: " + this.email_id + "\n  Location: " + this.location + "\n  Type: " + this.type;
	}
	
}


public class Smartcity
{	
 
	static void display(ArrayList<Cityinformation> al)
	{
		
	    System.out.println("==============================================================================================");			
        System.out.println("                      SMART CITY Information LIST                                             ");	
		System.out.println("==============================================================================================");	
		System.out.println(String.format("%-10s%-13s%-10s%-15s%-20s%-15s%-10s", "Cityid","Name","Rent","contact-no","Email_id","Location","Type"));
		for(Cityinformation e : al)
		{
			System.out.println(String.format("%-8s%-15s%-10s%-15s%-20s%-15s%-10s",e.Cityid,e.name,e.Rent,e.contact_no,e.email_id,e.location,e.type));
		}
		System.out.println("==============================================================================================");
        }
	
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		int Cityid;
		String name;
		int Rent;
		long contact_no;
		String email_id;
		String location;
		String type;
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Cityinformation> al = new ArrayList<Cityinformation>();
		
		File f = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos =null;
		
		
		
		try{
			  f = new File("D:\\Database5\\Citydatabase.txt");
			  if(f.exists())
			    {
				    fis = new FileInputStream(f);
				    ois = new ObjectInputStream(fis);
				    al = (ArrayList<Cityinformation>)ois.readObject();
			    }
			
		   }
		catch(Exception exp)
		   {
			   System.out.println("File Exception ");
	           }
		
		System.out.println("==============================================================================================");			
        System.out.println("              WELCOME TO SMART CITY Information                                               ");	
		System.out.println("==============================================================================================");
		System.out.println("     Please select an option below                                                            ");
		System.out.println("==============================================================================================");
		System.out.println("  1: Administrator                                                                            ");
		System.out.println("  2: User     							                                                      ");
		System.out.println("==============================================================================================");
		System.out.print("Enter your choice : ");
		int choice = scan.nextInt();
		
		if(choice == 1)
		{
			
		System.out.println("\nEnter the Details");
		System.out.print("Enter Username : ");
		String aName = scan.next();
		System.out.print("Enter Password : ");
		String pass = scan.next();
			
		if(aName.equals("cdac") && pass.equals("cdac"))
		{
		do
		{
               System.out.println("==============================================================================================");			
               System.out.println("              WELCOME TO SMART CITY Information                                               ");	
			   System.out.println("==============================================================================================");
               System.out.println("     Please select an option below                                                            ");		
	           System.out.println("***************Menu***************************************************************************");
			   System.out.println("  1: Display SMART CITY Information                                                           ");
			   System.out.println("  2: Search for City Information                                                              ");
		       System.out.println("  3: Add Data to our SMART City Information                                                   ");
		       System.out.println("  4: Edit Information details                                                                 ");
		       System.out.println("  5: Delete Data from SMART CITY Information                                                  ");
	           System.out.println("  6: EXIT                                                                                     ");
			   System.out.println("==============================================================================================");					   
	           System.out.print("Enter your choice : ");
          	   int ch =scan.nextInt(); 
				
		 switch(ch)
		   {
			case 1: 
			        try{
					      al = (ArrayList<Cityinformation>)ois.readObject();
					   }

				    catch(Exception e2)
					    {					
					     
				        }
					display(al);
				    break;   
			case 2: 
			        System.out.println("Enter Cityid to Search in SMART CITY LIST");
		                Cityid = scan.nextInt();
					    int i=0;
					          for(Cityinformation e: al)
					            {
						           if(Cityid == e.Cityid)
						            {
							            System.out.println(e+"\n");
							            i++;
						            }
					            }
					if(i == 0)
					    {
						  System.out.println("\nCityinformation Details are not available, Please enter a valid Cityid!!");
					    }
			        break;
								

			case 3:
			        System.out.println("\nEnter the following details to ADD list:\n");			  
				    System.out.println("Enter Cityid :");
			        Cityid = scan.nextInt();
				
				    System.out.println("Enter Name :");
				    name = scan.next();
							  
				    System.out.println("Enter Rent :");
				    Rent = scan.nextInt();
							  
				    System.out.println("Enter Contact No :");
				    contact_no = scan.nextLong();
							  
				    System.out.println("Enter Email_id :");
				    email_id = scan.next();
							  
					System.out.println("Enter Location :");
				    location = scan.next();
							  
					System.out.println("Enter Type:");
				    type = scan.next();
				
				    al.add(new Cityinformation(Cityid, name, Rent, contact_no, email_id, location, type));
				    display(al);
				    break;
					
			case 4:               
			        System.out.println("\nEnter the Cityid to EDIT the details");
					Cityid = scan.nextInt();
					int j=0;
					    for(Cityinformation e: al)
					        {
						      if(Cityid == e.Cityid)
						         {	
						           j++;
						            do
									{
							             int ch1 =0;
							             System.out.println("  1: City ID        ");
		                                 System.out.println("  2: Name           ");
		                                 System.out.println("  3: Rent           ");
		                                 System.out.println("  4: Contact No     ");
	                         	         System.out.println("  5: Email_id       ");
						 		         System.out.println("  6: Location       ");
								         System.out.println("  7: Type           ");
	                                     System.out.println("  8: Goback         ");
							             System.out.println("Enter your choice : ");
							         ch1 = scan.nextInt();
							         switch(ch1)
							             {
							              case 1: System.out.println("\nEnter new Cityid:");
								                  e.Cityid =scan.nextInt();
									              System.out.println(e+"\n");
									              break;
							
							              case 2: System.out.println("Enter new Name:");
									              e.name =scan.next();
									              System.out.println(e+"\n");
									              break;
									
							              case 3: System.out.println("Enter new Rent:");
									              e.Rent =scan.nextInt();
									              System.out.println(e+"\n");
									              break;
									
							              case 4: System.out.println("Enter new Contact No. :");
									              e.contact_no =scan.nextLong();
									              System.out.println(e+"\n");
									              break;
									
							              case 5: System.out.println("Enter new Email_id :");
									              e.email_id =scan.next();
									              System.out.println(e+"\n");
									              break;
												  
								          case 6: System.out.println("Enter new Location :");
									              e.location =scan.next();
									              System.out.println(e+"\n");
									              break;
												  
                                          case 7: System.out.println("Enter new Type :");
									              e.type =scan.next();
									              System.out.println(e+"\n");
									              break;												  
									
							              case 8: j++;
									              break;
									
							              default :System.out.println("\nEnter a correct choice from the Given List :");
									              break;		
						                  }
						            }while(j==1);
						         }
					        }
					 
        			    if(j == 0)
					        {
						      System.out.println("\n Details are not available, Please enter a valid Cityid ");
				    	    }
			        break;	
					
			case 5: System.out.println("\nEnter Cityid to DELETE from the Smart City information Databse :");
					Cityid = scan.nextInt();
					
					int k=0;
					     try{
					         for(Cityinformation e: al)
					           {
						          if(Cityid == e.Cityid)
						            {
								      al.remove(e);
								      display(al);
								      k++;
						            }
					           }
					         if(k == 0)
					           {
						         System.out.println("\n Details are not available, Please enter a Valid City ID");
					           }
					        }
						
					      catch(Exception ex)
					           {
						         System.out.println("Detail not Available");
				         	    }
						
				    break;
			
			case 6:  try{
				          fos = new FileOutputStream(f);
				          oos = new ObjectOutputStream(fos);
				          oos.writeObject(al);
				        }
			         catch(Exception e2)
			            {
				          System.out.println("File Closing exception");
				        }
				      finally
					     {
					      try{
						       fis.close();
						       ois.close();
						       fos.close();
						       oos.close();
					         }
					      catch(Exception e1)
						     {
					           System.out.println("File Closing exception");
						     }
				         }
					
					  System.out.println("\n Thank you for using our Smart City AppliCation.");
					  scan.close();
					  System.exit(0);					   
					  break;
			default : System.out.println("\nEnter a correct choice from the List :");
				      break;
			}
		}
		while(true);
		}
		else
		{
			System.out.println("\nSorry Login failed.");
			System.exit(0);
		}
		
		

	}
	    if(choice == 2)
		{
			do
		{
               System.out.println("==============================================================================================");			
               System.out.println("              WELCOME TO SMART CITY Information                                               ");	
			   System.out.println("==============================================================================================");
               System.out.println("     Please select an option below                                                            ");		
	           System.out.println("***************Menu***************************************************************************");
			   System.out.println("  1: Display SMART CITY Information                                                           ");
			   System.out.println("  2: Search for City Information                                                              ");
	           System.out.println("  3: EXIT                                                                                     ");
			   System.out.println("==============================================================================================");					   
	           System.out.print("Enter your choice : ");
          	   int ch2 =scan.nextInt(); 
				
		 switch(ch2)
		   {
			case 1: 
			        try{
					      al = (ArrayList<Cityinformation>)ois.readObject();
					   }

				    catch(Exception e2)
					    {					
					     
				        }
					display(al);
				    break;   
			case 2: 
			        System.out.println("Enter Cityid to Search in SMART CITY LIST");
		                Cityid = scan.nextInt();
					    int i=0;
					          for(Cityinformation e: al)
					            {
						           if(Cityid == e.Cityid)
						            {
							            System.out.println(e+"\n");
							            i++;
						            }
					            }
					if(i == 0)
					    {
						  System.out.println("\nCityinformation Details are not available, Please enter a valid Cityid!!");
					    }
			        break;
			case 3: System.out.println("\n Thank you for using our Smart City AppliCation.");
					System.exit(0);					   
					 break;
			default : System.out.println("\nEnter a correct choice from the List :");
				      break;
			}
		}
		while(true);
		}
	
	
	
}

	
}