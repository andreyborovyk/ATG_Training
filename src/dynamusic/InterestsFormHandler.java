package dynamusic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.transaction.TransactionManager;

import atg.droplet.GenericFormHandler;
import atg.dtm.TransactionDemarcation;
import atg.dtm.TransactionDemarcationException;
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
	private TransactionManager transactionManager; 
	
	private String addInterestSuccessURL;
	private String addinterestErrorURL;
	private String editInterestSuccessURL;
	private String editInterestErrorURL;
	private String deleteInterestSuccessURL;
	private String deleteInterestErrorURL;
	
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
	
	public void setAddInterestSuccessURL(String addInterestSuccessURL) {
		this.addInterestSuccessURL = addInterestSuccessURL;
	}
	
	public String getAddInterestSuccessURL() {
		return addInterestSuccessURL;
	}
	
	public void setAddinterestErrorURL(String addinterestErrorURL) {
		this.addinterestErrorURL = addinterestErrorURL;
	}
	
	public String getAddinterestErrorURL() {
		return addinterestErrorURL;
	}
	
	public void setEditInterestSuccessURL(String editInterestSuccessURL) {
		this.editInterestSuccessURL = editInterestSuccessURL;
	}
	
	public String getEditInterestSuccessURL() {
		return editInterestSuccessURL;
	}
	
	public void setEditInterestErrorURL(String editInterestErrorURL) {
		this.editInterestErrorURL = editInterestErrorURL;
	}
	
	public String getEditInterestErrorURL() {
		return editInterestErrorURL;
	}
	
	public void setDeleteInterestSuccessURL(String deleteInterestSuccessURL) {
		this.deleteInterestSuccessURL = deleteInterestSuccessURL;
	}
	
	public String getDeleteInterestSuccessURL() {
		return deleteInterestSuccessURL;
	}
	
	public void setDeleteInterestErrorURL(String deleteInterestErrorURL) {
		this.deleteInterestErrorURL = deleteInterestErrorURL;
	}
	
	public String getDeleteInterestErrorURL() {
		return deleteInterestErrorURL;
	}
	
	public void setTransactionManager(TransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public TransactionManager getTransactionManager() {
		return transactionManager;
	}
	
	public boolean handleAdd(DynamoHttpServletRequest request,
			DynamoHttpServletResponse response) throws IOException, 	ServletException {
		MutableRepository mutableRepository = (MutableRepository) repository;
		TransactionDemarcation td = new TransactionDemarcation();
		try {
			try {
				td.begin(transactionManager, td.REQUIRED);
				MutableRepositoryItem interest = mutableRepository.createItem("interest");
				interest.setPropertyValue("name", interestName);
				interest.setPropertyValue("rating", interestRating);
				interest.setPropertyValue("user", profile.getDataSource());
				mutableRepository.addItem(interest);
			} finally {
				td.end();
			}
		} catch (RepositoryException e) {
			logError("problem with adding interest");
		} catch (TransactionDemarcationException exc) {
			logError("transaction error during adding new interest");
		}
		return checkFormRedirect(getAddInterestSuccessURL(), null, request,
				response);
	}
	
	public boolean handleEdit(DynamoHttpServletRequest request,
			DynamoHttpServletResponse response) throws IOException, ServletException {
		MutableRepository mutableRepository = (MutableRepository) repository; 
		TransactionDemarcation td = new TransactionDemarcation();
		try {
			try {
				td.begin(transactionManager, td.REQUIRED);
				MutableRepositoryItem interest = (MutableRepositoryItem) mutableRepository
						.getItemForUpdate(interestId, "interest");
				interest.setPropertyValue("name", interestName);
				interest.setPropertyValue("rating", interestRating);
				mutableRepository.updateItem(interest);
			} finally {
				td.end();
			}
		} catch (RepositoryException e) {
			logError("problem with updating interest");
		} catch (TransactionDemarcationException exc) {
			logError("transaction error during editing interest");
		}
		return checkFormRedirect(getEditInterestSuccessURL(), null, request,
				response);
	}
	
	public boolean handleDelete(DynamoHttpServletRequest request,
			DynamoHttpServletResponse response) throws IOException, ServletException {
		MutableRepository mutableRepository = (MutableRepository) repository; 
		TransactionDemarcation td = new TransactionDemarcation();
		try {
			try {
				td.begin(transactionManager, td.REQUIRED);
				mutableRepository.removeItem(interestId, "interest");
			} finally {
				td.end();
			}
		} catch (RepositoryException e) {
			logError("problem with removing interest");
		} catch (TransactionDemarcationException exc) {
			logError("transaction error during adding new interest");
		}
		return checkFormRedirect(getDeleteInterestSuccessURL(), null, request,
				response);
	}

}
