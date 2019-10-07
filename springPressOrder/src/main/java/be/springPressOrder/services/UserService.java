package be.springPressOrder.services;

import be.springPressOrder.domain.User;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserService {
    User getUserByUsername(String username);

    User saveUser(User user);

    void deleteUser(Integer userId);

    public User getAuthenticatedUser();
}
