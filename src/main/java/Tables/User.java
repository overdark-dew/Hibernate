package Tables;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Integer id;
	private String name;
	private Set<User> users = new HashSet<User>();

	public int getId() {
		return id;
	}

	public void setId(Integer user_id) {
		this.id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
