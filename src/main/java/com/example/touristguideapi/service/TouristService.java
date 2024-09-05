package com.example.touristguideapi.service;

import com.example.touristguideapi.model.TouristAttraction;
import com.example.touristguideapi.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }


    public List<TouristAttraction> getAllTouristAttractions() {
        return touristRepository.getTouristAttractions();
    }

    public TouristAttraction getTouristAttractionByName(String name) {
        return touristRepository.getTouristAttractionByName(name);
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        return touristRepository.addAttraction(touristAttraction);
    }

    public TouristAttraction updateAttraction(TouristAttraction touristAttraction) {
        TouristAttraction existingAttraction = touristRepository.getTouristAttractionByName(touristAttraction.getName());

        if (existingAttraction != null) {
            existingAttraction.setName(touristAttraction.getName());
            existingAttraction.setDescription(touristAttraction.getDescription());
            return touristRepository.updateTouristAttraction(existingAttraction);
        }
        return null;
    }

    public TouristAttraction deleteTouristAttraction(String name) {
        return touristRepository.deleteTouristAttraction(name);
    }

}
