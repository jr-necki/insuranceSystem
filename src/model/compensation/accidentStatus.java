package model.compensation;

enum relevantCase {}

public class accidentStatus {
	private String accidentData;
	private String accidentReport;
	private String evidenceData;
	private relevantCase relevantCase;
	public damageSet m_damageSet;
	public damageInvestigation m_damageInvestigation;

	public accidentStatus(){

	}

	public String getAccidentData() {
		return accidentData;
	}


	public void setAccidentData(String accidentData) {
		this.accidentData = accidentData;
	}


	public String getAccidentReport() {
		return accidentReport;
	}


	public void setAccidentReport(String accidentReport) {
		this.accidentReport = accidentReport;
	}


	public String getEvidenceData() {
		return evidenceData;
	}


	public void setEvidenceData(String evidenceData) {
		this.evidenceData = evidenceData;
	}


	public relevantCase getRelevantCase() {
		return relevantCase;
	}


	public void setRelevantCase(relevantCase relevantCase) {
		this.relevantCase = relevantCase;
	}


	public damageSet getM_damageSet() {
		return m_damageSet;
	}


	public void setM_damageSet(damageSet m_damageSet) {
		this.m_damageSet = m_damageSet;
	}


	public damageInvestigation getM_damageInvestigation() {
		return m_damageInvestigation;
	}


	public void setM_damageInvestigation(damageInvestigation m_damageInvestigation) {
		this.m_damageInvestigation = m_damageInvestigation;
	}

}