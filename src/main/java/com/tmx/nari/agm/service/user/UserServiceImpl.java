package com.tmx.nari.agm.service.user;


import com.tmx.nari.agm.config.PasswordEncoder;
import com.tmx.nari.agm.entity.user.User;
import com.tmx.nari.agm.model.exeption.ErrorCode;
import com.tmx.nari.agm.model.exeption.ServiceException;
import com.tmx.nari.agm.model.request.user.CreateUserModel;
import com.tmx.nari.agm.model.request.user.UpdateUserModel;
import com.tmx.nari.agm.model.request.user.CreatePasswordRequest;
import com.tmx.nari.agm.model.user.NariUserDetails;
import com.tmx.nari.agm.model.user.UserModel;
import com.tmx.nari.agm.repositoy.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by Harutyun Badeyan
 * Date: 14.09.22
 * Time: 20:56
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repository;

    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserModel create(final CreateUserModel model) {
        Assert.notNull(model, "model must not be null");
        User user = model.toEntity();
        user = repository.save(user);
        return UserModel.from(user);
    }

    @Override
    @Transactional
    public UserModel update(final UUID id, final UpdateUserModel model) {
        Assert.notNull(id, "Id cannot be null");
        Assert.notNull(model, "model must not be null");
        User user = getEntityById(id);
        user = repository.save(model.toEntity(user));
        return UserModel.from(user);
    }

    @Transactional
    public User getEntityById(final UUID id) {
        return repository
                .findById(id)
                .orElseThrow(ServiceException::new);
    }

    @Override
    @Transactional
    public UserModel getById(final UUID id) {
        return UserModel.from(getEntityById(id));
    }

    @Override
    @Transactional
    public void delete(final UUID id) {
        Assert.notNull(id, "Id cannot be null");
        repository.findById(id)
                .ifPresent(user -> repository.deleteById(id));
    }

    @Override
    @Transactional
    public void changePassword(
            final UUID id,
            final CreatePasswordRequest request) {
        User user = getEntityById(id);
        if (Objects.equals(request.getNewPassword(), request.getRepeatedNewPass())
                && !PasswordEncoder.isPasswordMatch(request.getNewPassword(),
                user.getPassword())) {
            user.setPassword(PasswordEncoder.encode(request.getNewPassword()));
            repository.save(user);
        } else throw new ServiceException("bad request", ErrorCode.UNEXPECTED);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = repository.findByEmail(username)
                .orElseThrow(() -> new ServiceException(
                        "no user",ErrorCode.NOT_EXIST)
                );
        return NariUserDetails.from(user);
    }
}
