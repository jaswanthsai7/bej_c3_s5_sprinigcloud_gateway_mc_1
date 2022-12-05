/*
 * Author Name : Jaswanth Sai
 * Date : 11/24/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.jap.muzix.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Artist {

    @MongoId
    private int artistId;
    private String artistName;

    public Artist() {
    }

    public Artist(int artistId, String artistName) {
        this.artistId = artistId;
        this.artistName = artistName;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "Artist{" + "artistId=" + artistId + ", artistName='" + artistName + '\'' + '}';
    }
}
