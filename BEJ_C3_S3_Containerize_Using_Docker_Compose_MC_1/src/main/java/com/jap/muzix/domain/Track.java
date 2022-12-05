/*
 * Author Name : Jaswanth Sai
 * Date : 11/24/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.jap.muzix.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Track {

    @Id
    private int trackId;
    private String trackName;
    private int trackRating;
    private List<Artist> trackArtist;

    public Track() {
    }

    public Track(int trackId, String trackName, int trackRating, List<Artist> trackArtist) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackRating = trackRating;
        this.trackArtist = trackArtist;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getTrackRating() {
        return trackRating;
    }

    public void setTrackRating(int trackRating) {
        this.trackRating = trackRating;
    }

    public List<Artist> getTrackArtist() {
        return trackArtist;
    }

    public void setTrackArtist(List<Artist> trackArtist) {
        this.trackArtist = trackArtist;
    }
}
