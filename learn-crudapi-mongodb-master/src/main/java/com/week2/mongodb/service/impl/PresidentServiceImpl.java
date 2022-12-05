package com.week2.mongodb.service.impl;

import com.week2.mongodb.model.Presiden;
import com.week2.mongodb.repository.PresidenRepository;
import com.week2.mongodb.service.PresidenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.week2.mongodb.exception.ResourceNotFoundException;

import javax.management.relation.RoleInfoNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class PresidentServiceImpl implements PresidenService {

    @Autowired
    private PresidenRepository presidenRepository;

    private static Map<String, String> presidenMap = new HashMap<String, String>();
    static {
        presidenMap.put("nama", "vladimir putin");
        presidenMap.put("umur", "57");
        presidenMap.put("berat_badan", "77");
        presidenMap.put("tinggi_badan", "187");
        presidenMap.put("sebelum_jadipresiden", "panglima perang");
    }

    @Override
    public Presiden createPresiden(Presiden presidenMap) {
        return presidenRepository.save(presidenMap);
    }

    @Override
    public Presiden updatePresiden(Presiden presiden) {

        Optional<Presiden> presidenOptional = presidenRepository.findById(presiden.getId());

        if (presidenOptional.isPresent()) {
            Presiden presidenUpdate = presidenOptional.get();
            presidenUpdate.setNama(presiden.getNama());
            presidenUpdate.setUmur(presiden.getUmur());
            presidenUpdate.setTinggi_badan(presiden.getTinggi_badan());
            presidenUpdate.setBerat_badan(presiden.getBerat_badan());
            presidenUpdate.setSebelum_jadipresiden(presiden.getSebelum_jadipresiden());
            presidenRepository.save(presidenUpdate);
            return presidenUpdate;

        } else {
            throw new ResourceNotFoundException("gagal");
        }

    }

    @Override
    public List<Presiden> getAllPresiden() {
        return this.presidenRepository.findAll();
    }

    @Override
    public Presiden getPresidenById(Long presidenId) {
        Optional<Presiden> presidenOptional = presidenRepository.findById(presidenId);

        if (presidenOptional.isPresent()) {
            return presidenOptional.get();
        } else {
            throw new ResourceNotFoundException("gagal");
        }
    }

    @Override
    public Presiden deletePresiden(Long id) {
        Optional<Presiden> presidenOptional = presidenRepository.findById(id);

        if (presidenOptional.isPresent()) {
            this.presidenRepository.delete(presidenOptional.get());
        } else {
            throw new ResourceNotFoundException("gagal");
        }
        return null;
    }

}
