/** parcels rearrangement using queue */
import java.util.*;
import java.io.*;
//acguln
public class ParcelQueues
{
   // data members
   private static ListQueue [] track; 	// array of holding tracks, there are three buffer tracks
										// therefore, it should declare new ListQueue[3]
   private static int numberOfParcels;	//Number of Paarcels
   private static int numberOfTracks;
   private static int smallestParcel; 	// smallest parcel in any holding track,
										// you should check what is the smallest parcel number in three tracks      
   
	private static int[] hh= new int[3];
	private static int nextParcelToOutput;
   private static int nextOutputTrack;  // holding track with car smallestParcel,
   private static ListQueue output;
   private static int outputtime;
   
                                        


   /** all the necessary methods should be constructed here **/

	public static boolean smallarthan1(int number){
		if (number <= 0){
                return true;
            }
			return false;
	}
        public static void putInHoldingTrack(int num){
			for (int i=0;i<3;i++){
				if(hh[i]<numberOfParcels/numberOfTracks){
					hh[i]++;//count size of listqueues
					track[i].enqueue(new Integer(num));
					System.out.println("Move parcel " + num
						+ " from input buffer to holding track H" +(i+1));
							return;		
				}	
			}
				return;
			}
		
	 public static void outputFromHoldingTrack(){
			int numb;
			int avg;
			avg=numberOfParcels/numberOfTracks;
			sdf:
			for (int i=0;i<3;i++){
				if (hh[i]==0){//check null ListQueue
						continue sdf;
					}
					dfg:
					for (int jkl=0;jkl<avg;jkl++){
						if (hh[i]==0){//check null ListQueue
						continue dfg;
					}
					if((Integer)track[i].peekFront()==smallestParcel){
						numb=(Integer)track[i].dequeue();
						System.out.println("Move parcel " + numb
										+ " from from holding track H" + (i+1) + " to output buffer");
										smallestParcel=numb+1;
										//nextParcelToOutput++;
										hh[i]--;
										
					}
					}
			}
			return;
	 }

   /** main method for the application */
   public static void main(String [] args) throws DuplicationException
   {
	    ListQueue output= new ListQueue();
   	    final int NUMTRACK = 3;  // assume only three buffer tracks
	    final int NUMPARCEL = 100; // maximum parcel number is 100 (1-100)
		numberOfTracks=NUMTRACK;
	    Scanner sc = new Scanner(System.in);    // Scanner class

				
	    // define variables and int array to store input parcel numbers
		int [] p = new int[NUMPARCEL];
		int v = 0;
		int countofinputtime=0;
		boolean sd = false;
	    
		tt:
		do   // do while loop to ask for number one by one, repeat while input is > 0
		{
			try {
				// ask for parcel number and store in array
				// if the number is duplicate, then throw DuplicatonException
				// if the input is mismatch the format, the system will jump to InputMismatchException

				System.out.print("Enter parcel number (enter <= 0 to exit) : ");
				p[v] = sc.nextInt();
				sd=smallarthan1(p[v]);
				if (sd==true){
					break tt;}
				checksame:
				for (int i = 0; i < v; i++) {
					for (int j = i + 1 ; j < p.length; j++) {
							//if (p[i]==p[j]&& p[i]== null) { 
							 //break checksame;//
							 //} 
						 if (p[i]==p[j]) { 
							 throw new DuplicationException();// chk duplication error
							 } 
						} 
				}
				v+=1;
				}
			catch (DuplicationException e) {
				System.out.println("[DuplicationException "+ p[v]  +" caught!]");
				throw new DuplicationException();
				
			}
			catch (InputMismatchException e) {
				System.out.println("[InputMismatchException catch]");
				throw new InputMismatchException();
				
			}
			
		} while (sd==false);
		numberOfParcels=v;
	    // print out the number of Tracks, Number of Parcels
		// start running
		System.out.println("Number of Tracks = " + NUMTRACK);
		System.out.println("Number of Paarcels = " + v);
		int [] new_p = new int[v];
		int [] new_p2 = new int[v];
		for(int ss=0;ss<v;ss++){
			new_p[ss]=p[ss];//del null
		}
		for(int ss=0;ss<v;ss++){
			new_p2[ss]=p[ss];//del null
		}
		Arrays.sort(new_p2);//asc array
		new_p2[0]=smallestParcel;//smallest value of array
		
		
		
		System.out.printf("Input order of parcels <from left to right > is : %s", 
                          Arrays.toString(new_p)); 
		System.out.println("");
		for(int i=0;i<numberOfTracks;i++){
			hh[i]=0;
		}
		// Start running by calling the appropriate methods

      // create queues track[1:numberOfTracks] for use as holding tracks
		  track = new ListQueue[NUMTRACK];  //
		  for (int i = 0; i < NUMTRACK; i++)
			 track[i] = new ListQueue();

		  int nextParcelToOutput = 1; // nextParcelToOutput is the number which is expected to output directly,
		                              // at initial, when parcel #1 came then move to output
		  
		  // rearrange parcels
		  // read each parcel number from the input array (input by scanner) one by one
		  for (int q=0;q<numberOfParcels;q++)
		  {	
		  	//System.out.println("1 "+q+ " " +smallestParcel+ " " + nextParcelToOutput);
			 if (new_p[q]==nextParcelToOutput) // if coming parcel number equals to "nextParcelToOutput" ..... )
			 {// send parcel number directly to output
				 nextParcelToOutput++;
				 smallestParcel=new_p[q]+1;
				  System.out.println("Move parcel " + new_p[q]
									+ " from input buffer to output buffer directly");
							
			 }
			 else {
			 // put parcel inputOrder[i] in a holding track
			 // if the parcel cannot move output, then you need store in buffer track (1, 2, or 3)
			 // you should write a method to handle it
				putInHoldingTrack(new_p[q]);
				
			 }

			 // after you handled the new coming parcel number
			 // you should have a looping that checks the smallest parcel number in the currect three buffers 
			 // if  the smallest parcel number is the next output parcel number (nextParcelToOutput)
			 // then move it from buffer to output and repeat checking again
			 while (smallestParcel == nextParcelToOutput)
			 {
				outputFromHoldingTrack();
				nextParcelToOutput++;
				//outputFromHoldingTrack();
				//System.out.println(q+ " " +smallestParcel+ " " + nextParcelToOutput);
			 }
		  } 
		  if(nextParcelToOutput<=v){
			  System.out.println("Fail to rearrage the parcels!");
		  }
		  System.out.println("Press any key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
   }
}
