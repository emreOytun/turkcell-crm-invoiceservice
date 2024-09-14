package com.turkcell.pair3.invoiceservice.services.constants;

public class Messages {

    private Messages() {

    }

    public static class BusinessErrors {
        private BusinessErrors() {

        }

        public static final String ERROR = "Error";
        public static final String NO_CUSTOMER_FOUND = "noCustomerFound";
    }
    public static class ValidationErrors
    {
        private ValidationErrors() {

        }

        public static final String NOT_BLANK = "{validation.notblank}";
        public static final String NOT_NULL = "{validation.notnull}";
        public static final String SIZE = "{validation.size}";
    }
}
