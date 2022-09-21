package com.kurdsoft.yakaveh.common.exceptions;

import java.util.Date;

public class ErrDetails {

        private Date timestamp;
        private String message;
        private String details;

        public ErrDetails(Date timeStamp, String message, String details) {
            super();
            this.timestamp = timeStamp;
            this.message = message;
            this.details = details;
        }
    }
