// [27070179_1]_[40081513_2]_A1
package coen352.ch4.dictionary;



public class InventoryRecord implements Comparable<InventoryRecord>, ADTInventoryRecord{
	private String	ID; 
	private String name;
	private String	description;
	private double unitPrice;
	private long	qtyInStock;
	private double  inventoryValue;
	private int reorderLevel;
	private int reorderTime;
	private int reorderQty;
	private String discontinued;
	
	
	
	InventoryRecord(String id, String nm, String des, double up, long qs, double iv, int rl, int rt, int rq, String dis)
	{

		ID = id;
		name = nm;
		description = des;
		unitPrice = up;
		qtyInStock = qs;
		inventoryValue = iv;
		reorderLevel = rl;
		reorderTime = rt;
		reorderQty = rq;
		discontinued = dis;
	}
	InventoryRecord()
	{

		ID = "";
		name = "";
		description = "";
		unitPrice = 0;
		qtyInStock = 0;
		inventoryValue =0;
		reorderLevel = 0;
		reorderTime = 0;
		reorderQty = 0;
		discontinued = "";
	}
	
	// Getter and setter
	public String getID() {return ID;}
	public String getName() {return name;}
	public String getDescription() {return description;}
	public double getUnitPrice() {return unitPrice;}
	public long getQtyInStock() {return qtyInStock;}
	public double getInventoryValue() {return inventoryValue;}
	public int getReorderLevel() {return reorderLevel;}
	public int getReorderTime() {return reorderTime;}
	public int getReorderQty() {return reorderQty;}
	public String getDiscontinuity() {return discontinued;}
	
	public void setID(String id) {ID = id;}
	public void setName(String nm) {name = nm;}
	public void setDescription(String des) { description = des;}
	public void setUnitPrice(double up) {unitPrice = up;}
	public void setQtyInStock(int qs) {qtyInStock = qs;}
	public void setInventoryValue(double iv) {inventoryValue = iv;}
	public void setReorderLevel(int rl) {reorderLevel = rl;}
	public void setReorderTime(int rt) {reorderTime = rt;}
	public void setReorderQty(int rq) {reorderQty = rq;}
	public void setDiscontinuity(String dis) {discontinued = dis;}
	
	@Override
	public int compareTo(InventoryRecord o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
