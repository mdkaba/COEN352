// [27070179_1]_[40081513_2]_A1
package coen352.ch4.dictionary;

public class WarehouseDB extends LinkedLDictionary<String, InventoryRecord>{
	
	static WarehouseDB wDB;
	private static ADTDictionary<String, InventoryRecord> sheetIR;
	
	public static void main(String[] args) {
		
		wDB = new WarehouseDB();
		// TODO Auto-generated method stub
		wDB.creatDB();
		
	}
	
	InventoryRecord R1=new InventoryRecord("IN0001"	,"Item 1","Desc 1",51.00 ,25,1275.00,29,13,50,"null");
	InventoryRecord R2=new InventoryRecord("IN0002"	,"Item 2","Desc 2",93.00 ,132,12276,231,4,50,"null");
	InventoryRecord R3=new InventoryRecord("IN0003"	,"Item 3","Desc 3",57.00 ,151,8607.00,114,11,150,"null");
	InventoryRecord R4=new InventoryRecord("IN0004"	,"Item 4","Desc 4",19.00 ,186,3534.00,158,6,50,"null");
	InventoryRecord R5=new InventoryRecord("IN0005"	,"Item 5","Desc 5",75.00 ,62,4650.00,39,12,50,"null");
	InventoryRecord R6=new InventoryRecord("IN0006"	,"Item 6","Desc 6",11.00 ,5,55.00,29,13,150,"null");	
	InventoryRecord R7=new InventoryRecord("IN0007"	,"Item 7","Desc 7",56.00 ,58,3248.00,109,7,100,"yes");
	InventoryRecord R8=new InventoryRecord("IN0008"	,"Item 8","Desc 8",38.00 ,101,3838.00,162,3,100,"null");
	InventoryRecord R9=new InventoryRecord("IN0009"	,"Item 9","Desc 9",59.00 ,122,7198.00,82,3,150,"null");
	InventoryRecord R10=new InventoryRecord("IN0010","Item 10","Desc 10",50.00 ,175,8750.00,283,8,150,"null");
	InventoryRecord R11=new InventoryRecord("IN0011","Item 11","Desc 11",59.00 ,176,10384.00,229,1,100,"null");
	InventoryRecord R12=new InventoryRecord("IN0012","Item 12","Desc 12",18.00 ,22,396.00,36,12,50,"null");
	InventoryRecord R13=new InventoryRecord("IN0013","Item 13","Desc 13",26.00 ,72,1872.00,102,9,100,"null");
	InventoryRecord R14=new InventoryRecord("IN0014","Item 14","Desc 14",42.00 ,62,2604.00,83,2,100,"null");
	InventoryRecord R15=new InventoryRecord("IN0015","Item 15","Desc 15",32.00 ,46,1472.00,23,15,50,"null");
	InventoryRecord R16=new InventoryRecord("IN0016","Item 16","Desc 16",90.00 ,96,8640.00,180,3,50,"null");
	InventoryRecord R17=new InventoryRecord("IN0017","Item 17","Desc 17",97.00 ,57,5529.00,98,12,150,"yes");
	InventoryRecord R18=new InventoryRecord("IN0018","Item 18","Desc 18",12.00 ,6,72.00,7,13,50,"null");
	InventoryRecord R19=new InventoryRecord("IN0019","Item 19","Desc 19",82.00 ,143,11726.00,164,12,50,"null");
	InventoryRecord R20=new InventoryRecord("IN0020","Item 20","Desc 20",16.00 ,124,1984.00,113,14,50,"null");
	InventoryRecord R21=new InventoryRecord("IN0021","Item 21","Desc 21",19.00 ,112,2128.00,75,11,50,"null");
	InventoryRecord R22=new InventoryRecord("IN0022","Item 22","Desc 22",24.00 ,182,4368.00,132,15,150,"null");
	InventoryRecord R23=new InventoryRecord("IN0023","Item 23","Desc 23",29.00 ,106,3074.00,142,1,150,"yes");
	InventoryRecord R24=new InventoryRecord("IN0024","Item 24","Desc 24",75.00 ,173,12975.00,127,9,100,"null");
	InventoryRecord R25=new InventoryRecord("IN0025","Item 25","Desc 25",14.00 ,28,392.00,21,8,50,"null");
	
	public static void initial() {
		wDB.insert(new InventoryRecord());
	
	}

	public String toString() {
		return sheetIR.toString();
	}
	
	public  void creatDB() {
		sheetIR = new  LDictionary<String, InventoryRecord>(); 
	}
	
	public  boolean insert(ADTInventoryRecord o) {
		if(o instanceof InventoryRecord) {
			sheetIR.insert(((InventoryRecord)o).getID(), (InventoryRecord) o);
			return true;
		}
		return false;
	}
	
	// Method to insert a set of records into the database
	public void insertRecords(InventoryRecord[] records) {
	    for (InventoryRecord record : records) {
	        insert(record.getID(), record);
	    }
	}
	
	// Method to remove a record by key (ID)
    public void removeRecord(String key) {
        remove(key); 
    }
    
 // Method to remove all records and clear the database
    public void removeAll() {
        clear(); 
    }

 // Method to find a record by key (ID)
    public InventoryRecord findRecord(String key) {
        return find(key); 
    }
    
    public LinkedLDictionary<String, InventoryRecord> getReorderedRecords() {
        LinkedLDictionary<String, InventoryRecord> reorderedRecords = new LinkedLDictionary<>();

        // Iterate through the linked list
        Node<String, InventoryRecord> current = head;
        while (current != null) {
            InventoryRecord record = current.value;
            if ("Reordered".equals(record.getDiscontinuity())) {
                reorderedRecords.insert(record.getID(), record);
            }
            current = current.next;
        }

        return reorderedRecords;
    }
    
 // Method to retrieve records by location using the linked list
    public LinkedLDictionary<String, InventoryRecord> getRecordsByLocation(int start, int end) {
        LinkedLDictionary<String, InventoryRecord> recordsByLocation = new LinkedLDictionary<>();

        // Check if the start and end points are valid
        if (start < 0 || end < 0 || start > end) {
            return recordsByLocation; // Return an empty dictionary for invalid inputs
        }

        int currentIndex = 0;
        Node<String, InventoryRecord> current = head;

        // Iterate through the linked list
        while (current != null) {
            if (currentIndex >= start && currentIndex <= end) {
                recordsByLocation.insert(current.key, current.value);
            }
            current = current.next;
            currentIndex++;
        }

        return recordsByLocation;
    }
    
 // Method to return the number of records in the database
    public int getRecordCount() {
        int count = 0;
        Node<String, InventoryRecord> current = head;

        // Iterate through the linked list and count the records
        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
 // Method to return the total inventory value of all records
    public double getTotalInventoryValue() {
        double totalValue = 0.0;
        Node<String, InventoryRecord> current = head;

        // Iterate through the linked list and sum up the inventory values
        while (current != null) {
            totalValue += current.value.getInventoryValue();
            current = current.next;
        }

        return totalValue;
    }
    
}
