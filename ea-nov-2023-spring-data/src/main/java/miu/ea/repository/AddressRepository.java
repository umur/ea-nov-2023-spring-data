package miu.ea.repository;

import miu.ea.entity.Address;
import miu.ea.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Integer> {

    /**
     * Return all addresses by a given selected user.
     */

    List<Address> findByUserId(int userId);
}
