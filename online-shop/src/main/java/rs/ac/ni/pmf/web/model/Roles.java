package rs.ac.ni.pmf.web.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Roles{
	User,
	Admin;
	
	@JsonValue
    public String toValue() {
        //return ordinal();
        return toString();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
