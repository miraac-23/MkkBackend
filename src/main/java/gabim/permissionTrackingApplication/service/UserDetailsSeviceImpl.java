package gabim.permissionTrackingApplication.service;

import gabim.permissionTrackingApplication.entity.EmployeeEntity;
import gabim.permissionTrackingApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsSeviceImpl implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EmployeeEntity> employee = employeeRepository.findByEmail(username);
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        if (employee.isPresent()) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority("ROLE_" + employee.get().getUserType()));
        } else {
            throw new UsernameNotFoundException(username);
        }
        return new User(username, employee.get().getPassword(), grantedAuthoritySet);
    }
}
