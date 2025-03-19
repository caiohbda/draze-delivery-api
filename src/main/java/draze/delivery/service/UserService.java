package draze.delivery.service;

import draze.delivery.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
