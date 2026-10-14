package br.com.fiap.tripcanvas.model;

import lombok.Data;

@Data
public class Activity {

    private String title;
    private int duration; // duration in minutes
    private String description;
    private ActivityType type;

}
