package tn.esprit.entities;

import org.springframework.security.core.GrantedAuthority;

public enum RoleName implements GrantedAuthority {
Company , Employee  ,;

@Override
public String getAuthority() {
	// TODO Auto-generated method stub
	return "Role_"+name();
}

}
