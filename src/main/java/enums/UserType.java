package enums;

public enum UserType {
    EMPLOYEE {
        @Override
        public String IdSerial() {
            return "E";
        }

        @Override
        public String toString() {
            return "employee";
        }
    },
    CUSTOMER {
        @Override
        public String IdSerial() {
            return "C";
        }

        @Override
        public String toString() {
            return "customer";
        }
    };

    public abstract String IdSerial();
    public abstract String toString();
}
