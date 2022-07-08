package Question3;

public enum Status {
    FRESHMAN("Freshman"),
    SOPHOMORE("Sophomore"),
    JUNIOR("Junior"),
    SENIOR("Senior");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}