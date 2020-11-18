package util.constant;



public enum  CurrencyEnum {

	USD	("$", "AMERICAN DOLAR", "US"),
	EUR	("€", "EURO", "UE"),
	CNY	("€", "YUAN", "CN"),
	PEN	("S/",	"NUEVO SOL", "PE");
	
    private final String simbol;
    private final String name;
    private final String country;
    
    
    private CurrencyEnum(String simbol, String name, String country){
        this.simbol = simbol;
        this.name = name;
        this.country = country;
    }

	public String getSimbol() {
		return simbol;
	}
	public String getName() {
		return name;
	}
	public String getCountry() {
		return country;
	}
    
    
}

