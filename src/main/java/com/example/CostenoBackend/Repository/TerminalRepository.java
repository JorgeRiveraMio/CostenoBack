package com.example.CostenoBackend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CostenoBackend.Models.Terminal;


public interface TerminalRepository extends JpaRepository<Terminal,Integer>{
    
}
