package com.movie.check.configuration.customError;

import java.util.function.Supplier;

public class MovieNotFoundException extends Exception {

    public MovieNotFoundException() {
        super();
    }

    public MovieNotFoundException(String message) {
        super(message);
    }
}
