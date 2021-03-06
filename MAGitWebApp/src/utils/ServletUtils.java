package utils;

//import engine.chat.ChatManager;
import constants.Constants;
import engine.chat.ChatManager;
import engine.users.UserManager;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.util.StringTokenizer;

import static constants.Constants.INT_PARAMETER_ERROR;

public class ServletUtils {

	private static final String USER_MANAGER_ATTRIBUTE_NAME = "userManager";
	private static final String CHAT_MANAGER_ATTRIBUTE_NAME = "chatManager";

	/*
	Note how the synchronization is done only on the question and\or creation of the relevant managers and once they exists -
	the actual fetch of them is remained un-synchronized for performance POV
	 */
	private static final Object userManagerLock = new Object();
	private static final Object chatManagerLock = new Object();


	public static UserManager getUserManager(ServletContext servletContext) {
		synchronized (userManagerLock) {
			if (servletContext.getAttribute(USER_MANAGER_ATTRIBUTE_NAME) == null) {
				servletContext.setAttribute(USER_MANAGER_ATTRIBUTE_NAME, new UserManager());
			}
		}
		return (UserManager) servletContext.getAttribute(USER_MANAGER_ATTRIBUTE_NAME);
	}


	public static int getIntParameter(HttpServletRequest request, String name) {
		String value = request.getParameter(name);
		if (value != null) {
			try {
				return Integer.parseInt(value);
			} catch (NumberFormatException numberFormatException) {
			}
		}
		return INT_PARAMETER_ERROR;
	}

	public static String getFixedFileName(String fileNameFromParameter, String userName, String repositoryName) {
		StringTokenizer tokenizer = new StringTokenizer(fileNameFromParameter,"-");
		tokenizer.nextToken(); // skip wc
		tokenizer.nextToken(); // skip accordion
		StringBuilder fileName = new StringBuilder(Constants.usersDirectoryPath + File.separator +
				userName + File.separator + repositoryName);
		while (tokenizer.hasMoreTokens()) {
			fileName.append(File.separator);
			fileName.append(tokenizer.nextToken());
		}

		return fileName.toString();
	}

	public static String getFixedFilePathForAddedFile(String filePathFromParameter, String userName) {
		StringTokenizer tokenizer = new StringTokenizer(filePathFromParameter,"/");
		StringBuilder fileName = new StringBuilder(Constants.usersDirectoryPath + File.separator +
				userName);
		while (tokenizer.hasMoreTokens()) {
			fileName.append(File.separator);
			fileName.append(tokenizer.nextToken());
		}

		return fileName.toString();
	}

	public static String getRRUserNameFromOtherRepositoryPath(String RRPath) {
		String otherUsersName = RRPath.substring(13);
		int endOfOtherUsersName = otherUsersName.indexOf(File.separator);
		otherUsersName = otherUsersName.substring(0,endOfOtherUsersName);

		return otherUsersName;
	}

	public static ChatManager getChatManager(ServletContext servletContext) {
		synchronized (chatManagerLock) {
			if (servletContext.getAttribute(CHAT_MANAGER_ATTRIBUTE_NAME) == null) {
				servletContext.setAttribute(CHAT_MANAGER_ATTRIBUTE_NAME, new ChatManager());
			}
		}
		return (ChatManager) servletContext.getAttribute(CHAT_MANAGER_ATTRIBUTE_NAME);
	}

}
