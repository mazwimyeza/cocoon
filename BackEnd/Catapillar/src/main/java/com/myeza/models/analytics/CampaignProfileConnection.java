package com.myeza.models.analytics;

import javax.validation.constraints.NotNull;

import com.myeza.models.Campaign;
import com.myeza.models.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CampaignProfileConnection {

	@NotNull
	private final Campaign endOne;

	@NotNull
	private final Profile endTwo;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endOne == null) ? 0 : endOne.hashCode());
		result = prime * result + ((endTwo == null) ? 0 : endTwo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CampaignProfileConnection)) {
			return false;
		}
		CampaignProfileConnection other = (CampaignProfileConnection) obj;
		if (endOne == null) {
			if (other.endOne != null) {
				return false;
			}
		}
		if (endTwo == null) {
			if (other.endTwo != null) {
				return false;
			}
		}
		return endOne.getId().equals(other.endOne.getId()) && endTwo.getId().equals(other.endTwo.getId());
	}

}
