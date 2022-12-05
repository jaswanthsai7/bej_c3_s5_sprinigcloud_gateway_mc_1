package com.jap.muzix.repository;

import com.jap.muzix.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {

    //    @Query("{trackRating:{$gte:[?0]}}")
    List<Track> findByTrackRatingGreaterThan(int rating);

    @Query("{'trackArtist.artistName':{$in:[?0]}}")
    List<Track> findAllTrackArtistName(String name);

}
