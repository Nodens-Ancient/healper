package subscribe;

import framework.utils.ModelGenerator;
import framework.utils.PropertiesReader;
import models.users.UserModel;
import subscribe.exceptions.NoUserWithIdException;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class UserSubscribeControl {
    private static final File USERS_BASE = new File(PropertiesReader.getValue("USERS_CONFIG_FILE"));
    private static List<UserModel> users;

    public static List<UserModel> getUsers() {
        updateUsersList();
        return users;
    }

    private static void updateUsersList() {
        UserModel[] usersArray = ModelGenerator.getModelByMappingXml(USERS_BASE, UserModel[].class);
        users = Arrays.asList(usersArray);
    }

    public static UserModel getUserById(String id) {
        return getUsers().stream().
                filter(user -> user.getId().equals(id)).findAny().orElse(null);
    }

    public static boolean getSubscribeStatusOfUser(String id) {
        return getUserById(id).getSubscribeStatus();
    }
}
