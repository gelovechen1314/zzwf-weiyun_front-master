package cn.windy.kernel.service;

import cn.windy.kernel.model.Role;
import cn.windy.kernel.repository.RoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRoleService extends IBaseService<Role,RoleRepository> {

    Page<Role> findByUser(Role role , Pageable pageable);

    void deleteByIds(Long[] ids);

    void savePermission(String roleId,String ids);

}
