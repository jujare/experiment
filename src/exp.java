import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;


/**
 * CVRPData.java
 *
 * This class provides most of the information in fruitybun-data.vrp
 * (and what this class does not provide you do not need).
 * This class provides "get methods" to access the demand and distance 
 * information and it does some parameter checking to make sure
 * that nodes passed to the get methods are within the valid range.
 *
 * It does NOT provide direct access to node coordinates and instead only
 * computes the Euclidean distance between them. However, it would be easy
 * to add a get method to access coordinates, although you would have to
 * decide how to return a coordinate: in an array or some kind of coordinate 
 * class.
 *
 * This class is an alternative to reading fruitybun-data.vrp. This class
 * is more convenient if you want to work in java but it encodes
 * the data as arrays so it specifies only the fruitybun CVRP instance.
 * In contrast, code that can read fruitybun-data.vrp should be able to
 * read other .vrp files.
 *
 * @author Tim Kovacs
 * @version 9/9/2011
 * 
 * @author Sreekanth Jujare
 * @version 8/11/2012
 */

public class exp {

    /** The capacity that all vehicles in fruitybun-data.vrp have. */
    public static final int VEHICLE_CAPACITY = 220;

    /** The number of nodes in the fruitybun CVRP i.e. the depot and the customers */
    public static final int NUM_NODES = 76;

    /** Return the demand for a given node. */
    public static int getDemand(int node) {
	if (!nodeIsValid(node)) {
	    System.err.println("Error: demand for node " + node + 
			       " was requested from getDemand() but only nodes 1.." + NUM_NODES + " exist");
	    System.exit(-1);
	}	    
	return demand[node];
    }
        
