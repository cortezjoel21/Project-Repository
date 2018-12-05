//package app.service.impl;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
//
//import org.springframework.stereotype.Service;
//
//import app.dto.User;
//import app.service.UserService;
//
//@Service("userService")
//public class UserServiceImpl {
//
////	private final AtomicLong counter = new AtomicLong();
//
////	private List<User> users;
////
////	public UserServiceImpl() {
////		this.users = populateDummyUsers();
////	}
////
////	public List<User> findAllUsers() {
////		for (User user : this.users) {
////			System.out.println("=======" + user.getId());
////			System.out.println("=======" + user.getName());
////		}
////		return this.users;
////	}
////
////	public User findById(long id) {
////		for (User user : users) {
////			if (user.getId() == id) {
////				return user;
////			}
////		}
////		return null;
////	}
////
////	public User findByName(String name) {
////		for (User user : users) {
////			if (user.getName().equalsIgnoreCase(name)) {
////				return user;
////			}
////		}
////		return null;
////	}
////
////	public void saveUser(User user) {
//////		Long id = counter.incrementAndGet();
//////		Integer idInt =  id.intValue();
////		Integer idInt = 10;
////		user.setId(idInt);
////		users.add(user);
////	}
////
////	public void updateUser(User user) {
////		int index = users.indexOf(user);
////		users.set(index, user);
////	}
////
////	public void deleteUserById(long id) {
////
////		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
////			User user = iterator.next();
////			if (user.getId() == id) {
////				iterator.remove();
////			}
////		}
////	}
////
////	public boolean isUserExist(User user) {
////		return findByName(user.getName()) != null;
////	}
////
////	public void deleteAllUsers() {
////		users.clear();
////	}
////
////	private List<User> populateDummyUsers() {
////		try {
//////			List<User> users = new ArrayList<User>();
//////			Long id = counter.incrementAndGet();
//////			Integer idInt =  id.intValue();
////			users.add(new User(0, "Sam", 30, 100));
//////			id = counter.incrementAndGet();
//////			idInt =  id.intValue();
////			users.add(new User(1, "Tom", 40, 101));
//////			id = counter.incrementAndGet();
//////			idInt =  id.intValue();
////			users.add(new User(2, "Jerome", 45, 102));
//////			id = counter.incrementAndGet();
//////			idInt =  id.intValue();
////			users.add(new User(3, "Silvia", 50, 103));
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		return users;
////
////	}
////
////	public List<User> getUsers() {
////		return users;
////	}
////
////	public void setUsers(List<User> users) {
////		this.users = users;
////	}
//
//}