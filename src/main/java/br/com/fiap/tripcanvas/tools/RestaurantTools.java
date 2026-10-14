package br.com.fiap.tripcanvas.tools;

import br.com.fiap.tripcanvas.model.Restaurant;
import br.com.fiap.tripcanvas.repository.RestaurantRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantTools {

    private final RestaurantRepository restaurantRepository;

    public RestaurantTools(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Tool(name = "getRestaurants", description = "Obtem a lista de restaurantes de um destino")
    public List<Restaurant> getRestaurants(
            @ToolParam(description = "A localização do restaurante") String location) {
        return restaurantRepository.findByLocation(location);
    }

    @Tool(name = "getAllRestaurants", description = "Obtem a lista de restaurantes ")
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

}
