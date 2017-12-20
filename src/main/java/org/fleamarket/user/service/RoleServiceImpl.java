package org.fleamarket.user.service;


import org.fleamarket.user.dao.RoleRepository;
import org.fleamarket.user.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findRoleByName(String role) {
		return roleRepository.findByRole(role);
	}

}
