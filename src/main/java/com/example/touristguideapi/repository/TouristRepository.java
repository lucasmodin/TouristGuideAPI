package com.example.touristguideapi.repository;

import com.example.touristguideapi.model.TouristAttraction;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private final List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        populateTouristAttractions();
    }

    public void populateTouristAttractions() {
        touristAttractions.add(new TouristAttraction("Statens Museum for Kunst", "Danmarks nationalmuseum for kunst"));
        touristAttractions.add(new TouristAttraction("Medicinsk Museion", "Museum med udstillinger vedrørende krop, sundhed og sygdom gennem tiden" ));
        touristAttractions.add(new TouristAttraction("Tivoli", "Danmarks ældste forlystelsespark"));
    }

    public List<TouristAttraction> getTouristAttractions() {
        return touristAttractions;
    }

    public TouristAttraction getTouristAttractionByName(String name) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public TouristAttraction addAttraction(TouristAttraction touristAttraction) {
        touristAttractions.add(touristAttraction);
        return touristAttraction;
    }

   public TouristAttraction updateTouristAttraction(TouristAttraction updatedAttraction) {
        for(TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equalsIgnoreCase(updatedAttraction.getName())) {
                attraction.setName(updatedAttraction.getName());
                attraction.setDescription(updatedAttraction.getDescription());
                return attraction;
            }
        }
        return null;
   }

   public TouristAttraction deleteTouristAttraction(String name) {
        TouristAttraction touristAttraction = getTouristAttractionByName(name);
        touristAttractions.remove(touristAttraction);
        return touristAttraction;
   }



}
