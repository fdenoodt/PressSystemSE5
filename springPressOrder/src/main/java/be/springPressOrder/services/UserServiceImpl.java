package be.springPressOrder.services;

import be.springPressOrder.dao.UserRepository;
import be.springPressOrder.domain.Technician;
import be.springPressOrder.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService{

    private PressSystemService pressSystemService;

    private UserRepository userRepository;

    @Autowired
    private void setPressSystemService(PressSystemService pressSystemService){this.pressSystemService = pressSystemService;}

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(User client) {
        return userRepository.save(client);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.delete(userId);
    }

    @Override
    public User getAuthenticatedUser() {

        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();
        System.out.println("DEBUG: Username uit Principal is "+username);

        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority authority : authorities){
            System.out.println("DEBUG: Granted authority is "+authority.getAuthority());
        }
        User user = pressSystemService.getUserByName(username);
        return user;
    }
}