    /** Return the Euclidean distance between the two given nodes */
    public static double getDistance(int node1, int node2) {
	if (!nodeIsValid(node1)) {
	    System.err.println("Error: distance for node " + node1 + 
			       " was requested from getDistance() but only nodes 1.." + NUM_NODES + " exist");
	    System.exit(-1);
	}	    
	
	if (!nodeIsValid(node2)) {
	    System.err.println("Error: distance for node " + node2 + 
			       " was requested from getDistance() but only nodes 1.." + NUM_NODES + " exist");
	    System.exit(-1);
	}	    

	int x1 = coords[node1][X_COORDINATE];
	int y1 = coords[node1][Y_COORDINATE];
	int x2 = coords[node2][X_COORDINATE];
	int y2 = coords[node2][Y_COORDINATE];

	// compute Euclidean distance
	return Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));

    // For example, the distance between 33,44 and 44,13 is:
    // 33-44 = -11 and 11^2 = 121
    // 44-13 = 31 and 31^2 = 961
    // 121 + 961 = 1082
    // The square root of 1082 = 32.893768...
    // A simpler example is the distance between nodes 54 and 36, which have coordinates 55,57 and 55,50 and distance 7.0
    }    

    /** Return true if the given node is within the valid range (1..NUM_NODES), false otherwise */
    private static boolean nodeIsValid(int node) {
	if (node < 0 || node > NUM_NODES-1)
	    return false;
	else
	    return true;
    }
    
    private static final int X_COORDINATE = 0; // x-axis coordinate is dimension 0 in coords[][]
    private static final int Y_COORDINATE = 1; // y-axis coordinate is dimension 1 in coords[][]

    // 2-dimensional array with the coordinates of each node in fruitybun-data.vrp. 
    // coords[0] is a dummy entry which is not used. Node 1 is at coords[1], node 2 is at coords[2] and so on.
    // A more Object-Oriented solution would have been to create coordinate objects but that may be overkill.
    private static int [][] coords = new int[][] 
	{
	 {40, 40}, // the coordinates of node 0 (the depot)
	 {22, 22}, // the coordinates of node 1 ...
	 {36, 26},
	 {21, 45},
	 {45, 35},
	 {55, 20},
	 {33, 34},
	 {50, 50},
	 {55, 45},
	 {26, 59}, // node 11
	 {40, 66},
	 {55, 65},
	 {35, 51},
	 {62, 35},
	 {62, 57},
	 {62, 24},
	 {21, 36},
	 {33, 44},
	 {9, 56},
	 {62, 48}, // node 21
	 {66, 14},
	 {44, 13},
	 {26, 13},
	 {11, 28},
	 {7, 43},
	 {17, 64},
	 {41, 46},
	 {55, 34},
	 {35, 16},
	 {52, 26}, // node 31
	 {43, 26},
	 {31, 76},
	 {22, 53},
	 {26, 29},
	 {50, 40},
	 {55, 50},
	 {54, 10},
	 {60, 15},
	 {47, 66},
	 {30, 60}, // node 41
	 {30, 50},
	 {12, 17},
	 {15, 14},
	 {16, 19},
	 {21, 48},
	 {50, 30},
	 {51, 42},
	 {50, 15},
	 {48, 21},
	 {12, 38}, // node 51
	 {15, 56},
	 {29, 39},
	 {54, 38},
	 {55, 57},
	 {67, 41},
	 {10, 70},
	 {6, 25},
	 {65, 27},
	 {40, 60},
	 {70, 64}, // node 61
	 {64, 4},
	 {36, 6},
	 {30, 20},
	 {20, 30},
	 {15, 5},
	 {50, 70},
	 {57, 72},
	 {45, 42},
	 {38, 33},
	 {50, 4},  // node 71
	 {66, 8},
	 {59, 5},
	 {35, 60},
	 {27, 24},
	 {40, 20},
	 {40, 37}};// node 75

    private static int[] demand = new int[]
	{
	 0,  // node 1
	 18, // node 2
	 26, // node 3
	 11, // node 4
	 30, // node 5
	 21, // node 6
	 19, // node 7
	 15, // node 8
	 16, // node 9
	 29, // node 10
	 26, // node 11
	 37, // node 12
	 16, // node 13
	 12, // node 14
	 31, // node 15
	 8,  // node 16
	 19, // node 17
	 20, // node 18
	 13, // node 19
	 15, // node 20
	 22, // node 21
	 28, // node 22
	 12, // node 23
	 6,  // node 24
	 27, // node 25
	 14, // node 26
	 18, // node 27
	 17, // node 28
	 29, // node 29
	 13, // node 30
	 22, // node 31
	 25, // node 32
	 28, // node 33
	 27, // node 34
	 19, // node 35
	 10, // node 36
	 12, // node 37
	 14, // node 38
	 24, // node 39
	 16, // node 40
	 33, // node 41
	 15, // node 42
	 11, // node 43
	 18, // node 44
	 17, // node 45
	 21, // node 46
	 27, // node 47
	 19, // node 48
	 20, // node 49
	 5,  // node 50
	 22, // node 51
	 12, // node 52
	 19, // node 53
	 22, // node 54
	 16, // node 55
	 7,  // node 56
	 26, // node 57
	 14, // node 58
	 21, // node 59
	 24, // node 60
	 13, // node 61
	 15, // node 62
	 18, // node 63
	 11, // node 64
	 28, // node 65
	 9,  // node 66
	 37, // node 67
	 30, // node 68
	 10, // node 69
	 8,  // node 70
	 11, // node 71
	 3,  // node 72
	 1,  // node 73
	 6,  // node 74
	 10, // node 75
	 20};// node 76    

	private static double[][] distanceMat = new double[76][76];
	private static double[][] tmp = new double[76][76];
	private static int[][] nearestDistMat = new int[76][76];
	private static int[][] solutions = new int[76][76];
	private static final double annLimit = 150;
	private static double tries = annLimit;
	
	private static void calDistMat()
	{
		for(int i = 0; i < NUM_NODES; i++)
		{
			for(int j = i; j < NUM_NODES; j++)
			{
				// Diagonal elements
				if (i == j)
				{
					distanceMat[i][j] = 0;
					// copy
					tmp[i][j] = 0;
				}
				else
				{
					distanceMat[i][j] = getDistance(i,j);
					distanceMat[j][i] = distanceMat[i][j];
					// copy
					tmp[i][j] = getDistance(i,j);
					tmp[j][i] = tmp[i][j];					
				}
			}
		}
	}
	
	private static int partition(double realDist[], int points[], int left, int right)
	{
	      int i = left, j = right;
	      double tmp;
	      int tmp1;
	      double pivot = realDist[(left + right) / 2];
	     
	      while (i <= j) {
	            while (realDist[i] < pivot)
	                  i++;
	            while (realDist[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = realDist[i];
	                  realDist[i] = realDist[j];
	                  realDist[j] = tmp;

	                  tmp1 = points[i];
	                  points[i] = points[j];
	                  points[j] = tmp1;
	                  
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	private static  void quickSort(double realDist[], int points[], int left, int right) {
	      int index = partition(realDist, points, left, right);
	      if (left < index - 1)
	            quickSort(realDist, points, left, index - 1);
	      if (index < right)
	            quickSort(realDist, points, index, right);
	}
	
	private static void calNearDist()
	{	
		for(int i = 0; i < NUM_NODES; i++)
		{
			for (int j = 0; j < NUM_NODES; j++)
			{
				nearestDistMat[i][j] = j;
			}
			quickSort(tmp[i], nearestDistMat[i], 0, 75);
		}
	}
	
	public static void printSolution(int solution[], double cost)
	{
		int capacity = 0;
		int demand = 0;
		
		System.out.printf("login sj12845\n", cost);
		
		System.out.printf("cost %.3f\n", cost);
		
		System.out.printf("1");
		for (int i = 1; i < NUM_NODES; i++)
		{
			demand = getDemand(solution[i]);
			if (capacity + demand <= VEHICLE_CAPACITY)
			{
				System.out.printf("->%d", solution[i]+1);
				capacity += demand;
			}
			else
			{
				System.out.printf("->1\n");
				System.out.printf("1->%d", solution[i]+1);
				capacity = demand;
			}
			
			if (i == NUM_NODES - 1) // Last stop
			{
				System.out.printf("->1");
			}
		}		
	}
	
	public static double fitness(int solution[])
	{
		int capacity = 0;
		int demand = 0;
		double distance = 0;
		boolean distanceAdded = true;
		
		distance = distanceMat[0][solution[1]];
		
		//System.out.printf("\nFrom 1 to %d : %f\n", solution[1]+1, distanceMat[0][solution[1]]);
		for (int i = 1; i < NUM_NODES; i++)
		{
			demand = getDemand(solution[i]);
			if (capacity + demand <= VEHICLE_CAPACITY)
			{
				if (!distanceAdded)
				{
					distance += distanceMat[solution[i-1]][solution[i]];
					//System.out.printf("to %d : %f\n", solution[i]+1, distanceMat[solution[i-1]][solution[i]]);
				}
				else
					distanceAdded = false;
				capacity += demand;
			}
			else
			{
				capacity = demand;
				distance += distanceMat[solution[i-1]][0];
				//System.out.printf("to %d : %f\n", 1, distanceMat[solution[i-1]][0]);
				distance += distanceMat[0][solution[i]];
				//System.out.printf("From 1 to %d : %f\n", solution[i]+1, distanceMat[0][solution[i]]);
				distanceAdded = false;
			}
			
			if (i == NUM_NODES - 1) // Last stop
			{
				distance += distanceMat[solution[i]][0];
				//System.out.printf("to %d : %f\n", 1, distanceMat[solution[i]][0]);
			}
		}
		
		return distance;
	}

	private static void permute(int seed[], int fill[][], int i1, int i2)
	{
		int size = (NUM_NODES-1)/3;
		int index = i1;
		
		/*
		 * Seed : A,B,C
		 */
		
		/*
		 * A,C,B
		 */
		for(int j = 1; j <= size; j++)
		{
			fill[index][j] = seed[j];
		}	
		for(int j = size+1; j <= 2*size; j++)
		{
			fill[index][j] = seed[j+size];
		}
		for(int j = 2*size+1; j <= 3*size; j++)
		{
			fill[index][j] = seed[j-size];
		}
		index++;
		
		/*
		 * C,B,A
		 */
		for(int j = 1; j <= size; j++)
		{
			fill[index][j] = seed[j+2*size];
		}	
		for(int j = size+1; j <= 2*size; j++)
		{
			fill[index][j] = seed[j];
		}
		for(int j = 2*size+1; j <= 3*size; j++)
		{
			fill[index][j] = seed[j-2*size];
		}		
		index++;
		
		/*
		 * C,A,B
		 */
		for(int j = 1; j <= size; j++)
		{
			fill[index][j] = seed[j+2*size];
		}	
		for(int j = size+1; j <= 2*size; j++)
		{
			fill[index][j] = seed[j-size];
		}
		for(int j = 2*size+1; j <= 3*size; j++)
		{
			fill[index][j] = seed[j-size];
		}		
		index++;
		
		/*
		 * B,C,A
		 */
		for(int j = 1; j <= size; j++)
		{
			fill[index][j] = seed[j+size];
		}	
		for(int j = size+1; j <= 2*size; j++)
		{
			fill[index][j] = seed[j+size];
		}
		for(int j = 2*size+1; j <= 3*size; j++)
		{
			fill[index][j] = seed[j-2*size];
		}		
		index++;
		
		/*
		 * B,A,C
		 */
		for(int j = 1; j <= size; j++)
		{
			fill[index][j] = seed[j+size];
		}	
		for(int j = size+1; j <= 2*size; j++)
		{
			fill[index][j] = seed[j-size];
		}
		for(int j = 2*size+1; j <= 3*size; j++)
		{
			fill[index][j] = seed[j];
		}
		
		return;
	}
	
	private static void SAHillClimber3Opt(int rnn[], double cost) throws InterruptedException
	{
		double newCost = cost;
		int[][] neighbor = new int[47][NUM_NODES];
		int[] tmp;
		int size = (NUM_NODES-1)/3;
		double tmpValue;
		double min = 99999.0;
		
		tries = annLimit;
		//code

    	
		//System.out.println("\nHC3 starting with initial solution ::");
		for(int j = 1; j < NUM_NODES; j++)
		{
			//System.out.printf("%d ", rnn[j]);
		}
		
		tmp = rnn.clone();
		
				
			int j,k;
			/*
			 * A,B,C
			 */
			permute(tmp, neighbor, 0, 4);
			
			/*
			 * A,B,F(c)
			 */
			for(j = 1; j <= 2*size; j++)
			{
				neighbor[5][j] = tmp[j];
			}
			for(j = 2*size+1, k = 3*size; j <= 3*size; j++, k--)
			{
				neighbor[5][j] = tmp[k];
			}
			permute(neighbor[5], neighbor, 6, 10);
			
			/*
			 * A,F(B),c
			 */
			for(j = 1; j <= size; j++)
			{
				neighbor[11][j] = tmp[j];
			}	
			for(j = size+1, k = 2*size; j <= 2*size; j++, k--)
			{
				neighbor[11][j] = tmp[k];
			}
			for(j = 2*size+1; j <= 3*size; j++)
			{
				neighbor[11][j] = tmp[j];
			}
			permute(neighbor[11], neighbor, 12, 16);
			
			/*
			 * F(A),B,c
			 */
			for(j = 1, k = size; j <= size; j++, k--)
			{
				neighbor[17][j] = tmp[k];
			}	
			for(j = size+1; j <= 2*size; j++)
			{
				neighbor[17][j] = tmp[j];
			}
			for(j = 2*size+1; j <= 3*size; j++)
			{
				neighbor[17][j] = tmp[j];
			}
			permute(neighbor[17], neighbor, 18, 22);
			
			/*
			 * A,F(B),F(c)
			 */
			for(j = 1; j <= size; j++)
			{
				neighbor[23][j] = tmp[j];
			}	
			for(j = size+1, k = 2*size; j <= 2*size; j++, k--)
			{
				neighbor[23][j] = tmp[k];
			}
			for(j = 2*size+1, k = 3*size; j <= 3*size; j++, k--)
			{
				neighbor[23][j] = tmp[k];
			}
			permute(neighbor[23], neighbor, 24, 28);
			
			/*
			 * F(A),B,F(c)
			 */
			for(j = 1, k = size; j <= size; j++, k--)
			{
				neighbor[29][j] = tmp[k];
			}	
			for(j = size+1; j <= 2*size; j++)
			{
				neighbor[29][j] = tmp[j];
			}
			for(j = 2*size+1, k = 3*size; j <= 3*size; j++, k--)
			{
				neighbor[29][j] = tmp[k];
			}
			permute(neighbor[29], neighbor, 30, 34);
			
			/*
			 * F(A),F(B),c
			 */
			for(j = 1, k = size; j <= size; j++, k--)
			{
				neighbor[35][j] = tmp[k];
			}	
			for(j = size+1, k = 2*size; j <= 2*size; j++, k--)
			{
				neighbor[35][j] = tmp[k];
			}
			for(j = 2*size+1; j <= 3*size; j++)
			{
				neighbor[35][j] = tmp[j];
			}
			permute(neighbor[35], neighbor, 36, 40);
			
			/*
			 * F(A),F(B),F(c)
			 */
			for(j = 1, k = size; j <= size; j++, k--)
			{
				neighbor[41][j] = tmp[k];
			}	
			for(j = size+1, k = 2*size; j <= 2*size; j++, k--)
			{
				neighbor[41][j] = tmp[k];
			}
			for(j = 2*size+1, k = 3*size; j <= 3*size; j++, k--)
			{
				neighbor[41][j] = tmp[k];
			}
			permute(neighbor[41], neighbor, 42, 46);
			
			min = newCost;
			System.out.println("");
			for (j = 0; j <= 46; j++)
			{
				for (k = 1; k < NUM_NODES; k++)
				{
					System.out.printf("%d", neighbor[j][k]);
				}
				System.out.println("");
			}
			

				
		//return neighbor[1];
	}
	

	private static double Anneal()
	{
		tries-=tries/annLimit;
		return tries/annLimit;
	}
	
	private static int[] SAHillClimber2Opt(int rnn[], double cost) throws InterruptedException
	{
		double newCost = cost;
		int[][] neighbor = new int[7][NUM_NODES];
		int[] tmp;

		tries = annLimit;
		
		//System.out.println("HC2 starting with initial solution ::");
		for(int j = 1; j < NUM_NODES; j++)
		{
			//System.out.printf("%d ", rnn[j]);
		}
		
		tmp = rnn.clone();
		
		do // until there is no better solution
		{
			int i;
			
			for (i = 1; i < NUM_NODES; i++)
			{
				/*
				 * A : [1,i] , B : [i+1,NUM_NODES-1]
				 */
				
				int j,k;
				
				/*
				 * F(A)+B
				 */
				for (k = 1, j = i; (k <= i); k++, j--)
				{
					neighbor[0][k] = tmp[j];
				}
				for (k = i+1; (k <= NUM_NODES-1); k++)
				{
					neighbor[0][k] = tmp[k];
				}
				
				/*
				 * A+F(B)
				 */
				for (k = 1; (k <= i) ; k++)
				{
					neighbor[1][k] = tmp[k];
				}
				for (k = i+1, j = NUM_NODES-1; (k <= NUM_NODES-1); k++, j--)
				{
					neighbor[1][k] = tmp[j];
				}
				
				/*
				 * F(A)+F(B)
				 */
				for (k = 1, j = i; (k <= i); k++, j--)
				{
					neighbor[2][k] = tmp[j];
				}
				for (k = i+1, j = NUM_NODES-1; (k <= NUM_NODES-1); k++, j--)
				{
					neighbor[2][k] = tmp[j];
				}
				
				/*
				 * B+A
				 */
				for (k = 1, j = i+1; (k <= NUM_NODES-1-i) ; k++, j++)
				{
					neighbor[3][k] = tmp[j];
				}
				for (k = NUM_NODES-i, j = 1; (k <= NUM_NODES-1) ; k++, j++)
				{
					neighbor[3][k] = tmp[j];
				}

				/*
				 * B+F(A)
				 */
				for (k = 1, j = i+1; (k <= NUM_NODES-1-i) ; k++, j++)
				{
					neighbor[4][k] = tmp[j];
				}
				for (k = NUM_NODES-i, j = i; (k <= NUM_NODES-1) ; k++, j--)
				{
					neighbor[4][k] = tmp[j];
				}
				
				/*
				 * F(B)+F(A)
				 */
				for (k = 1, j = NUM_NODES-1; (k <= NUM_NODES-1-i) ; k++, j--)
				{
					neighbor[5][k] = tmp[j];
				}
				for (k = NUM_NODES-i, j = i; (k <= NUM_NODES-1) ; k++, j--)
				{
					neighbor[5][k] = tmp[j];
				}
				
				/*
				 * F(B)+A
				 */
				for (k = 1, j = NUM_NODES-1; (k <= NUM_NODES-1-i) ; k++, j--)
				{
					neighbor[6][k] = tmp[j];
				}
				for (k = NUM_NODES-i, j = 1; (k <= NUM_NODES-1) ; k++, j++)
				{
					neighbor[6][k] = tmp[j];
				}
				
				//System.out.println("\nNeighbors of HC2::");
				
				double min = newCost;
				double tmpValue;
				
				for (j = 0; j < 7; j++)
				{
					for (k = 1; k < NUM_NODES; k++)
					{
						//System.out.printf("%d ", neighbor[j][k]);
					}
					//System.out.println("\nCost :");
					
					tmpValue = fitness(neighbor[j]);
					//System.out.printf("%f\n", tmpValue);
					if (tmpValue < min || Anneal() > 0)
					{
						min = tmpValue;
						tmp = neighbor[j].clone();
						newCost = min;
						break;
					}				
				}
				
				if (j != 7)
				{
					// new solution found, start with i = 1
					i = 0;
					//System.out.print("\nNew Solution found : ");
					for(int t = 1; t < NUM_NODES; t++)
					{
						//System.out.printf("%d ", tmp[t]);
					}
					//Thread.sleep(500);
					continue;
				}

			}
			
			if (i == NUM_NODES)
			{
				// There is no improvement from the previous solution
				break;
			}
		}while(true);	
	
		return tmp;
	}
	
	public static boolean areEqual(int[] a, int[] b)
	{
		for(int i = 1; i < NUM_NODES; i++)
		{
			if (a[i] != b[i])
				return false;
		}
		
		return true;
	}
	
    public static void main(String[] args) throws InterruptedException
    {	
    	int[] HC2;
    	int[] HC3;    	
    	int[] newsol = new int[NUM_NODES];
    	
    	long startTime = System.nanoTime();
    	/*
    	 * Prepare distance matrix
    	 */
    	calDistMat();

    	/*
    	 * Display distance matrix
    	 */
    	//System.out.println("Distance matrix : ");
		for(int i = 0; i < NUM_NODES; i++)
		{
			for(int j = 0; j < NUM_NODES; j++)
			{
				//System.out.printf("%f\t", distanceMat[i][j]);
			}
			//System.out.println("");
		}
		
		Thread.sleep(1000);

		/*
		 * Prepare nearest distance matrix
		 */
		calNearDist();
		
		/*
    	 * Display distance matrix
    	 */
    	//System.out.println("Nearest Distance Array : ");
		for(int i = 0; i < NUM_NODES; i++)
		{
			for(int j = 0; j < NUM_NODES; j++)
			{
				//System.out.printf("%d\t", nearestDistMat[i][j]);
			}
			//System.out.println("");
		}
		
		/*
		 * Prepare solution
		 */
		for(int i = 1; i < NUM_NODES; i++)
		{
			solutions[i][0] = i; 
			for(int j = 1; j < NUM_NODES; j++)
			{
				int index = 1;
				int elem;
				while (true)
				{
					int k;
					elem = nearestDistMat[solutions[i][j-1]][index];
					
					// if the point is depot, ignore!!
					if (elem == 0) 
					{
						index++;
						continue;
					}
					
					for (k = 1; k < j; k++)
					{ 
						if (elem == solutions[i][k])
						{
							index++;
							break;
						}
					}
					
					if (k == j)
					{
						solutions[i][j] = elem;
						break;
					}
				} 	
			}
		}
		
		/*
		 * Display solutions
		 */
    	//System.out.println("Solution matrix : ");
		for(int i = 1; i < NUM_NODES; i++)
		{
			for(int j = 0; j < NUM_NODES; j++)
			{
				//System.out.printf("%d\t", solutions[i][j]);
			}
			//System.out.println("");
		}
		
		double min = 99999.0;
		double tmp;
		double tmp2;
		int index = 0;
		
		//HC2 = SAHillClimber2Opt(solutions[i], fitness(solutions[i]));
		for(int i = 1; i < NUM_NODES; i++)
		{
			System.out.printf("%d", solutions[1][i]);
		}	
		System.out.println();
		SAHillClimber3Opt(solutions[1], fitness(solutions[1]));
		
		/*
		 * Steep Ascent Hill Climber
		 */
		/*HC2 = SAHillClimber2Opt(solutions[index], min);
		//System.out.println("%%%%%%%%%%%%%%   HC2 result : ");
		for(int i = 0; i < NUM_NODES; i++)
		{
			//System.out.printf("%d ", HC2[i]);
		}

		HC3 = SAHillClimber3Opt(HC2, fitness(HC2));
		//System.out.println("%%%%%%%%%%%%%%   HC3 result : ");
		for(int i = 0; i < NUM_NODES; i++)
		{
			//System.out.printf("%d ", HC3[i]);
		}
		//System.out.println("HC3.equals(HC2) :"+HC3.equals(HC2));
		
		while (areEqual(HC2, HC3) == false)
		{
			HC2 = SAHillClimber2Opt(HC3, fitness(HC3));		
			HC3 = SAHillClimber3Opt(HC2, fitness(HC2));
		}*/
		
		/*
		 * Print Solution
		 */
		Thread.sleep(10000);
		//System.out.printf("\nThe final solution (cost : %.3f):: \n", fitness(newsol));
		for(int i = 0; i < NUM_NODES; i++)
		{
			//System.out.printf("%d ", newsol[i]);
		}	
		//printSolution(newsol, fitness(newsol));
		
		//code
    	long endTime = System.nanoTime();;
    	long secs = (endTime - startTime) / 1000000000;
    	long mins = secs / 60;
    	secs = secs % 60 ;
    	System.out.println("Time taken : "+mins+ " mins "+secs+" secs"); 
    }
}