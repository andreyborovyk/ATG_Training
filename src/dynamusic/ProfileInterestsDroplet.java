package dynamusic;

import java.util.HashSet;
import java.util.Set;

import atg.droplet.ForEach;
import atg.repository.RepositoryItem;
import atg.servlet.DynamoHttpServletRequest;

public class ProfileInterestsDroplet extends ForEach {

	@Override
	public Object getArray(DynamoHttpServletRequest pReq) {
		Set<RepositoryItem> interests= (Set<RepositoryItem>) pReq.getObjectParameter(ARRAY);
		int filter;
		if(pReq.getLocalParameter("filter") == null) {
			return interests;
		} else {
			filter = Integer.parseInt((String) pReq.getLocalParameter("filter"));
		}
		
		Set<RepositoryItem> resultedInterests = new HashSet<RepositoryItem> ();
		
		if (filter == 2) {
			return interests;
		}
		
		for( RepositoryItem interest : interests) {
			if (Integer.parseInt((String) interest.getPropertyValue("rating"))  % 2 == filter) {
				resultedInterests.add(interest);
			}
		}
		return resultedInterests;
	}

}
