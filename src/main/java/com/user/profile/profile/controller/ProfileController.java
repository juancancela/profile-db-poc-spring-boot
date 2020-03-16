package com.user.profile.profile.controller;

import com.user.profile.profile.model.Profile;
import com.user.profile.profile.repository.ProfileRepository;
import com.user.profile.profile.service.ProfileProductFilterService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfileController {
    private ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @PostMapping("/profile")
    public @ResponseBody
    Profile addProfile(@RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

    @GetMapping("/profile")
    public @ResponseBody
    List<Profile> getProfile(@RequestParam(value = "email", defaultValue = "", required = false) String email) {
        List<Profile> profiles = new ArrayList<>();
        if (!email.isEmpty()) {
            profiles.add(profileRepository.findByEmail(email));
        } else {
            profiles.addAll(profileRepository.findAll());
        }
        return profiles;
    }

    @GetMapping("/profile/{email}/availableProducts")
    public @ResponseBody
    List<String> getProfileAvailableProducts(@PathVariable(value = "email") String email) {
        Profile profile = profileRepository.findByEmail(email);
        return ProfileProductFilterService.filterProducts(profile);
    }
}