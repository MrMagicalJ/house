package com.lwj.house.service.user;

import com.lwj.house.entity.Role;
import com.lwj.house.entity.User;
import com.lwj.house.repository.RoleRepository;
import com.lwj.house.repository.UserRepository;
import com.lwj.house.service.ServiceResult;
import com.lwj.house.web.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务实现类
 * @author lwj
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User findUserByName(String userName) {
        User user = userRepository.findByName(userName);
        if (user == null) {
            return null;
        }
        List<Role> roles = roleRepository.findRolesByUserId(user.getId());
        if (roles == null || roles.isEmpty()) {
            throw new DisabledException("权限非法");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));
        user.setAuthorityList(authorities);

        return user;
    }

    @Override
    public ServiceResult<UserDTO> findById(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ServiceResult.notFound();
        }
        return ServiceResult.of(modelMapper.map(user, UserDTO.class));
    }

}
