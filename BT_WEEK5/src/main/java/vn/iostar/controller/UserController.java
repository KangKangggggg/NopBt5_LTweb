package vn.iostar.controller;

import vn.iostar.entity.User;
import vn.iostar.service.UserService;
import java.util.List;
import java.util.Scanner;

public class UserController {
    
    private final UserService userService;
    private final Scanner scanner;
    
    public UserController() {
        this.userService = new UserService();
        this.scanner = new Scanner(System.in);
    }
    
    public void showMenu() {
        while (true) {
            System.out.println("\n=== QUẢN LÝ USER ===");
            System.out.println("1. Hiển thị tất cả users");
            System.out.println("2. Tìm user theo ID");
            System.out.println("3. Thêm user mới");
            System.out.println("4. Cập nhật user");
            System.out.println("5. Xóa user");
            System.out.println("6. Tìm kiếm user theo tên");
            System.out.println("7. Tìm user theo role");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    showAllUsers();
                    break;
                case 2:
                    findUserById();
                    break;
                case 3:
                    addUser();
                    break;
                case 4:
                    updateUser();
                    break;
                case 5:
                    deleteUser();
                    break;
                case 6:
                    searchUsersByName();
                    break;
                case 7:
                    findUsersByRole();
                    break;
                case 0:
                    userService.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    
    private void findUsersByRole() {
		// TODO Auto-generated method stub
		
	}

	private void deleteUser() {
		// TODO Auto-generated method stub
		
	}

	private void updateUser() {
		// TODO Auto-generated method stub
		
	}

	private void showAllUsers() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            System.out.println("Không có user nào!");
        } else {
            System.out.println("\nDanh sách users:");
            users.forEach(user -> {
                System.out.printf("ID: %d, Username: %s, FullName: %s, Email: %s, Role: %s%n",
                    user.getId(), user.getUsername(), user.getFullName(), user.getEmail(), user.getRole());
            });
        }
    }
    
    private void findUserById() {
        System.out.print("Nhập ID user: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        
        userService.findById(id).ifPresentOrElse(
            user -> System.out.printf("Tìm thấy: %s - %s%n", user.getUsername(), user.getFullName()),
            () -> System.out.println("Không tìm thấy user với ID: " + id)
        );
    }
    
    private void addUser() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Role: ");
        String role = scanner.nextLine();
        
        User user = new User(username, password, fullName, email, role);
        User savedUser = userService.save(user);
        System.out.println("Thêm user thành công với ID: " + savedUser.getId());
    }
    
    private void searchUsersByName() {
        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = scanner.nextLine();
        
        List<User> users = userService.searchByFullName(keyword);
        if (users.isEmpty()) {
            System.out.println("Không tìm thấy user nào phù hợp!");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            users.forEach(user -> {
                System.out.printf("ID: %d, Username: %s, FullName: %s%n",
                    user.getId(), user.getUsername(), user.getFullName());
            });
        }
    }
    
    // Các phương thức khác...
}