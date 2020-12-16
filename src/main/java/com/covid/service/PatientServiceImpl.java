package com.covid.service;

import com.covid.model.Patient;
import com.covid.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void savePatientData(Patient patient) {
        patientRepository.save(patient);
    }
}
