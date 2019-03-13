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
    private int trackId;         //instance variables
    private String trackName;
    private String comments;
}

