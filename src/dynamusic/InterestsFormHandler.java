package dynamusic;

import java.io.IOException;

import javax.servlet.ServletException;

import atg.droplet.GenericFormHandler;
import atg.repository.MutableRepository;
import atg.repository.MutableRepositoryItem;
import atg.repository.Repository;
import atg.repository.RepositoryException;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.userprofiling.Profile;

public class InterestsFormHandler extends GenericFormHandler {
	
	private String interestName;
	private String interestRating;
	private String interestId;
	private Repository repository;
	private Profile profile; 
	
	private String successURL;
	private String errorURL;
	
	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}
	public String getInterestName() {
		return interestName;
	}
	public void setInterestRating(String interestRating) {
		this.interestRating = interestRating;
	}
	public String getInterestRating() {
		return interestRating;
	}
	
	public void setInterestId(String interestId) {
		this.interestId = interestId;
	}
	public String getInterestId() {
		return interestId;
	}
	
	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	public Repository getRepository() {
		return repository;
	}
	
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Profile getProfile() {
		return profile;
	}
	
	public void setSuccessURL(String successURL) {
		this.successURL = successURL;
	}
	public String getSuccessURL() {
		return successURL;
	}
	public void setErrorURL(String errorURL) {
		this.errorURL = errorURL;
	}
	public String getErrorURL() {
		return errorURL;
	}
	
	public boolean handleAdd(DynamoHttpServletRequest request,
			DynamoHttpServletResponse response) throws IOException, ServletException {
			MutableRepository mutableRepository = (MutableRepository) repository; 
			try {
				MutableRepositoryItem interest = mutableRepository.createItem("interest");
				interest.setPropertyValue("name", interestName);
				interest.setPropertyValue("rating", interestRating);
				interest.setPropertyValue("user", profile.getDataSource());
				mutableRepository.addItem(interest);
			} catch (RepositoryException e) {
				logDebug("problem with adding interest");
			}
			return checkFormRedirect(getSuccessURL(), null, request, response);
	}
	
	public boolean handleEdit(DynamoHttpServletRequest request,
			DynamoHttpServletResponse response) throws IOException, ServletException {
		MutableRepository mutableRepository = (MutableRepository) repository; 
		try {
			MutableRepositoryItem interest = (MutableRepositoryItem) mutableRepository.getItemForUpdate(interestId, "interest");
			interest.setPropertyValue("name", interestName);
			interest.setPropertyValue("rating", interestRating);
			mutableRepository.updateItem(interest);
		} catch (RepositoryException e) {
			logDebug("problem with updating interest");
		}
		return checkFormRedirect(getSuccessURL(), null,request, response);
	}
	
	public boolean handleDelete(DynamoHttpServletRequest request,
			DynamoHttpServletResponse response) throws IOException, ServletException {
		MutableRepository mutableRepository = (MutableRepository) repository; 
		try {
			mutableRepository.removeItem(interestId, "interest");
		} catch (RepositoryException e) {
			logDebug("problem with removing interest");
		}
		return checkFormRedirect(getSuccessURL(), null,request, response);
	}


}
