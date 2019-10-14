package enums;

public enum Roles {
    BRANCH_ADMIN {
        @Override
        public String fileName() {
            return "branchAdmin";
        }

        @Override
        public String ToString() {
            return null;
        }
    },
    PROPERTY_MANAGER {
        @Override
        public String fileName() {
            return "propertyManager";
        }

        @Override
        public String ToString() {
            return null;
        }
    },
    SALES_ASSOCIATE {
        @Override
        public String fileName() {
            return "salesAssociate";
        }

        @Override
        public String ToString() {
            return null;
        }
    };

    public abstract String fileName();
    public abstract String ToString();
}


