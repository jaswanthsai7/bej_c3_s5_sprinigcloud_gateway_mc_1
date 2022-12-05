/*
 * Author Name : Jaswanth Sai
 * Date : 11/24/2022
 * Created With: INTELLIJ IDEA COMMUNITY EDITION
 */
package com.jap.muzix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Unable to find the given track id")
public class TrackNotFoundException extends Exception {
}
