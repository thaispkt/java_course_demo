package services;

import entity.RoleEntity;
import repository.RoleRepository;

import java.util.List;

public class RoleService {
    private RoleRepository roleRepository = new RoleRepository();
    public boolean addRole(String roleName, String roleDescription) {
        int count = roleRepository.addRole(roleName,roleDescription);
        return count > 0;
    }
    public List<RoleEntity> getAllRoles() {
        System.out.println("In callee: public List<RoleEntity> getAllRoles()");
        System.out.println("Call: return roleRepository.findAll()");
        return roleRepository.findAll();
    }

    public boolean deleteRole(int id) {
        return roleRepository.deleteByID(id) > 0;
    }
}
