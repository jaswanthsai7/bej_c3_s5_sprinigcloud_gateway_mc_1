/*
 * Author Name : Jaswanth Sai
 * Date : 11/24/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.jap.muzix.controller;


import com.jap.muzix.domain.Track;
import com.jap.muzix.exception.TrackExistsException;
import com.jap.muzix.exception.TrackNotFoundException;
import com.jap.muzix.service.ITrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v2")
public class TrackController {


    private ITrackService iTrackService;

    public TrackController(ITrackService iTrackService) {
        this.iTrackService = iTrackService;
    }


    @PostMapping("/savetrack")
    public ResponseEntity<?> saveTrack( @RequestBody Track track) throws TrackExistsException {
        try{
            return new ResponseEntity<>(this.iTrackService.saveTrack(track), HttpStatus.CREATED);
        } catch (TrackExistsException e) {
            throw new TrackExistsException();
        }catch (Exception exception){
            return new ResponseEntity<>("Please check Again",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int id) throws TrackNotFoundException {
        try{
            return new ResponseEntity<>(this.iTrackService.deleteTrackById(id), HttpStatus.CREATED);
        } catch (TrackNotFoundException e) {
            throw new TrackNotFoundException();
        }catch (Exception exception){
            return new ResponseEntity<>("Please check Again",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getalltracks")
    public ResponseEntity<?> getAllTracks(){
        try{
            return new ResponseEntity<>(this.iTrackService.getAllTracks(), HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>("Please check Again",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getalltracksbyname/{name}")
    public ResponseEntity<?> getAllTracksByName(@PathVariable String name){
        try{
            return new ResponseEntity<>(this.iTrackService.getAllTracksByArtistName(name), HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>("Please check Again",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getalltracksgreaterthan/{rating}")
    public ResponseEntity<?> getAllTracksRatingGreaterThan(@PathVariable int rating){
        try{
            return new ResponseEntity<>(this.iTrackService.getAllTracksWithRating(rating), HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>("Please check Again",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
