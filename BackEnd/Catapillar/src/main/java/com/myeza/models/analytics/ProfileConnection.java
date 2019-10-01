package com.myeza.models.analytics;

import javax.validation.constraints.NotNull;

import com.myeza.models.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileConnection {

	@NotNull
	private final Profile endOne;

	@NotNull
	private final Profile endTwo;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ProfileConnection)) {
			return false;
		}
		ProfileConnection other = (ProfileConnection) obj;
		if (endOne == null) {
			if (other.endOne != null) {
				return false;
			}
		} else if (endOne.getId().equals(other.endOne.getId())) {
			return endTwo.getId().equals(other.endTwo.getId());
		}
		if (endTwo == null) {
			if (other.endTwo != null) {
				return false;
			}
		} else if (endTwo.equals(other.endOne)) {
			return endOne.getId().equals(other.endTwo.getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endOne == null) ? 0 : endOne.hashCode())
				+ ((endTwo == null) ? 0 : endTwo.hashCode());
		return result;
	}

}
