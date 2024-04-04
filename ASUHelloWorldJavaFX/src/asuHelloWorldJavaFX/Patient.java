package asuHelloWorldJavaFX;

public class Patient {
	    private int id;
	 private String patientctscan;
	    private int totalCAC;
	    private int lmValue;
	    private int ladValue;
	    private int lcxValue;
	    private int rdaValue;
	    private int pdaValue;

	    public Patient() {
	        // Default constructor
	    	this.id = 0;
	    	this.patientctscan = "";
	        this.totalCAC = 0;
	        this.lmValue = 0;
	        this.ladValue = 0;
	        this.lcxValue = 0;
	        this.rdaValue = 0;
	        this.pdaValue = 0;
	    }

	    public Patient(int id, String patientctscan, int totalCAC, int lmValue, int ladValue, int lcxValue, int rdaValue, int pdaValue) {
	       
	    	this.patientctscan = patientctscan;
	        this.totalCAC = totalCAC;
	        this.lmValue = lmValue;
	        this.ladValue = ladValue;
	        this.lcxValue = lcxValue;
	        this.rdaValue = rdaValue;
	        this.pdaValue = pdaValue;
	    }

	    // Getters and setters
	    
	    public int getID() {
	        return id;
	    }

	    public void setID(int id) {
	        this.id = id;
	    }

	    public String getpatientName() {
	        return patientctscan;
	    }

	    public void setpatientName(String patientctscan) {
	        this.patientctscan = patientctscan;
	    }
	    

	    public int getTotalCAC() {
	        return totalCAC;
	    }

	    public void setTotalCAC(int totalCAC) {
	        this.totalCAC = totalCAC;
	    }

	    public int getLmValue() {
	        return lmValue;
	    }

	    public void setLmValue(int lmValue) {
	        this.lmValue = lmValue;
	    }

	    public int getLadValue() {
	        return ladValue;
	    }

	    public void setLadValue(int ladValue) {
	        this.ladValue = ladValue;
	    }

	    public int getLcxValue() {
	        return lcxValue;
	    }

	    public void setLcxValue(int lcxValue) {
	        this.lcxValue = lcxValue;
	    }

	    public int getRdaValue() {
	        return rdaValue;
	    }

	    public void setRdaValue(int rdaValue) {
	        this.rdaValue = rdaValue;
	    }

	    public int getPdaValue() {
	        return pdaValue;
	    }

	    public void setPdaValue(int pdaValue) {
	        this.pdaValue = pdaValue;
	    }
   

}