package miu.ea.repository;

import miu.ea.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface UserRepository extends ListCrudRepository<User, Integer> {

    /**
     * Return all Users by a given selected address.
     */

    List<User> findByAddressId(int addressId);
}
