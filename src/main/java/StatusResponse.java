public enum StatusResponse {

    SUCCESS ("Success"),
    ERROR ("Error");

    StatusResponse (String status){
        this.status = status;
    }

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}