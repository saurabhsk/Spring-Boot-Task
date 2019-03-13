//Application should allow all the users to perform thefollowing activities:
// a.Save track information such as trackId,trackName, comments of the track.
// b.Display saved track.
// c. Update comments of saved track.
// d.Remove track
package com.stackroute.MuzixApp.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Muzix {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trackId;
    private String trackName;
    private String comments;

//    public Muzix(String trackName, String comments) {
//      //  this.trackId = trackId;
//        this.trackName = trackName;
//        this.comments = comments;
//    }
//
//    public Muzix() {
//    }
//
//    public int getTrackId() {
//        return trackId;
//    }
//
//    public void setTrackId(int trackId) {
//        this.trackId = trackId;
//    }
//
//    public String getTrackName() {
//        return trackName;
//    }
//
//    public void setTrackName(String trackName) {
//        this.trackName = trackName;
//    }
//
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
}

