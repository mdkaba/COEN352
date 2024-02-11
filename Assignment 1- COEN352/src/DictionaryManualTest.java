//[27070179_1]_[40081513_2]_A1
package coen352.ch4.dictionary;



public class DictionaryManualTest {

		public static void main(String[] args) {
		   
			DictionaryManualTest.runManualTest();
		   
	   }
	   
	   public static void runManualTest() {
		   DictionaryJUnitTest t = new DictionaryJUnitTest();
		   DictionaryJUnitTest.setUp();
		   t.testClear();
		   t.testFind();
		   t.testInsert();
		   t.testRemove();
		   t.testRemoveAny();
		   t.testSize();
		   t.DoubleListDictionaryTestClear();
		   t.DoubleListDictionaryTestFind();
		   t.DoubleListDictionaryTestInsert();
		   t.DoubleListDictionaryTestRemove();
		   t.DoubleListDictionaryTestRemoveAny();
		   t.DoubleListDictionaryTestSize();
		   t.DoubleListDictionaryTestToString();
		   
		   t.SinglyListDictionaryTestClear();
		   t.SinglyListDictionaryTestFind();
		   t.SinglyListDictionaryTestInsert();
		   t.SinglyListDictionaryTestRemove();
		   t.SinglyListDictionaryTestRemoveAny();
		   t.SinglyListDictionaryTestSize();
		   t.SinglyListDictionarytestToString();
		   
		   t.WarehouseInventoryTestFindRecord();
		   t.WarehouseInventoryTestGetRecordCount();
		   t.WarehouseInventoryTestInsert();
		   t.WarehouseInventoryTestGetReorderedRecords();
		   t.WarehouseInventoryTestGetRecordsByLocation();
		   t.WarehouseInventoryTestRemoveRecord();
		   t.WarehouseInventoryTestRemoveAll();
		   t.WarehouseInventoryTestGetTotalInventoryValue();
		   t.WarehouseInventoryTestInsertRecords();
	   }
	   
	
}