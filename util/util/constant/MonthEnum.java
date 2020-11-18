package util.constant;



public enum  MonthEnum {

	JANUARY		(1,"January"),
	FEBRUARY	(2,"February"),
	MARCH		(3,"March"),
	APRIL		(4,"April"),
	MAY			(5,"May"),
	JUNE		(6,"June"),
	JULY		(7,"July"),
	AUGUST		(8,"August"),
	SEPTEMBER	(9,"September"),
	OCTOBER		(10,"October"),
	NOVEMBER 	(11,"November"),
	DECEMBER 	(12,"December");
	
    private final Integer code;
    private final String name;
    
    
    private MonthEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

	public Integer getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
}

