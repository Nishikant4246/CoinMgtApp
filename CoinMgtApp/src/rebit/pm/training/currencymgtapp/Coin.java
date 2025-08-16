package rebit.pm.training.currencymgtapp;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Coin {
	private Integer id;
	private String country;
	private String denomination;
	private Integer yearOfMinting;
	private Integer currentValue;
	private String currency;
	private Date acquiredDate;

	public Coin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coin(String country, String denomination, Integer yearOfMinting, Integer currentValue, String currency,
			Date acquiredDate) {
		super();

		this.country = country;
		this.denomination = denomination;
		this.yearOfMinting = yearOfMinting;
		this.currentValue = currentValue;
		this.currency = currency;
		this.acquiredDate = acquiredDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public Integer getYearOfMinting() {
		return yearOfMinting;
	}

	public void setYearOfMinting(Integer yearOfMinting) {
		this.yearOfMinting = yearOfMinting;
	}

	public Integer getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Integer currentValue) {
		this.currentValue = currentValue;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getAcquiredDate() {
		return acquiredDate;
	}

	public void setAcquiredDate(Date acquiredDate) {
		this.acquiredDate = acquiredDate;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(acquiredDate, country, currency, currentValue, denomination, id, yearOfMinting);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coin other = (Coin) obj;
		return Objects.equals(acquiredDate, other.acquiredDate) && Objects.equals(country, other.country)
				&& Objects.equals(currency, other.currency) && Objects.equals(currentValue, other.currentValue)
				&& Objects.equals(denomination, other.denomination) && Objects.equals(id, other.id)
				&& Objects.equals(yearOfMinting, other.yearOfMinting);
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String acquiredDateStr = dateFormat.format(acquiredDate);

		return String.format(
				//"Country: %-15s| Denomination: %-10s| Year of Minting: %-5d| Current Value: %-10d|Currency: %-15s| Acquired Date: %5s|",
				"Country: %-15s| Denomination: %-10s| Year of Minting: %-5s| Current Value: %-6s| Currency: %-15s| Acquired Date: %5s|",
				country, denomination, yearOfMinting, currentValue, currency, acquiredDateStr);
	}

}