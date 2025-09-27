package vn.iostar.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    private String description;
    
    @Column(nullable = false)
    private String url;
    
    private int duration;
    private int views;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    // Constructors, getters, setters
    public Video() {}
    
    public Video(String title, String description, String url, int duration, Category category, User user) {
        this.title = title;
        this.setDescription(description);
        this.url = url;
        this.setDuration(duration);
        this.category = category;
        this.user = user;
        this.setViews(0);
        this.createdAt = new Date();
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
    
    // Getters and setters
    // ...
}