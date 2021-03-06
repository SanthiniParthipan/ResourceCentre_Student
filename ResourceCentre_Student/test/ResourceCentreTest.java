import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}

	
	@Test
	public void addCamcorderTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, camcorderList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", cc1, camcorderList.get(0));
		
		//Add another item. test The size of the list is 2?
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that Camcorder arraylist size is 2?", 2, camcorderList.size());
	}
	@Test
	public void addChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
		// Item list is not null, so that can add a new item
				assertNotNull("Test if there is valid Camcorder arraylist to add to", chromebookList);
				
				//Given an empty list, after adding 1 item, the size of the list is 1
				ResourceCentre.addChromebook(chromebookList, cb1);		
				assertEquals("Test if that Chromebook arraylist size is 1?", 1, chromebookList.size());
				
				//The item just added is as same as the first item of the list
				assertSame("Test that Camcorder is added same as 1st item of the list?", cb1, chromebookList.get(0));
				
				//Add another item. test The size of the list is 2?
				ResourceCentre.addChromebook(chromebookList, cb2);
				assertEquals("Test that Chromebook arraylist size is 2?", 2, chromebookList.size());
	}
	
	@Test
	public void retrieveAllCamcorderTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty
				String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
				String testOutput = "";
				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
				
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre
		allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);

		testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void retrieveAllChromebookTest() {
		//fail("Not yet implemented");
		// write your code here
				
	}

	@Test
	  public  void doLoanCamcorderTest() {
	    //fail("Not yet implemented");
	    // write your code here
	    
	    boolean isfound=false;
	    for(int i =0;i<camcorderList.size();i++) {
	    if(camcorderList.get(i).getIsAvailable()==true ) {
	      isfound=true;
	      System.out.println("Test pass!");
	      
	    }else {
	      isfound=false;
	      System.out.println("test fail");
	    }
	    
	      
	    }
	      
	  }

	@Test

	public void doLoanChromebookTest() { //elaine 

		//fail("Not yet implemented");
		// write your code here

		boolean isfound=false;
		for(int i =0;i<chromebookList.size();i++) {
		    if(chromebookList.get(i).getIsAvailable() == true) {
		      isfound=true;
		      System.out.println("Test pass!");
		      
		    }else {
		      isfound=false;
		      System.out.println("test fail");
		    }
		    }
		      
		  }

	
	@Test
	public void doReturnCamcorderTest() {
		//fail("Not yet implemented");
		assertNotNull("Is the list of camcorders available?", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		
		//boundary
        assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
        ResourceCentre.addCamcorder(camcorderList, cc1);
        //error
        Boolean isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
        assertFalse("Test if available camcorder CC0011 is returned -false?", isReturned);       
		
      //normal
        ResourceCentre.addCamcorder(camcorderList, cc1);
        cc1.setIsAvailable(false);
        isReturned = ResourceCentre.doReturnCamcorder(camcorderList, "CC0011");
        assertTrue("Test if available camcorder CC0011 is returned -true", isReturned);

        // error
        isReturned =ResourceCentre.doReturnCamcorder(camcorderList, "CCO13");
        assertFalse("Test if non-exsisting amcorder CC013 is returned - false",isReturned);
	} 
	@Test
	public void doReturnChromebookTest() {
		//fail("Not yet implemented");
				//Let's load the list!!
				assertNotNull("Is the list of Chromebooks available?", chromebookList);
				ResourceCentre.addChromebook(chromebookList, cb1);
				ResourceCentre.addChromebook(chromebookList, cb2);
							
				//boundary
		        assertNotNull("Test if there is valid Chromebook arraylist to add to", chromebookList);
		        ResourceCentre.addChromebook(chromebookList, cb1);
		        //error
		        Boolean isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CC0011");
		        assertFalse("Test if available chromebook CC0011 is returned -false?", isReturned);       
		        
		        //normal
		        ResourceCentre.addChromebook(chromebookList, cb2);
		        cc2.setIsAvailable(false);
		        isReturned = ResourceCentre.doReturnChromebook(chromebookList, "CC0012");
		        assertTrue("Test if available chromebook CC0011 is returned -true", isReturned);       
	
		        // error
		        ResourceCentre.doReturnChromebook(chromebookList, "CCO13");
		        assertFalse("Test if non-exsisting chromebook CC013 is returned - false",isReturned);
			} 
		        
	}
	
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;

	}
	
	
}
