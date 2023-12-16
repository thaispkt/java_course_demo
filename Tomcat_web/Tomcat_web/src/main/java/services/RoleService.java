package services;

import controller.RoleController;
import entity.RoleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.RoleRepository;

import java.util.List;

public class RoleService {
    private RoleRepository roleRepository = new RoleRepository();
    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);
    public boolean addRole(String roleName, String roleDescription) {
        int count = roleRepository.addRole(roleName,roleDescription);
        return count > 0;
    }
    public List<RoleEntity> getAllRoles() {
        logger.info("Calling roleRepository.findAll()");
        return roleRepository.findAll();
    }

    public boolean deleteRole(int id) {
        return roleRepository.deleteByID(id) > 0;
    }
}
