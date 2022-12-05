/*
 * Author Name : Jaswanth Sai
 * Date : 11/24/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.jap.muzix.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "track with the given id already exists")
public class TrackExistsException extends Exception {
}
