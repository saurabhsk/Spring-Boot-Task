//Application should allow all the users to perform thefollowing activities:
// a.Save track information such as trackId,trackName, comments of the track.
// b.Display saved track.
// c. Update comments of saved track.
// d.Remove track
package com.stackroute.MuzixApp.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Muzix {

    @Id
    private String trackId;         //instance variables
    private String trackName;
    private String comments;
}

