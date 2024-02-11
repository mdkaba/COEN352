//[27070179_1]_[40081513_2]_A1
package coen352.ch4.dictionary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class DictionaryJUnitTest {
	
	
	private static ADTDictionary<Integer, String> dict;
	private static DoubleLinkedListDictionary<Integer, String> Dict_Double;
	private static LinkedLDictionary<Integer, String> Dict_Singly;
	private static WarehouseDB WarehouseDict;
	public static InventoryRecord temp;
	  
	@BeforeAll
	public static void setUp() {
		dict = new LDictionary<Integer, String>(10);
		Dict_Singly = new LinkedLDictionary<Integer, String>();
		Dict_Double = new DoubleLinkedListDictionary<Integer, String>();
		WarehouseDict = new WarehouseDB();
		temp = new InventoryRecord();
		
	}

	
	
	@Test
	void testClear() {
		dict.clear();
		assertEquals(0, dict.size(), "clear failed, size is non zero");
	}
	
	
	@Test
	void testInsert() {
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		assertEquals(4, dict.size(), "insert failed, size is not as expected");
	}
	
	@Test
	void testRemove() {
		
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		dict.remove(0);
		
		assertEquals("1:blue , 2:yellow , 3:grey ,", dict.toString());
		
		assertEquals("grey", dict.find(3), "remove failed"); 
		
	}
	
	@Test
	void testRemoveAny() {
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		assertNotEquals("grey", dict.removeAny(), "removeAny failed"); 
		
		
	}
	
	@Test
	void testFind() {
		
		dict.clear();
		dict.insert(0, "red");
		dict.insert(1, "blue");
		dict.insert(2,"yellow");
		dict.insert(3, "grey");
		
		assertNull(dict.find(5));
		
		assertEquals("grey", dict.find(3), "find failed"); 
	}
	
	@Test
	void testSize() {
		dict.clear();
		dict.insert(0, "red");
	
		
		assertEquals(1, dict.size(), "size failed, size is not as expected");
	}

	
	@Test
	void SinglyListDictionaryTestClear() 
	 {
		 Dict_Singly.clear();
		assertEquals(0, Dict_Singly.size(), "clear failed, size is non zero");
	}


	@Test
	void SinglyListDictionaryTestInsert() 
	{
		Dict_Singly.clear();
		Dict_Singly.insert(0, "red");
		Dict_Singly.insert(1, "blue");
		Dict_Singly.insert(2,"yellow");
		Dict_Singly.insert(3, "grey");
		assertEquals(4, Dict_Singly.size(), "insert failed, size is not as expected");
	}
	
	@Test
	void SinglyListDictionaryTestRemove() 
	{
		
		Dict_Singly.clear();
		Dict_Singly.insert(0, "red");
		Dict_Singly.insert(1, "blue");
		Dict_Singly.insert(2,"yellow");
		Dict_Singly.insert(3, "grey");
		Dict_Singly.remove(0);
		assertEquals("grey", Dict_Singly.find(3), "remove failed"); 
		
	}
	
	@Test
	void SinglyListDictionaryTestRemoveAny() 
	{
		Dict_Singly.clear();
		Dict_Singly.insert(0, "red");
		Dict_Singly.insert(1, "blue");
		Dict_Singly.insert(2,"yellow");
		Dict_Singly.insert(3, "grey");
		assertNotEquals("grey", Dict_Singly.removeAny(), "removeAny failed"); 
		
	}
	
	@Test
	void SinglyListDictionaryTestFind() 
	{
		Dict_Singly.clear();
		Dict_Singly.insert(0, "red");
		Dict_Singly.insert(1, "blue");
		Dict_Singly.insert(2,"yellow");
		Dict_Singly.insert(3, "grey");	
		assertEquals("yellow", Dict_Singly.find(2), "find failed"); 
	}

	@Test
	void SinglyListDictionaryTestSize() 
	 {
		 Dict_Singly.clear();
		 Dict_Singly.insert(0, "red");
		 Dict_Singly.insert(1, "blue");
		 Dict_Singly.insert(2,"yellow");
		 Dict_Singly.insert(3, "grey");	
		assertEquals(4, Dict_Singly.size(), "size failed, size is not as expected");
	}
	

    @Test
    void SinglyListDictionarytestToString() 
    {
    	 Dict_Singly.clear();
    	 Dict_Singly.insert(0, "red");
         Dict_Singly.insert(1, "blue");
         Dict_Singly.insert(2, "yellow");
         Dict_Singly.insert(3, "grey");
        String expected = "0:red , 1:blue , 2:yellow , 3:grey";
        String actual = Dict_Singly.toString();
        assertEquals(expected, actual, "toString method failed");
    }
    
	@Test
	void DoubleListDictionaryTestClear() 
	 {
		Dict_Double.clear();
		assertEquals(0, Dict_Double.size(), "clear failed, size is non zero");
	}


	@Test
	void DoubleListDictionaryTestInsert() 
	{
		Dict_Double.clear();
		Dict_Double.insert(0, "red");
		Dict_Double.insert(1, "blue");
		Dict_Double.insert(2,"yellow");
		Dict_Double.insert(3, "grey");
		assertEquals(4, Dict_Double.size(), "insert failed, size is not as expected");
	}


	@Test
	void DoubleListDictionaryTestRemove() 
	{
		
		Dict_Double.clear();
		Dict_Double.insert(0, "red");
		Dict_Double.insert(1, "blue");
		Dict_Double.insert(2,"yellow");
		Dict_Double.insert(3, "grey");
		Dict_Double.remove(0);
		assertEquals("grey", Dict_Double.find(3), "remove failed"); 
		
	}
	
	
	@Test
	void DoubleListDictionaryTestRemoveAny() 
	{
		Dict_Double.clear();
		Dict_Double.insert(0, "red");
		Dict_Double.insert(1, "blue");
		Dict_Double.insert(2,"yellow");
		Dict_Double.insert(3, "grey");
		assertEquals("grey", Dict_Double.removeAny(), "removeAny failed"); 
		
	}


	@Test
	void DoubleListDictionaryTestFind() 
	{
		Dict_Double.clear();
		Dict_Double.insert(0, "red");
		Dict_Double.insert(1, "blue");
		Dict_Double.insert(2,"yellow");
		Dict_Double.insert(3, "grey");	
		assertEquals("yellow", Dict_Double.find(2), "find failed"); 
	}

	@Test
	void DoubleListDictionaryTestSize() 
	 {
		Dict_Double.clear();
		Dict_Double.insert(0, "red");
		Dict_Double.insert(1, "blue");
		Dict_Double.insert(2,"yellow");
		Dict_Double.insert(3, "grey");	
		assertEquals(4, Dict_Double.size(), "size failed, size is not as expected");
	}
	
	@Test
	void DoubleListDictionaryTestToString() {
		
	    Dict_Double.clear();
	    Dict_Double.insert(0, "red");
	    Dict_Double.insert(1, "blue");
	    Dict_Double.insert(2, "yellow");
	    Dict_Double.insert(3, "grey");
	    String expected = "0:red , 1:blue , 2:yellow , 3:grey";
	    String actual = Dict_Double.toString();
	    assertEquals(expected, actual, "toString method failed");
	}
	
	@Test
	void WarehouseInventoryTestInsert() 
	{
		WarehouseDict.clear();
		InventoryRecord R1=new InventoryRecord("IN0001"	,"Item 1","Desc 1",51.00 ,25,1275.00,29,13,50,"null");
		InventoryRecord R2=new InventoryRecord("IN0002"	,"Item 2","Desc 2",93.00 ,132,12276,231,4,50,"null");
		InventoryRecord R3=new InventoryRecord("IN0003"	,"Item 3","Desc 3",57.00 ,151,8607.00,114,11,150,"null");
		InventoryRecord R4=new InventoryRecord("IN0004"	,"Item 4","Desc 4",19.00 ,186,3534.00,158,6,50,"null");
		InventoryRecord R5=new InventoryRecord("IN0005"	,"Item 5","Desc 5",75.00 ,62,4650.00,39,12,50,"null");
		InventoryRecord R6=new InventoryRecord("IN0006"	,"Item 6","Desc 6",11.00 ,5,55.00,29,13,150,"null");
		WarehouseDict.insert(R1.getID(), R1);
		WarehouseDict.insert(R2.getID(), R2);
		WarehouseDict.insert(R3.getID(), R3);
		WarehouseDict.insert(R4.getID(), R4);
		WarehouseDict.insert(R5.getID(), R5);
		WarehouseDict.insert(R6.getID(), R6);
		assertEquals(6, WarehouseDict.size(), "insert failed, size is not as expected");
		
	}
	
	@Test
	void WarehouseInventoryTestInsertRecords() {

	    WarehouseDict.clear();
	    InventoryRecord[] recordsToInsert = {
	        new InventoryRecord("IN0001", "Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, "null"),
	        new InventoryRecord("IN0002", "Item 2", "Desc 2", 93.00, 132, 12276, 231, 4, 50, "null"),
	        new InventoryRecord("IN0003", "Item 3", "Desc 3", 57.00, 151, 8607.00, 114, 11, 150, "null")};
	    WarehouseDict.insertRecords(recordsToInsert);

	    assertEquals(recordsToInsert.length, WarehouseDict.getRecordCount(), "insertRecords failed");
	}
	
	@Test
	void WarehouseInventoryTestRemoveAll() 
	 {
		WarehouseDict.removeAll();
		assertEquals(0, WarehouseDict.size(), "clear failed, size is non zero");
	}
	
	@Test
	void WarehouseInventoryTestRemoveRecord() {
	    
	    WarehouseDict.clear();
	    InventoryRecord R1 = new InventoryRecord("IN0001", "Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, "null");
	    InventoryRecord R2 = new InventoryRecord("IN0002", "Item 2", "Desc 2", 93.00, 132, 12276, 231, 4, 50, "null");
	    InventoryRecord R3 = new InventoryRecord("IN0003", "Item 3", "Desc 3", 57.00, 151, 8607.00, 114, 11, 150, "null");
	    WarehouseDict.insert(R1.getID(), R1);
	    WarehouseDict.insert(R2.getID(), R2);
	    WarehouseDict.insert(R3.getID(), R3);
	    WarehouseDict.removeRecord("IN0002");
	    assertNull(WarehouseDict.findRecord("IN0002"), "RemoveRecord failed");
	}
	
	@Test
	void WarehouseInventoryTestFindRecord() {
	
	    WarehouseDict.clear();
	    InventoryRecord R1 = new InventoryRecord("IN0001", "Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, "null");
	    InventoryRecord R2 = new InventoryRecord("IN0002", "Item 2", "Desc 2", 93.00, 132, 12276, 231, 4, 50, "null");
	    InventoryRecord R3 = new InventoryRecord("IN0003", "Item 3", "Desc 3", 57.00, 151, 8607.00, 114, 11, 150, "null");
	    WarehouseDict.insert(R1.getID(), R1);
	    WarehouseDict.insert(R2.getID(), R2);
	    WarehouseDict.insert(R3.getID(), R3);
	    InventoryRecord foundRecord = WarehouseDict.findRecord("IN0002");
	    assertEquals(R2, foundRecord, "findRecord failed");
	}
	
	@Test
	void WarehouseInventoryTestGetReorderedRecords() {

	    WarehouseDict.clear();
	    InventoryRecord R1 = new InventoryRecord("IN0001", "Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, "null");
	    InventoryRecord R2 = new InventoryRecord("IN0002", "Item 2", "Desc 2", 93.00, 132, 12276, 231, 4, 50, "Reordered");
	    InventoryRecord R3 = new InventoryRecord("IN0003", "Item 3", "Desc 3", 57.00, 151, 8607.00, 114, 11, 150, "Reordered");
	    InventoryRecord R4 = new InventoryRecord("IN0004", "Item 4", "Desc 4", 19.00, 186, 3534.00, 158, 6, 50, "null");
	    WarehouseDict.insert(R1.getID(), R1);
	    WarehouseDict.insert(R2.getID(), R2);
	    WarehouseDict.insert(R3.getID(), R3);
	    WarehouseDict.insert(R4.getID(), R4);
	    LinkedLDictionary<String, InventoryRecord> reorderedRecords = WarehouseDict.getReorderedRecords();
	    assertEquals(2, reorderedRecords.size(), "getReorderedRecords failed");
	}
	
	@Test
	void WarehouseInventoryTestGetRecordsByLocation() {
		
	    WarehouseDict.clear();
	    InventoryRecord R1 = new InventoryRecord("IN0001", "Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, "null");
	    InventoryRecord R2 = new InventoryRecord("IN0002", "Item 2", "Desc 2", 93.00, 132, 12276, 231, 4, 50, "null");
	    InventoryRecord R3 = new InventoryRecord("IN0003", "Item 3", "Desc 3", 57.00, 151, 8607.00, 114, 11, 150, "null");
	    WarehouseDict.insert(R1.getID(), R1);
	    WarehouseDict.insert(R2.getID(), R2);
	    WarehouseDict.insert(R3.getID(), R3);
	    LinkedLDictionary<String, InventoryRecord> recordsByLocation = WarehouseDict.getRecordsByLocation(1, 2);
	    assertEquals(2, recordsByLocation.size(), "getRecordsByLocation failed");
	}
	
	
	@Test
	void WarehouseInventoryTestGetRecordCount() {
		
	    WarehouseDict.clear();
	    InventoryRecord R1 = new InventoryRecord("IN0001", "Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, "null");
	    InventoryRecord R2 = new InventoryRecord("IN0002", "Item 2", "Desc 2", 93.00, 132, 12276, 231, 4, 50, "null");
	    InventoryRecord R3 = new InventoryRecord("IN0003", "Item 3", "Desc 3", 57.00, 151, 8607.00, 114, 11, 150, "null");
	    WarehouseDict.insert(R1.getID(), R1);
	    WarehouseDict.insert(R2.getID(), R2);
	    WarehouseDict.insert(R3.getID(), R3);
	    int recordCount = WarehouseDict.getRecordCount();
	    assertEquals(3, recordCount, "getRecordCount failed");
	}
	
	@Test
	void WarehouseInventoryTestGetTotalInventoryValue() {
		
	    WarehouseDict.clear();
	    InventoryRecord R1 = new InventoryRecord("IN0001", "Item 1", "Desc 1", 51.00, 25, 1275.00, 29, 13, 50, "null");
	    InventoryRecord R2 = new InventoryRecord("IN0002", "Item 2", "Desc 2", 93.00, 132, 12276, 231, 4, 50, "null");
	    InventoryRecord R3 = new InventoryRecord("IN0003", "Item 3", "Desc 3", 57.00, 151, 8607.00, 114, 11, 150, "null");
	    WarehouseDict.insert(R1.getID(), R1);
	    WarehouseDict.insert(R2.getID(), R2);
	    WarehouseDict.insert(R3.getID(), R3);
	    double totalInventoryValue = WarehouseDict.getTotalInventoryValue();
	    assertEquals(22158.0, totalInventoryValue, 0.01, "getTotalInventoryValue failed");
	}

	
	

}
