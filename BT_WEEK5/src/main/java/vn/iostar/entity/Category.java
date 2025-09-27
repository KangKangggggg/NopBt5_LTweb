package vn.iostar.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    private String description;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    // Constructors, getters, setters
    public Category() {}
    
    public Category(String name, String description) {
        this.name = name;
        this.setDescription(description);
        this.createdAt = new Date();
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    // Getters and setters
    // ...
}