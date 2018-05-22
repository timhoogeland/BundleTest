package Services;

public class GroupServiceProvider {
	private static GroupService groupService= new GroupService();

	public static GroupService getGroupService() {
		return groupService;
	}
}
