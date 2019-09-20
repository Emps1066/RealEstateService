package enums;

public enum PropertyListType {
    RENTAL {
        @Override
        public String toString() {
            return "Rental";
        }
    },
    FOR_SALE {
        @Override
        public String toString() {
            return "ForSale";
        }
    };

    public abstract String toString();
}
