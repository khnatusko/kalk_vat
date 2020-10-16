package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class KalkBB {
	private String brutto;
	private String netto;
	private String vat;
	private Double resultbrutto;
	private Double resultnetto;

	@Inject
	FacesContext ctx;

	

	public String getBrutto() {
		return brutto;
	}

	public void setBrutto(String brutto) {
		this.brutto = brutto;
	}

	public String getNetto() {
		return netto;
	}

	public void setNetto(String netto) {
		this.netto = netto;
	}

	public String getVat() {
		return vat;
	}

	public void setVat(String vat) {
		this.vat = vat;
	}

	public Double getResultbrutto() {
		return resultbrutto;
	}

	public void setResultbrutto(Double resultbrutto) {
		this.resultbrutto = resultbrutto;
	}

	public Double getResultnetto() {
		return resultnetto;
	}

	public void setResultnetto(Double resultnetto) {
		this.resultnetto = resultnetto;
	}

	public boolean doTheMath() {
		try {
			double brutto = Double.parseDouble(this.brutto);
			double netto = Double.parseDouble(this.netto);
			double vat = Double.parseDouble(this.vat);
			
			resultbrutto = brutto / (1 + vat);
			resultnetto = netto + (netto* vat);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "B³¹d podczas przetwarzania parametrów", null));
			return false;
		}
	}

	
	public String kalk() {
		if (doTheMath()) {
			return "showresult";
		}
		return null;
	}


	public String info() {
		return "info";
	}
}
