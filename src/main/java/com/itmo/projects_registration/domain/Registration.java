package com.itmo.projects_registration.domain;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Registration {

	public Registration() {}

	public Registration(String registrationId, Manager creator, Manager responsibleManager,
			double validityTime, Place place, Company client, List<Invoice> invoices,
			boolean registrationState) {
		super();
		this.registrationId = registrationId;
		this.creationDate = new GregorianCalendar().getTime();
		this.creator = creator;
		this.responsibleManager = responsibleManager;
		this.validityTime = validityTime;
		this.prolongationTime = new GregorianCalendar().getTime();
		this.place = place;
		this.client = client;
		this.invoices = invoices;
		this.registrationState = registrationState;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String registrationId;
	
	private Date creationDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="creator", referencedColumnName= "managerId")
	private Manager creator;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="responsibleManager", referencedColumnName= "managerId")
	private Manager responsibleManager;
	
	private double validityTime;
	private Date prolongationTime;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="place", referencedColumnName= "placeId")
	private Place place;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client", referencedColumnName= "companyId")
	private Company client;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="registration")
	private List<Invoice> invoices;
	
	private boolean registrationState;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Manager getCreator() {
		return creator;
	}

	public void setCreator(Manager creator) {
		this.creator = creator;
	}

	public Manager getResponsibleManager() {
		return responsibleManager;
	}

	public void setResponsibleManager(Manager responsibleManager) {
		this.responsibleManager = responsibleManager;
	}

	public double getValidityTime() {
		return validityTime;
	}

	public void setValidityTime(double validityTime) {
		this.validityTime = validityTime;
	}

	public Date getProlongationTime() {
		return prolongationTime;
	}

	public void setProlongationTime(Date prolongationTime) {
		this.prolongationTime = prolongationTime;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Company getClient() {
		return client;
	}

	public void setClient(Company client) {
		this.client = client;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public boolean isRegistrationState() {
		return registrationState;
	}

	public void setRegistrationState(boolean registrationState) {
		this.registrationState = registrationState;
	}

}
