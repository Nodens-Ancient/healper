package models.users;

public class UserModel {
    private String name;
    private String id;
    private String apiCode;
    private boolean subscribeStatus;
    private String discription;

    public String getId() {
        return id;
    }

    public String getApiCode() {
        return apiCode;
    }

    public boolean getSubscribeStatus() {
        return subscribeStatus;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }
}
