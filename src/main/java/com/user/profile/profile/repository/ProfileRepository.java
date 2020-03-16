package com.user.profile.profile.repository;

import com.user.profile.profile.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile, Long> {
    Profile findByEmail(String email);
}
