package api.pojo;

public class Users {

    private String name;
    private String job;

    private Users(Builder builder) {
        this.name = builder.name;
        this.job = builder.job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public static class Builder {
        private String name;
        private String job;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setJob(String job) {
            this.job = job;
            return this;
        }

        public Users build() {
            return new Users(this);
        }
    }
}