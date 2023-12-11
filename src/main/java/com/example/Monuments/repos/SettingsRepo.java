package com.example.Monuments.repos;

import com.example.Monuments.domain.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingsRepo extends JpaRepository<Settings,Long> {
}
