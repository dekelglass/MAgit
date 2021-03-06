package constants;

import java.io.File;

public class Constants {
    public static final String USERNAME = "username";
    public static final String USER_NAME_ERROR = "username_error";
    public static final String CURRENT_WATCHED_REPOSITORY = "currentWatchedRepository";

    public static final String OTHER_USERNAME = "otherUserName";
    public static final String OTHER_USER_REPOSITORY_NAME = "otherUserRepositoryName";
    public static final String FileName = "fileFullName";
    public static final String FileNewContent = "fileNewContent";
    public static final String COMMIT_MESSAGE = "commitMessage";

    public static final String BRANCH_TO_DELETE_NAME = "branchToDeleteName";
    public static final String BRANCH_TO_CHECKOUT_NAME = "branchToCheckoutName";
    public static final String NEW_BRANCH_NAME= "newBranchName";

    public static final int INT_PARAMETER_ERROR = Integer.MIN_VALUE;

    public static final String usersDirectoryPath = "c:" + File.separator+"magit-ex3";
    public static final String MESSAGES_VERSION_PARAMETER = "messagesVersion";
}