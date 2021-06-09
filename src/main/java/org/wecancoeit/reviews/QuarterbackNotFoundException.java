package org.wecancoeit.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "Bad Request, Quarterback Not Found!")
public class QuarterbackNotFoundException extends Exception {
}
